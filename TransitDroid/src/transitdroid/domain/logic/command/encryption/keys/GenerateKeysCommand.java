package transitdroid.domain.logic.command.encryption.keys;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import transitdroid.domain.logic.command.ICommand;
import transitdroid.domain.logic.technical.EncryptionService;
import transitdroid.domain.logic.technical.exceptions.EncryptionException;

public class GenerateKeysCommand implements ICommand{
	private  List<byte[]> originals = new ArrayList<byte[]>();
	private List<String> encrypted = new ArrayList<String>();
	private String saltString;
	private byte[] salt;
	
	@Override
	public void execute() {
		try {
			salt = EncryptionService.generateKey().getEncoded();
			List<GetKey> keys = new ArrayList<GenerateKeysCommand.GetKey>();
			keys.add(new GetKey(salt));
			keys.add(new GetKey(salt));
			keys.add(new GetKey(salt));
			keys.add(new GetKey(salt));
			for(GenerateKeysCommand.GetKey key : keys){
				key.run();
				//TODO: remove println
				System.out.println(key.encrypted);
				System.out.println(EncryptionService.encryptToString(key.original, key.salt));
			}
			for (GenerateKeysCommand.GetKey key : keys){
				originals.add(key.original);
				encrypted.add(key.encrypted);
			}
			this.saltString = keys.get(0).saltString;
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (EncryptionException e) {
			e.printStackTrace();
		}
		
	}

	public List<byte[]> getOriginals() {
		return originals;
	}

	public List<String> getEncrypted() {
		return encrypted;
	}
	
	public String getSaltString(){
		return this.saltString;
	}
	
	public byte[] getSalt(){
		return salt;
	}
	protected class GetKey implements Runnable{
		private byte[] original;
		private String encrypted;
		private byte[] salt;
		private String saltString;
		
		private GetKey(byte[] salt){
			this.salt = salt;
		}
		@Override
		public void run() {
			try {
				original = EncryptionService.generateSalt();
				byte[] encryptedBytes = EncryptionService.encrypt(original, salt);
				encrypted = EncryptionService.encode(encryptedBytes);
				saltString = EncryptionService.encode(salt);
			} catch (EncryptionException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
	}
}
