package transitdroid.domain.logic.command.user.update;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import transitdroid.domain.entities.user.UserRole;

public class UpdateUserCommandTest {

	@Test
	public void testExecute() {
		
		UpdateUserCommand comm = new UpdateUserCommand();
		comm.setFirstName("Danny");
		comm.setId(UUID.randomUUID().toString());
		comm.setLastName("Magni");
		comm.setPassword(new byte[10]);
		List<UserRole> roles = null;
		comm.setRoles(roles);
		byte[] salt = new byte[10];
		comm.setSalt(salt);
		comm.setUsername("dmagni");
		comm.setVersion(1);
		
		comm.execute();
		
	}

	@Test
	public void testSetId() {
		UpdateUserCommand comm = new UpdateUserCommand();
		comm.setId(UUID.randomUUID().toString());
		assertNotNull(comm);
	}

	@Test
	public void testSetRoles() {
		UpdateUserCommand comm = new UpdateUserCommand();
		List<UserRole> roles = new ArrayList<UserRole>();
		UserRole role = UserRole.PASSENGER;
		roles.add(role);
		comm.setRoles(roles);
		assertNotNull(comm);
		
		
	}

	@Test
	public void testSetFirstName() {
		UpdateUserCommand comm = new UpdateUserCommand();
		comm.setFirstName("Danny");
		assertNotNull(comm);
		
	}

	@Test
	public void testSetLastName() {
		UpdateUserCommand comm = new UpdateUserCommand();
		comm.setLastName("Magni");
		assertNotNull(comm);
		
	}

	@Test
	public void testSetUsername() {
		UpdateUserCommand comm = new UpdateUserCommand();
		comm.setUsername("magnida");
		assertNotNull(comm);
		
	}

	@Test
	public void testSetPassword() {
		UpdateUserCommand comm = new UpdateUserCommand();
		comm.setPassword(new byte[11]);
		assertNotNull(comm);
		
	}

	@Test
	public void testSetSalt() {
		UpdateUserCommand comm = new UpdateUserCommand();
		comm.setSalt(new byte[11]);
		assertNotNull(comm);
		
	}

	@Test
	public void testSetVersion() {
		UpdateUserCommand comm = new UpdateUserCommand();
		comm.setVersion(1);
		assertNotNull(comm);
		
	}

	@Test
	public void testGetException() {
		UpdateUserCommand comm = new UpdateUserCommand();
		Exception ex = comm.getException();
		assertEquals(ex, comm.getException());
		
	}

	@Test
	public void testIsSucceed() {
		fail("Not yet implemented");
	}

}
