package transitdroid.domain.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import transitdroid.domain.entities.user.User;
import transitdroid.domain.entities.user.UserRole;

public class DomainObjectTest {

	


	@Test
	public void testGetId() {
		
		UUID id= UUID.randomUUID();
		int version = 1;
		List<UserRole> roles = new ArrayList<UserRole>();
		String firstName = "Danny";
		String lastName = "Magni";
		String username = "dmagni";
		byte[] password = new byte[10];
		byte[] salt = new byte[10];
		
		
		User user = new User(id, version, roles, firstName, lastName, username, password, salt);
		
		assertEquals(id, user.getId());
	}

	@Test
	public void testSetId() {
		UUID id= UUID.randomUUID();
		int version = 1;
		List<UserRole> roles = new ArrayList<UserRole>();
		String firstName = "Danny";
		String lastName = "Magni";
		String username = "dmagni";
		byte[] password = new byte[10];
		byte[] salt = new byte[10];
		
		User user = new User(id, version, roles, firstName, lastName, username, password, salt);
		
		UUID newId = UUID.randomUUID();
		user.setId(newId);
		assertEquals(newId, user.getId());
		
		
		
	}

	@Test
	public void testGetVersion() {
		
		UUID id= UUID.randomUUID();
		int version = 1;
		List<UserRole> roles = new ArrayList<UserRole>();
		String firstName = "Danny";
		String lastName = "Magni";
		String username = "dmagni";
		byte[] password = new byte[10];
		byte[] salt = new byte[10];
		
		User user = new User(id, version, roles, firstName, lastName, username, password, salt);
		assertEquals(version,user.getVersion());
	}

	@Test
	public void testSetVersion() {
		
		UUID id= UUID.randomUUID();
		int version = 1;
		List<UserRole> roles = new ArrayList<UserRole>();
		String firstName = "Danny";
		String lastName = "Magni";
		String username = "dmagni";
		byte[] password = new byte[10];
		byte[] salt = new byte[10];
		
		User user = new User(id, version, roles, firstName, lastName, username, password, salt);
		int newVersion = 2;
		user.setVersion(newVersion);
		
		assertEquals(newVersion,user.getVersion());
	}

}
