package transitdroid.domain.logic.command.user.create;

import static org.junit.Assert.*;

import org.junit.Test;

import transitdroid.domain.entities.user.User;

public class CreateUserCommandTest {

	@Test
	public void testCreateUserCommand() {
		CreateUserCommand comm = new CreateUserCommand();
		comm.setFirstName("Danny");
		comm.setLastName("Magni");
		comm.setPassword("password");
		comm.setUsername("dmagni");
		
		
		
		
	}

	@Test
	public void testExecute() {
		CreateUserCommand comm = new CreateUserCommand();
		comm.setFirstName("Danny");
		comm.setLastName("Magni");
		comm.setPassword("password");
		comm.setUsername("dmagni");
		comm.execute();
		
		
		
	}

	@Test
	public void testSetUsername() {
		CreateUserCommand comm = new CreateUserCommand();
		comm.setFirstName("Danny");
		comm.setLastName("Magni");
		comm.setPassword("password");
		comm.setUsername("dmagni");
		
		
		
	}

	@Test
	public void testSetPassword() {
		CreateUserCommand comm = new CreateUserCommand();
		comm.setFirstName("Danny");
		comm.setLastName("Magni");
		comm.setPassword("password");
		comm.setUsername("dmagni");
		
		
	}

	@Test
	public void testSetFirstName() {
		
		CreateUserCommand comm = new CreateUserCommand();
		comm.setFirstName("Danny");
		comm.setLastName("Magni");
		comm.setPassword("password");
		comm.setUsername("dmagni");
		
	}

	@Test
	public void testSetLastName() {
		
		CreateUserCommand comm = new CreateUserCommand();
		comm.setFirstName("Danny");
		comm.setLastName("Magni");
		comm.setPassword("password");
		comm.setUsername("dmagni");
		fail("Not yet implemented");
	}

	@Test
	public void testGetUser() {

		CreateUserCommand comm = new CreateUserCommand();
		comm.setFirstName("Danny");
		comm.setLastName("Magni");
		comm.setPassword("password");
		comm.setUsername("dmagni");
		User user = comm.getUser();
		assertNull(user);
	}

	@Test
	public void testGetException() {
		
		CreateUserCommand comm = new CreateUserCommand();
		comm.setFirstName("Danny");
		comm.setLastName("Magni");
		comm.setPassword("password");
		comm.setUsername("dmagni");
		Exception ex = comm.getException();
		assertEquals(ex, comm.getException());
	}

	@Test
	public void testIsSucceed() {
		CreateUserCommand comm = new CreateUserCommand();
		comm.setFirstName("Danny");
		comm.setLastName("Magni");
		comm.setPassword("password");
		comm.setUsername("dmagni");
		
		comm.execute();
		assertFalse(comm.isSucceed());
	}

}
