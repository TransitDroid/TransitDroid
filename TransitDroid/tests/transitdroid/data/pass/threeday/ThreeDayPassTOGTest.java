package transitdroid.data.pass.threeday;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.junit.Test;

public class ThreeDayPassTOGTest {

	@Test
	public void testInsert() throws SQLException {
		int version =1;
		UUID uuid = UUID.randomUUID();
		ThreeDayPassTOG.insert(uuid , version);
		ResultSet rs = ThreeDayPassTIG.find(uuid);
		assertNotNull(rs);
		ThreeDayPassTOG.update(uuid, 2);
		ResultSet rs2 = ThreeDayPassTIG.find(uuid);
		assertNotNull(rs2);
		ThreeDayPassTOG.delete(uuid, 2);
		ResultSet rs3 = ThreeDayPassTIG.find(uuid);
		assertNotNull(rs3);
	
	}

	

}
