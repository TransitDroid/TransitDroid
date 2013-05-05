package transitdroid.domain.logic.command.user.login;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.UUID;

import org.junit.Test;

import transitdroid.domain.entities.user.User;

public class UserLoginCommandTest {

	@Test
	public void testExecute() {
		UserLoginCommand command = new UserLoginCommand();
		command.setUsername("dmagni");
		command.setPassword("password");
		command.execute();
		assertFalse(command.isSucceed());
		
	}

	@Test
	public void testSetUsername() {
		UserLoginCommand command = new UserLoginCommand();
		String username = "Danny";
		command.setUsername(username);
		assertNotNull(command);
		
		
	}

	@Test
	public void testSetPassword() {
		UserLoginCommand comm = new UserLoginCommand();
		comm.setPassword("hello");
		
	}

	@Test
	public void testGetUser() {
		UserLoginCommand comm = new UserLoginCommand();
		comm.setPassword("password");
		comm.setUsername("Danny");
		comm.execute();
		User user = comm.getUser();
		
		assertNull(user);
	}

	@Test
	public void testGetFullName() {
		UserLoginCommand comm = new UserLoginCommand();
		comm.setPassword("pasword");
		comm.setUsername("Danny");
		String result = comm.getFullName();
		assertNull(result);
	}

	@Test
	public void testGetId() {
		UserLoginCommand comm = new UserLoginCommand();
		comm.setPassword("password");
		comm.setUsername("Danny");
		comm.execute();
		UUID resuly = comm.getId();
		assertNull(resuly);
	}

	@Test
	public void testIsSucceed() {
		UserLoginCommand comm = new UserLoginCommand();
		comm.setPassword("password");
		comm.setUsername("username");
		comm.execute();
		boolean result = comm.isSucceed();
		assertFalse(result);
	}

	@Test
	public void testGetException() {
		UserLoginCommand comm = new UserLoginCommand();
		comm.setPassword("password");
		comm.setUsername("Danny");
		Exception ex = comm.getException();
		assertEquals(ex, comm.getException());
	}

}
