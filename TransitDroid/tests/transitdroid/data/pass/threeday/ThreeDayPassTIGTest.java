package transitdroid.data.pass.threeday;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.junit.Test;

public class ThreeDayPassTIGTest {

	@Test
	public void testFindAll() throws SQLException {
		ResultSet rs = ThreeDayPassTIG.findAll();
		assertNotNull(rs);
	}

	@Test
	public void testFind() throws SQLException {
		String name = "46054d34-9ce9-4af4-91a7-bb6c294db455";
		UUID id = UUID.fromString(name );
		ResultSet rs = ThreeDayPassTIG.find(id);
		assertNotNull(rs);
	}

}
