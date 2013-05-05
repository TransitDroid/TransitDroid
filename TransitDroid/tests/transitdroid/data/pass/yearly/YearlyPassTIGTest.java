package transitdroid.data.pass.yearly;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.junit.Test;

public class YearlyPassTIGTest {

	@Test
	public void testFindAll() throws SQLException {
		ResultSet rs = YearlyPassTIG.findAll();
		assertNotNull(rs);
	}

	@Test
	public void testFind() throws SQLException {
		String name = "019a268e-bb05-4f95-a408-65bd86555203";
		UUID id = UUID.fromString(name );
		ResultSet rs = YearlyPassTIG.find(id);
		assertNotNull(rs);
	}

}
