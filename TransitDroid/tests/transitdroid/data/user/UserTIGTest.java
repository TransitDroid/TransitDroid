package transitdroid.data.user;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.junit.Test;

public class UserTIGTest {

	@Test
	public void testFindAll() throws SQLException {
		ResultSet rs = UserTIG.findAll();
		assertNotNull(rs);
		
	}

	@Test
	public void testFindUUID() throws SQLException {
		String name = "0167718c-2a5a-4ede-8318-f328c713b94b";
		UUID id = UUID.fromString(name );
		ResultSet rs = UserTIG.find(id );
		assertNotNull(rs);
	}

	@Test
	public void testFindString() throws SQLException {
		String name="dmagni";
		UUID username = UUID.fromString(name);
				
		ResultSet rs = UserTIG.find(username);
		assertNotNull(rs);
	}

	@Test
	public void testGetVersion() throws SQLException {
		//int version = UserTIG.getVersion("0167718c-2a5a-4ede-8318-f328c713b94b");
		//assertNotNull(version);
	}

}
