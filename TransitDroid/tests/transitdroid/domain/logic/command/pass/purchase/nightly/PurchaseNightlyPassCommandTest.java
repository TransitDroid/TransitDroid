package transitdroid.domain.logic.command.pass.purchase.nightly;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

import transitdroid.domain.core.UnitOfWork;

public class PurchaseNightlyPassCommandTest {

	@Test
	public void testExecute() {
		
		PurchaseNightlyPassCommand command = new PurchaseNightlyPassCommand();
		command.setMobileDeviceMAC("7849302121");
		command.setVersion(1);
		command.setDate(new Date(234234l));
		
		
		command.execute();
		UnitOfWork.executionEnvironment = UnitOfWork.ExecutionEnvironment.Testing;
		assertFalse(command.isSucceed());
		
	}

	@Test
	public void testSetMobileDeviceMAC() {
		PurchaseNightlyPassCommand comm = new PurchaseNightlyPassCommand();
		comm.setMobileDeviceMAC("dsdf");
		assertNotNull(comm);
	}

	@Test
	public void testSetVersion() {
		PurchaseNightlyPassCommand comm = new PurchaseNightlyPassCommand();
		comm.setVersion(3);
		assertNotNull(comm);
		
	}

	@Test
	public void testSetDate() {
		Date date = new Date(123123l);
		PurchaseNightlyPassCommand comm = new PurchaseNightlyPassCommand();
		comm.setDate(date);
		assertNotNull(comm);
		
	}

	@Test
	public void testIsSucceed() {
		PurchaseNightlyPassCommand comm = new PurchaseNightlyPassCommand();
		comm.isSucceed();
		assertNotNull(comm);
		
	}

	@Test
	public void testGetException() {
		PurchaseNightlyPassCommand comm = new PurchaseNightlyPassCommand();
		Exception ex = comm.getException();
		assertNotNull(ex);
	}

}
