package transitdroid.data.pass.nightly;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.junit.Test;

public class NightlyPassTOGTest {

	@Test
	public void testInsert() throws SQLException {
		
		int version = 1;
		UUID uuid= UUID.randomUUID();
		NightlyPassTOG.insert(uuid, version);
		ResultSet rs = NightlyPassTIG.find(uuid);
		assertNotNull(rs);
		NightlyPassTOG.update(uuid, 2);
		ResultSet rs2 = NightlyPassTIG.find(uuid);
		assertNotNull(rs2);
		NightlyPassTOG.delete(uuid, 2);
		ResultSet rs3 = NightlyPassTIG.find(uuid);
		assertNotNull(rs3);
		
	}


}
