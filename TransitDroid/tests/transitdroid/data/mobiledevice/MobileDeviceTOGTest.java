package transitdroid.data.mobiledevice;

import java.sql.SQLException;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import transitdroid.data.mobiledevice.MobileDeviceTOG;


public class MobileDeviceTOGTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsert() throws SQLException {
		UUID testMobileDeviceId= UUID.randomUUID();
		MobileDeviceTOG.insert(testMobileDeviceId, 1, "YASSER1");
		//fail("Not yet implemented");
	}

	

	@Test
	public void testUpdate() throws SQLException {
		UUID testMobileDeviceId= UUID.randomUUID();
		//MobileDevice testMobileDevice = new MobileDevice(testMobileDeviceId, 1, "YASSER1");
		
		//MobileDeviceTOG testMobileDeviceTOG = new MobileDeviceTOG();
		MobileDeviceTOG.insert(testMobileDeviceId, 1, "YASSER1");
		MobileDeviceTOG.update(testMobileDeviceId, 1, "YASSER1234567890");
		
		
		
	//fail("Not yet implemented");
	}

	@Test
	public void testDelete() throws SQLException {
		UUID testMobileDeviceId= UUID.randomUUID();
		MobileDeviceTOG.insert(testMobileDeviceId, 1, "YASSER1");
		MobileDeviceTOG.delete(testMobileDeviceId, 1);
		//fail("Not yet implemented");
	}

}
