package transitdroid.service.rest;

import org.junit.Test;

import transitdroid.service.rest.requests.TransactionRequest;
import transitdroid.service.rest.responses.TransactionResponse;

public class TransactionManagerTest {

	@SuppressWarnings("unused")
	@Test
	public void testProcess() {
		TransactionManager tm = new TransactionManager();
		TransactionRequest request = new TransactionRequest();
		TransactionResponse res = tm.process(request);
		
		
	}

}
