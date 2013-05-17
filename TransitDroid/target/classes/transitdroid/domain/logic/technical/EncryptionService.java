package transitdroid.domain.logic.technical;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import sun.misc.*;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import transitdroid.domain.logic.technical.exceptions.AuthenticationException;
import transitdroid.domain.logic.technical.exceptions.EncryptionException;

/**
 * @author TransitDroid Team
 * @class EncryptionService
 * 
 *  Provides functionality for encryption and decryption.

 * 
 */
public class EncryptionService {

	/** 
	 * Verifies that the String 'original' is the original representation for
	 * the byte[] 'encrypted'.
	 * 
	 * @param original
	 *            The original string that must be tested for authenticity.
	 * @param encrypted
	 *            The encrypted string to match.
	 * @param salt
	 *            The salt used to encrypt the string initially.
	 * @param alg
	 *            The encryption algorithm used to encrypt the string initially.
	 * @return true if the original is the decrypted String representation of
	 *         'encrypted' and false otherwise.
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public static boolean authenticate(String original, byte[] encrypted,
			byte[] salt, EncryptionAlgorithm alg)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		byte[] encryptedAttemptedPassword = encryptPassword(original, salt, alg);
		return Arrays.equals(encrypted, encryptedAttemptedPassword);
	}

	/** 
	 * Verifies that the String 'original' is the original representation for
	 * the byte[] 'encrypted' using the default algorithm PBKDF2WithHmacSHA1.
	 * 
	 * @param original
	 *            The original string that must be tested for authenticity.
	 * @param encrypted
	 *            The encrypted string to match.
	 * @param salt
	 *            The salt used to encrypt the string initially.
	 * @return if the original is the decrypted String representation of
	 *             'encrypted' and false otherwise.
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws AuthenticationException 
	 */
	public static void authenticate(String original, byte[] encrypted,
			byte[] salt) throws NoSuchAlgorithmException,
			InvalidKeySpecException, AuthenticationException {
		if (!authenticate(original, encrypted, salt, EncryptionAlgorithm.SHA1)){
			throw new AuthenticationException();
		}
	}
	

	/**
	 * Verifies that each of the Strings in 'originals' match the decrypted
	 * byte[] in 'encrypted' with the same index. The default algorithm
	 * 'PBKDF2WithHmacSHA1' is used.
	 * 
	 * @param salt
	 *            The salt used to encrypt the string initially.
	 * @param originals
	 *            The original strings that must be tested for authenticity.
	 * @param encrypted
	 *            The encrypted strings to match.
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public static boolean authenticate(byte[] salt, List<String> originals,
			List<byte[]> encrypted) throws NoSuchAlgorithmException,
			InvalidKeySpecException {
		Iterator<String> oit = originals.iterator();
		Iterator<byte[]> eit = encrypted.iterator();
		String original = null;
		byte[] encrypt = null;
		while (oit.hasNext()) {
			original = oit.next();
			encrypt = eit.next();
			try {
				authenticate(original, encrypt, salt);
			} catch (AuthenticationException e) {
				return false;
			}
		}
		return true;
	}

	/** 
	 * Encrypts the String original to a byte[] using the salt and algorithm
	 * passed in the parameters
	 * 
	 * @param toEncrypt
	 *            The original string that must be tested for authenticity.
	 * @param salt
	 *            The salt used to encrypt the string initially.
	 * @param alg
	 *            The encryption algorithm to use.
	 * @return The encrypted byte[].
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public static byte[] encryptPassword(String toEncrypt, byte[] salt,
			EncryptionAlgorithm alg) throws NoSuchAlgorithmException,
			InvalidKeySpecException {
		int derivedKeyLength = 160;
		int iterations = 20000;

		KeySpec spec = new PBEKeySpec(toEncrypt.toCharArray(), salt,
				iterations, derivedKeyLength);
		SecretKeyFactory f = SecretKeyFactory.getInstance(alg.toString());
		return f.generateSecret(spec).getEncoded();
	}

	/** 
	 * Encrypts the String original to a byte[] using the salt and the default
	 * Algorithm PBKDF2WithHmacSHA1.
	 * 
	 * @param toEncrypt
	 *            The original string that must be tested for authenticity.
	 * @param salt
	 *            The salt used to encrypt the string initially.
	 * @return The encrypted byte[].
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public static byte[] encryptPassword(String toEncrypt, byte[] salt)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		return encryptPassword(toEncrypt, salt, EncryptionAlgorithm.SHA1);
	}

	/** Generates a random byte[8] to be used as the salt for the default
	 * algorithm.
	 * 
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static byte[] generateSalt() throws NoSuchAlgorithmException {
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");

		// Generate a 8 byte (64 bit) salt as recommended by RSA PKCS5
		byte[] salt = new byte[8];
		random.nextBytes(salt);
		return salt;
	}

	/** Generates a java.security.Key using the 'DES' algorithm.
	 * 
	 * @return The newly generated Key.
	 * @throws NoSuchAlgorithmException
	 */
	public static Key generateKey() throws NoSuchAlgorithmException {
		KeyGenerator generator;
		generator = KeyGenerator
				.getInstance(EncryptionAlgorithm.DES.toString());
		generator.init(new SecureRandom());
		return generator.generateKey();
	}

