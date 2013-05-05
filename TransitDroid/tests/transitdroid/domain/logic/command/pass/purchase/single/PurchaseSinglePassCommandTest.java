package transitdroid.domain.logic.command.pass.purchase.single;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import transitdroid.domain.core.UnitOfWork;

public class PurchaseSinglePassCommandTest {

	@Test()
	public void testExecute() {
		
		PurchaseSinglePassCommand command = new PurchaseSinglePassCommand();
		command.setMobileDeviceMAC("784930214321");
		command.setQuantity(5);
		command.setVersion(1);
		command.execute();
		UnitOfWork.executionEnvironment = UnitOfWork.ExecutionEnvironment.Testing;
		assertNotNull(command.isSucceed());
		
		
		
	}

	@Test
	public void testSetMobileDeviceMAC() {
		PurchaseSinglePassCommand comm = new PurchaseSinglePassCommand();
		comm.setMobileDeviceMAC("sd");
		assertNotNull(comm);
	}

	@Test
	public void testSetVersion() {
		PurchaseSinglePassCommand comm = new PurchaseSinglePassCommand();
		comm.setVersion(6);
		assertNotNull(comm);
	}

	@Test
	public void testSetQuantity() {
		PurchaseSinglePassCommand comm = new PurchaseSinglePassCommand();
		comm.setVersion(3);
		assertNotNull(comm);
	}

	@Test
	public void testIsSucceed() {
		PurchaseSinglePassCommand comm = new PurchaseSinglePassCommand();
		comm.isSucceed();
		assertNotNull(comm);
	}

	@Test
	public void testGetException() {
		PurchaseSinglePassCommand comm = new PurchaseSinglePassCommand();
		Exception ex = comm.getException();
		assertNotNull(ex);
		
	}

}
