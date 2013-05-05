package transitdroid.data.pass.yearly;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.junit.Test;

public class YearlyPassTOGTest {

	@Test
	public void testInsert() throws SQLException {
		int version = 1;
		UUID uuid = UUID.randomUUID();
		YearlyPassTOG.insert(uuid, version);
		ResultSet rs= YearlyPassTIG.find(uuid);
		assertNotNull(rs);
		YearlyPassTOG.update(uuid, 2);
		ResultSet rs2 = YearlyPassTIG.find(uuid);
		assertNotNull(rs2);
		YearlyPassTOG.delete(uuid, 2);
		ResultSet rs3 = YearlyPassTIG.find(uuid);
		assertNotNull(rs3);
	}

	
}
