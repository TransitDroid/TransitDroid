package transitdroid.data.pass.single;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.junit.Test;

public class SinglePassTIGTest {

	@Test
	public void testFindAll() throws SQLException {
		ResultSet rs = SinglePassTIG.findAll();
		assertNotNull(rs);
	}

	@Test
	public void testFind() throws SQLException {
		String name = "1751f503-f5d1-41c0-bb17-b3db4be8dee";
		UUID id = UUID.fromString(name);
		ResultSet rs = SinglePassTIG.find(id);
		
		assertNotNull(rs);
		
		
	}

}
