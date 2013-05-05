package transitdroid.data.mobiledevice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.junit.Test;

public class MobileDeviceTIGTest {

	@Test
	public void testFindAll() throws SQLException {
		ResultSet rs = MobileDeviceTIG.findAll();
		assertNotNull(rs);
	}

	@Test
	public void testFindUUID() throws SQLException {
		String textId = "407300c6-9aaa-4bcf-bc77-a9ac7d0d48e2";
		UUID id = UUID.fromString(textId);
		ResultSet rs = MobileDeviceTIG.find(id);
		assertNotNull(rs);
		rs.next();
		int testVersion = rs.getInt(2);
		assertEquals(1,testVersion);
	}

	@SuppressWarnings("unused")
	@Test
	public void testFindString() throws SQLException {
		String textMAC = "sdsdf";
		ResultSet rs = MobileDeviceTIG.find(textMAC);
		
		
		
		
	}

}
