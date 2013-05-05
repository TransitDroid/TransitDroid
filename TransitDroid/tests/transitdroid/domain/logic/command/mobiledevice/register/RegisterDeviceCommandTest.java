package transitdroid.domain.logic.command.mobiledevice.register;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import transitdroid.domain.entities.user.User;

public class RegisterDeviceCommandTest {

	

	@Test
	public void testExecute() {
		RegisterDeviceCommand command = new RegisterDeviceCommand("sd", "dmagni", "password");
		command.setPhoneId("sdsdf");
		command.execute();
		
	}

	@Test
	public void testSetPhoneId() {
		
		
		RegisterDeviceCommand command = new RegisterDeviceCommand();
		String id = "234234234";
		command.setPhoneId(id);
		assertEquals(id, command.request.getPhoneId());
	}

	@Test
	public void testIsSucceed() {
		
		RegisterDeviceCommand command = new RegisterDeviceCommand();
		
		command.response.setSucceed(true);
		
		assertTrue(command.isSucceed());
	}

	@Test
	public void testGetKeys() {
		RegisterDeviceCommand command = new RegisterDeviceCommand();
		List<String> keys = new ArrayList<String>();
		command.response.setKeys(keys);
		assertEquals(keys, command.getKeys());
	}

	@Test
	public void testGetSalt() {
		RegisterDeviceCommand command = new RegisterDeviceCommand();
		String salt = new byte[10].toString();
		command.response.setSalt(salt);
		
		assertEquals(salt, command.getSalt());
		
	}

	@Test
	public void testGetUser() {
		RegisterDeviceCommand command = new RegisterDeviceCommand();
		
		User user = mock(User.class);
		command.response.setUser(user);
		assertEquals(user, command.getUser());
	}

	@Test
	public void testGetException() {
		RegisterDeviceCommand command = new RegisterDeviceCommand();
		Exception ex = mock(Exception.class);
		command.response.setException(ex);
		assertEquals(ex, command.getException());
	}

}
