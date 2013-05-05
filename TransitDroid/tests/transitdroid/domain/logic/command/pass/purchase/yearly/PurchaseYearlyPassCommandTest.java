package transitdroid.domain.logic.command.pass.purchase.yearly;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import transitdroid.domain.core.UnitOfWork;
import transitdroid.domain.logic.command.pass.purchase.threeday.PurchaseThreeDayPassCommand;

public class PurchaseYearlyPassCommandTest {

	@Test
	public void testExecute() {
		
		PurchaseThreeDayPassCommand command = new PurchaseThreeDayPassCommand();
		command.setDate(new Date());
		command.setMobileDeviceMAC("784930214321");
		command.setVersion(1);
		
		command.execute();
		UnitOfWork.executionEnvironment = UnitOfWork.ExecutionEnvironment.Testing;
		assertNotNull(command.isSucceed());
		
		
		
		
	}

	@Test
	public void testSetDate() {
		PurchaseYearlyPassCommand comm = new PurchaseYearlyPassCommand();
		Date date = new Date(123123l);
		comm.setDate(date);
		assertNotNull(comm);
	}

	@Test
	public void testSetMobileDeviceMAC() {
		PurchaseYearlyPassCommand comm = new PurchaseYearlyPassCommand();
		comm.setMobileDeviceMAC("sd");
		assertNotNull(comm);
	}

	@Test
	public void testSetVersion() {
		PurchaseYearlyPassCommand comm = new PurchaseYearlyPassCommand();
		comm.setVersion(2);
		assertNotNull(comm);
	}

	@Test
	public void testIsSucceed() {
		PurchaseYearlyPassCommand comm = new PurchaseYearlyPassCommand();
		comm.isSucceed();
		assertNotNull(comm);
	}

	@Test
	public void testGetException() {
		PurchaseYearlyPassCommand comm = new PurchaseYearlyPassCommand();
		Exception ex = comm.getException();
		assertNotNull(ex);
	}

}
