package transitdroid.data.pass.monthly;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.junit.Test;

public class MonthlyPassTOGTest {

	@Test
	public void testInsert() throws SQLException {
	
		int version = 1;
		UUID uuid = UUID.randomUUID();
		MonthlyPassTOG.insert(uuid , version);
		ResultSet rs = MonthlyPassTIG.find(uuid);
		assertNotNull(rs);
		
		MonthlyPassTOG.update(uuid, 2);
		ResultSet rs2 =MonthlyPassTIG.find(uuid);
		assertNotNull(rs2);
		MonthlyPassTOG.delete(uuid, 2);
		ResultSet rs3 = MonthlyPassTIG.find(uuid);
		assertNotNull(rs3);
		
		
		
	}

	

}
