package transitdroid.data.pass.single;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.junit.Test;

public class SinglePassTOGTest {

	@Test
	public void testInsert() throws SQLException {
		int version =1;
		UUID uuid = UUID.randomUUID();
		SinglePassTOG.insert(uuid , version);
		ResultSet rs = SinglePassTIG.find(uuid);
		assertNotNull(rs);
		SinglePassTOG.update(uuid, 2);
		ResultSet rs2 = SinglePassTIG.find(uuid);
		assertNotNull(rs2);
		SinglePassTOG.delete(uuid, 2);
		ResultSet rs3 = SinglePassTIG.find(uuid);
		assertNotNull(rs3);
	}

	
}
