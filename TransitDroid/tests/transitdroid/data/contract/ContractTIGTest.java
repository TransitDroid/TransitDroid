package transitdroid.data.contract;

import static org.junit.Assert.assertNotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.junit.Test;

public class ContractTIGTest {

	@Test
	public void testFindAll() throws SQLException {
		ResultSet result = ContractTIG.findAll();
		
		assertNotNull(result);
	}

	@Test
	public void testFind() throws SQLException {
		String id = "0ed0775c-e22d-47c2-9d69-432c48059db6";
		UUID newId = UUID.fromString(id);
		ResultSet result = ContractTIG.find(newId);
		assertNotNull(result);
	}

	@Test
	public void testFindByMobileDevice() throws SQLException {
		String id ="832a9a7f-7300-4414-bc54-7d9813d4c393";
		ResultSet rs = ContractTIG.findByMobileDevice(id);
		assertNotNull(rs);
	}

}
