package transitdroid.data.pass.daily;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.junit.Test;

public class DailyPassTOGTest {

	@Test
	public void testInsert() throws SQLException {
		
		UUID uuid = UUID.randomUUID();
		int version = 1;
		DailyPassTOG.insert(uuid, version);
		ResultSet rs = DailyPassTIG.find(uuid);
		assertNotNull(rs);
		
		DailyPassTOG.update(uuid, 2);
		ResultSet rs2 = DailyPassTIG.find(uuid);
		assertNotNull(rs2);
		
		DailyPassTOG.delete(uuid, 2);
		ResultSet rs3 = DailyPassTIG.find(uuid);
		assertNotNull(rs3);
		
		
		
		
		
		
	}

	

}
