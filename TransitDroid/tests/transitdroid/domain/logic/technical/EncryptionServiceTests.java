/**
 * 
 */
package transitdroid.domain.logic.technical;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import transitdroid.domain.core.BaseInputMapper;
import transitdroid.domain.core.MapperRepository;
import transitdroid.domain.entities.user.User;
import transitdroid.domain.entities.user.UserOutputMapper;
import transitdroid.domain.logic.technical.exceptions.EncryptionException;

public class EncryptionServiceTests {

	
	@Test
	public void authenticateMultipleKeysTest() throws NoSuchAlgorithmException,
			InvalidKeySpecException {
		byte[] salt = EncryptionService.generateSalt();
		ArrayList<String> keys = new ArrayList<String>();
		keys.add("jkfld;sajfdsahf");
		keys.add("fdksal;fdjsa");
		keys.add("fdsjkalf;dsah");
		keys.add("fjkdlsa;fdsn");
		ArrayList<byte[]> eKeys = new ArrayList<byte[]>();
		for (String key : keys) {
			eKeys.add(EncryptionService.encryptPassword(key, salt));
		}
		assertTrue(EncryptionService.authenticate(salt, keys, eKeys));
		byte[] failKey = EncryptionService.encryptPassword("fjdksl;afsdayb",
				salt);
		eKeys.set(2, failKey);
		assertFalse(EncryptionService.authenticate(salt, keys, eKeys));
	}

	@Test
	public void testMultipleByteArrayKeys() throws NoSuchAlgorithmException,
			EncryptionException {
		byte[] salt = EncryptionService.generateSalt();
		ArrayList<byte[]> keys = new ArrayList<byte[]>();
		keys.add(EncryptionService.generateSalt());
		keys.add(EncryptionService.generateSalt());
		keys.add(EncryptionService.generateSalt());
		keys.add(EncryptionService.generateSalt());
		ArrayList<String> eKeys = new ArrayList<String>();
		for (byte[] key : keys) {
			eKeys.add(EncryptionService.encryptToString(key, salt));
		}
		assertTrue(EncryptionService.authenticate(eKeys, keys, EncryptionService.encode(salt)));
	}

	@SuppressWarnings({ "unchecked" })
	@Test
	public void testMapperRepository() {
		BaseInputMapper<User> mapper = (BaseInputMapper<User>) MapperRepository
				.getInputMapper(User.class);
		BaseInputMapper<User> mapper3 = (BaseInputMapper<User>) MapperRepository
				.getInputMapper(User.class);
		UserOutputMapper mapper2 = (UserOutputMapper) MapperRepository
				.getOutputMapper(User.class);
		System.out.println(mapper.getClass().getName());
		System.out.println(mapper2.getClass().getName());
		System.out.println(mapper);
		System.out.println(mapper3);
		System.out.println(mapper2);
	}

	@Test
	public void testGenerateKey() throws NoSuchAlgorithmException, EncryptionException {
		
		byte[] toEncrypt = new byte[10];
		Key salt = EncryptionService.generateKey();
		byte[] encrypt = EncryptionService.encrypt(toEncrypt, salt);
		

		Assert.assertEquals(toEncrypt, EncryptionService.decrypt(encrypt, salt.getEncoded()));
		//Assert.assertEquals(toEncrypt, EncryptionService.decrypt(encrypt, salt));

	}
	
	
}
