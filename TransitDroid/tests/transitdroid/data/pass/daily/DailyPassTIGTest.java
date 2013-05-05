package transitdroid.data.pass.daily;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.junit.Test;

public class DailyPassTIGTest {

	@Test
	public void testFindAll() throws SQLException {
		ResultSet rs = DailyPassTIG.findAll();
		assertNotNull(rs);
	}

	@Test
	public void testFind() throws SQLException {
		String id = "0ef3b2f3-bb87-4caf-938c-fffa579c804e";
		UUID newId = UUID.fromString(id);
		ResultSet rs = DailyPassTIG.find(newId);
		
		assertNotNull(rs);
		
		
	}

}
