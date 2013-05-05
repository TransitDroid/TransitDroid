package transitdroid.domain.logic.command.encryption.keys;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import transitdroid.domain.logic.technical.EncryptionService;
import transitdroid.domain.logic.technical.exceptions.EncryptionException;

public class GenerateKeysTests {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testKeyEncryption() throws EncryptionException {
		GenerateKeysCommand keys = new GenerateKeysCommand();
		keys.execute();
		for (String key : keys.getEncrypted()){
			System.out.println(key);
		}
		System.out.println(keys.getSaltString());
		System.out.println();
		assert(EncryptionService.authenticate(keys.getEncrypted(), keys.getOriginals(), keys.getSaltString()));
	}

}
