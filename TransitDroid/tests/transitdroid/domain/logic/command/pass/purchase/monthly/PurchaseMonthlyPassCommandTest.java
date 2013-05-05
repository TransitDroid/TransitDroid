package transitdroid.domain.logic.command.pass.purchase.monthly;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import transitdroid.domain.core.UnitOfWork;

public class PurchaseMonthlyPassCommandTest {

	@Test
	public void testExecute() {
		
		PurchaseMonthlyPassCommand command = new PurchaseMonthlyPassCommand();
		command.setMobileDeviceMAC("784930214321");
		command.setMonth(10);
		command.setYear(2013);
		command.setVersion(1);
		
		command.execute();
		UnitOfWork.executionEnvironment = UnitOfWork.ExecutionEnvironment.Testing;
		assertFalse(command.isSucceed());
		

	}
	
	

	@Test
	public void testSetMobileDeviceMAC() {
		PurchaseMonthlyPassCommand command = new PurchaseMonthlyPassCommand();
		command.setMobileDeviceMAC("df");
		assertNotNull(command);
	}

	@Test
	public void testGetVersion() {
		PurchaseMonthlyPassCommand comm = mock(PurchaseMonthlyPassCommand.class);
		when(comm.getVersion()).thenReturn(5);

		assertEquals(5, comm.getVersion());
	}

	@Test
	public void testSetVersion() {
		PurchaseMonthlyPassCommand comm = new PurchaseMonthlyPassCommand();
		comm.setVersion(7);
		assertNotNull(comm);
		

	}

	@Test
	public void testSetYear() {
		PurchaseMonthlyPassCommand comm = mock(PurchaseMonthlyPassCommand.class);
		comm.setYear(2999);
		assertNotNull(comm);

	}

	@Test
	public void testSetMonth() {
		PurchaseMonthlyPassCommand comm = new PurchaseMonthlyPassCommand();
		comm.setMonth(4);
		assertNotNull(comm);
	}

	@Test
	public void testIsSucceed() {
		PurchaseMonthlyPassCommand comm  = new PurchaseMonthlyPassCommand();
		comm.isSucceed();
		assertNotNull(comm);
	}

	@Test
	public void testGetException() {
		PurchaseMonthlyPassCommand comm = new PurchaseMonthlyPassCommand();
		Exception ex = comm.getException();
		assertEquals(ex, comm.getException());
	}

}
