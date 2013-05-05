package transitdroid.data.user;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.junit.Test;

public class UserTOGTest {

	@Test
	public void testInsert() throws SQLException {
		UUID id = UUID.randomUUID();
		int version = 1;
		String firstName = "DD";
		String lastName = "DD";
		String username = "dddd";
		byte[] password = new byte[10];
		byte[] salt = new byte[10];
		UserTOG.insert(id, version, firstName, lastName, username, password, salt);
		ResultSet rs = UserTIG.find(id);
		assertNotNull(rs);
		UserTOG.update(id, 2, firstName, lastName, username, password, salt);
		ResultSet rs2 = UserTIG.find(id);
		assertNotNull(rs2);
		UserTOG.delete(id, 2);
		ResultSet rs3 = UserTIG.find(id);
		assertNull(rs3);
	}

	
}
