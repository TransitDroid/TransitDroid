package transitdroid.domain.logic.command.pass.purchase.threeday;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

public class PurchaseThreeDayPassCommandTest {

	@Test
	public void testExecute() {
		
		PurchaseThreeDayPassCommand command = new PurchaseThreeDayPassCommand();
		command.setDate(new Date(123123123l));
		command.setMobileDeviceMAC("784930214321");
		command.setVersion(1);
		
		assertNotNull(command.isSucceed());
		
	}

	@Test
	public void testSetMobileDeviceMAC() {
		PurchaseThreeDayPassCommand comm = new PurchaseThreeDayPassCommand();
		comm.setMobileDeviceMAC("sd");
		assertNotNull(comm);
	}

	@Test
	public void testSetVersion() {
		PurchaseThreeDayPassCommand comm = new PurchaseThreeDayPassCommand();
		comm.setVersion(1);
		assertNotNull(comm);
	}

	@Test
	public void testSetDate() {
		PurchaseThreeDayPassCommand comm = new PurchaseThreeDayPassCommand();
		Date date = new Date(123123l);
		comm.setDate(date);
		assertNotNull(comm);
	}

	@Test
	public void testIsSucceed() {
		PurchaseThreeDayPassCommand comm = new PurchaseThreeDayPassCommand();
		comm.isSucceed();
		assertNotNull(comm);
	}

	@Test
	public void testGetException() {
		PurchaseThreeDayPassCommand comm = new PurchaseThreeDayPassCommand();
		Exception ex = comm.getException();
		assertEquals(ex,comm.getException());
	}

}
