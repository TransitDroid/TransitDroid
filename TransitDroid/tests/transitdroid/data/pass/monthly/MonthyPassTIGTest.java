package transitdroid.data.pass.monthly;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.junit.Test;

public class MonthyPassTIGTest {

	@Test
	public void testFindAll() throws SQLException {
		ResultSet rs = MonthlyPassTIG.findAll();
		assertNotNull(rs);
		
	}

	@Test
	public void testFind() throws SQLException {
		String dbString = "33711923-714f-4cf2-ac70-328c447c7a35";
		UUID id = UUID.fromString(dbString);
		ResultSet rs = MonthlyPassTIG.find(id);
		assertNotNull(rs);
	}

}
