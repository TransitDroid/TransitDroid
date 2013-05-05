package transitdroid.domain.logic.command.pass.purchase.daily;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

import transitdroid.domain.core.UnitOfWork;

public class PurchaseDailyPassCommandTest {

	@Test
	public void testExecute() {
		
		PurchaseDailyPassCommand command = new PurchaseDailyPassCommand();
		command.setDate(new Date(234234l));
		command.setVersion(1);
		command.setMobileDeviceMAC("784930214321");
		command.execute();
		UnitOfWork.executionEnvironment = UnitOfWork.ExecutionEnvironment.Testing;
		assertFalse(command.isSucceed());
		
		
		
		
		

		
	}

	@Test
	public void testSetMACDevice(){
		PurchaseDailyPassCommand dp = new PurchaseDailyPassCommand();
		String mac = "macattack";
		dp.setMobileDeviceMAC(mac);
		
		assertNotNull(dp);
		
	}
		
	@Test
	public void testSetVersion() {
		
		PurchaseDailyPassCommand dp = new PurchaseDailyPassCommand();
		int version = 3;
		dp.setVersion(version);
		
		assertNotNull(dp);
	}

	@Test
	public void testSetDate() {
		PurchaseDailyPassCommand dp = new PurchaseDailyPassCommand();
		Date date = new Date(123123l);
		dp.setDate(date);
		assertNotNull(dp);
	}

	@Test
	public void testIsSucceed() {
		PurchaseDailyPassCommand dp = new PurchaseDailyPassCommand();
		dp.isSucceed();
		assertNotNull(dp);
	}

	@Test
	public void testGetException() {
		
		PurchaseDailyPassCommand dp = new PurchaseDailyPassCommand();
		Exception ex = dp.getException();
		assertEquals(ex, dp.getException());
	}

}
