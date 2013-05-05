package transitdroid.service.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import transitdroid.service.rest.requests.CreateUserRequest;
import transitdroid.service.rest.requests.LoginRequest;
import transitdroid.service.rest.requests.RegisterDeviceRequest;
import transitdroid.service.rest.requests.UpdateUserRequest;
import transitdroid.service.rest.responses.CreateUserResponse;
import transitdroid.service.rest.responses.LoginResponse;
import transitdroid.service.rest.responses.RegisterDeviceResponse;
import transitdroid.service.rest.responses.UpdateUserResponse;

public class AccountManagerTest {

	@Test
	public void testLogin() {

		AccountManager am = new AccountManager();
		LoginRequest req = new LoginRequest();
		req.setUsername("Danny");
		req.setPassword("password");
		LoginResponse res = null;
		res = am.login(req);
		assertNotNull(res);
		
		
	}

	@Test
	public void testLogout() {
		
		AccountManager am = new AccountManager();
		String message = "Danny";
		String result = am.logout(message);
		assertEquals("Hello Danny", result);
	}

	@Test
	public void testCreateUser() {
		
		AccountManager am = new AccountManager();
		CreateUserRequest request = new CreateUserRequest();
		request.setFirstName("Danny");
		request.setLastName("Magni");
		request.setPassword("password");
		List<String> InRoles = new ArrayList<String>();
		request.setRoles(InRoles);
		request.setUsername("dmagni");
		
		CreateUserResponse res = null;
		
		res = am.createUser(request);
		assertNotNull(res);
		
	}

	@Test
	public void testUpdateUser() {
		AccountManager am = new AccountManager();
		UpdateUserRequest request = new UpdateUserRequest();
		UpdateUserResponse response = null;
		request.setFirstName("Danny");
		request.setId(UUID.randomUUID().toString());
		response = am.updateUser(request);
		assertNotNull(response);
		
	}

	
	@Test
	public void testRegisterDevice() {
		AccountManager am = new AccountManager();
		RegisterDeviceRequest req= new RegisterDeviceRequest();
		RegisterDeviceResponse res = null;
		
		req.setPassword("password");
		req.setUserId(UUID.randomUUID().toString());
		req.setUsername("dmagni");
		res = am.registerDevice(req);
		assertNotNull(res);
	}

}