	@SuppressWarnings("restriction")
	public static String encode(byte[] raw){
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(raw);
	}
	
	@SuppressWarnings("restriction")
	public static byte[] decode(String raw) throws IOException{
		BASE64Decoder decoder = new BASE64Decoder();
		return decoder.decodeBuffer(raw);
	}
	/**
	 * 
	 * @param toEncrypt
	 *            The original string that must be tested for authenticity.
	 * @param salt
	 *            The salt used to encrypt the string initially.
	 * @return The encrypted byte[].
	 * @throws EncryptionException 
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws UnsupportedEncodingException
	 */
	public static byte[] encrypt(byte[] toEncrypt, Key salt) throws EncryptionException {
		// Get a cipher object.
		byte[] raw = null;
		try {
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, salt);

			raw = cipher.doFinal(toEncrypt);
			
			
		} catch (NoSuchAlgorithmException e) {
			throw new EncryptionException(e);
		} catch (InvalidKeyException e) {
			throw new EncryptionException(e);
		} catch (NoSuchPaddingException e) {
			throw new EncryptionException(e);
		} catch (IllegalBlockSizeException e) {
			throw new EncryptionException(e);
		} catch (BadPaddingException e) {
			throw new EncryptionException(e);
		}
		return raw;
	}
	
	public static byte[] encrypt(byte[] toEncrypt, byte[] rawSaltKey) throws EncryptionException{
		byte[] result = null;
		Key salt = new SecretKeySpec(rawSaltKey, 0, rawSaltKey.length,
				EncryptionAlgorithm.DES.toString());
		try {
		Cipher cipher = Cipher.getInstance(EncryptionAlgorithm.DES.toString());
		cipher.init(Cipher.ENCRYPT_MODE, salt);

		result = cipher.doFinal(toEncrypt);
		} catch (NoSuchAlgorithmException e) {
			throw new EncryptionException(e);
		} catch (InvalidKeyException e) {
			throw new EncryptionException(e);
		} catch (NoSuchPaddingException e) {
			throw new EncryptionException(e);
		} catch (IllegalBlockSizeException e) {
			throw new EncryptionException(e);
		} catch (BadPaddingException e) {
			throw new EncryptionException(e);
		}
		return result;
	}
	
	public static String encryptToString(byte[] toEncrypt, byte[] rawSaltKey) throws EncryptionException{		
		byte[] raw = encrypt(toEncrypt, rawSaltKey);
		// converts to base64 for easier display.
		return encode(raw);
	}

	/** Decrypts a String encrypted encrypted by the encrypt(String, Key)
	 * function.
	 * 
	 * @param encryptedVersion
	 *            The encrypted string
	 * @param rawSaltKey
	 *            The byte[] representation of the Key used in encryption.
	 * @return The decrypted String.
	 * @throws EncryptionException 
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws IOException
	 */
	public static byte[] decrypt(byte[] encryptedVersion, byte[] rawSaltKey) throws EncryptionException {
		// Get a cipher object.
		byte[] result = null;
		Key salt = new SecretKeySpec(rawSaltKey, 0, rawSaltKey.length,
				EncryptionAlgorithm.DES.toString());

		Cipher cipher;
		
		
		//decode the BASE64 coded message
		//BASE64Decoder decoder = new BASE64Decoder();
		//byte[] raw = decoder.decodeBuffer(encrypted);
		
		try {
			cipher = Cipher.getInstance(EncryptionAlgorithm.DES.toString());

			cipher.init(Cipher.DECRYPT_MODE, salt);

			result = cipher.doFinal(encryptedVersion);

		} catch (NoSuchAlgorithmException e) {
			throw new EncryptionException(e);
		} catch (NoSuchPaddingException e) {
			throw new EncryptionException(e);
		} catch (IllegalBlockSizeException e) {
			throw new EncryptionException(e);
		} catch (BadPaddingException e) {
			throw new EncryptionException(e);
		} catch (InvalidKeyException e) {
			throw new EncryptionException(e);
		}
//		If you want to return a string
//		String clear = new String(stringBytes, "UTF8");
//		return clear;
		
		
		return result;
	}

	public static byte[] decrypt(String encryptedString, String rawSaltKeyString) throws EncryptionException {
		byte[] result = null;		
		try {
			byte[] rawSaltKey = decode(rawSaltKeyString);
			byte[] encryptedVersion = decode(encryptedString);
			Key salt = new SecretKeySpec(rawSaltKey, 0, rawSaltKey.length,
					EncryptionAlgorithm.DES.toString());

			result = decrypt(encryptedVersion, salt);

		} catch (IOException e) {
			throw new EncryptionException(e);
		}
//		If you want to return a string
//		String clear = new String(stringBytes, "UTF8");
//		return clear;
		return result;
	}
	/** Decrypts a String encrypted encrypted by the encrypt(String, Key)
	 * function.
	 * 
	 * @param encryptedVersion
	 *            The encrypted string
	 * @param keyData
	 *            The byte[] representation of the Key used in encryption.
	 * @return The decrypted String.
	 * @throws EncryptionException 
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws IOException
	 */
	public static byte[] decrypt(byte[] encryptedVersion, Key salt) throws EncryptionException {
		// Get a cipher object.
		byte[] result = null;

		Cipher cipher;
		try {
			cipher = Cipher.getInstance(EncryptionAlgorithm.DES.toString());

			cipher.init(Cipher.DECRYPT_MODE, salt);

			result = cipher.doFinal(encryptedVersion);

		} catch (NoSuchAlgorithmException e) {
			throw new EncryptionException(e);
		} catch (NoSuchPaddingException e) {
			throw new EncryptionException(e);
		} catch (InvalidKeyException e) {
			throw new EncryptionException(e);
		} catch (IllegalBlockSizeException e) {
			throw new EncryptionException(e);
		} catch (BadPaddingException e) {
			throw new EncryptionException(e);
		}
		return result;
	}
	
	public static List<String> encryptListOfBytes(List<byte[]> origonal, byte[] salt) throws EncryptionException{
		List<String> encrypted = new ArrayList<String>();
		for (byte[] key : origonal){
			encrypted.add(encryptToString(key, salt));
		}
		return encrypted;
	}
	/** a Collection of encryption algorithms.
	 * 
	 * @author TransitDroid Team
	 * 
	 */
	public static enum EncryptionAlgorithm {
		SHA1("PBKDF2WithHmacSHA1"), DES("DES");

		private final String algorithm;

		private EncryptionAlgorithm(String algorithm) {
			this.algorithm = algorithm;
		}

		public String toString() {
			return algorithm;
		}
	}
	public static boolean authenticate(List<String> encrypted, List<byte[]> original, String salt) throws EncryptionException{
		int i = 0;
		for (byte[] org : original){
			byte[] saltBytes = null;
			try {
				saltBytes = decode(salt);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Contract Key: "+encryptToString(org, saltBytes));
			System.out.println("Phone Key: "+encrypted.get(i));
			if (!Arrays.equals(org, decrypt(encrypted.get(i), salt))){
				return false;
			}
			i++;
		}
		return true;
	}
}
