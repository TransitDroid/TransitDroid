package transitdroid.data.pass.nightly;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.junit.Test;

public class NightlyPassTIGTest {

	@Test
	public void testFindAll() throws SQLException {
		ResultSet rs = NightlyPassTIG.findAll();
		assertNotNull(rs);
	}

	@Test
	public void testFind() throws SQLException {
		String name = "0ce93c46-ddb0-47c6-8c02-1246d71e51c9";
		UUID id = UUID.fromString(name);
		ResultSet rs = NightlyPassTIG.find(id);
		assertNotNull(rs);
	}

}
