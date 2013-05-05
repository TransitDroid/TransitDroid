package transitdroid.service.rest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Date;

import org.junit.Test;

import transitdroid.domain.logic.command.pass.purchase.single.PurchaseSinglePassCommand;
import transitdroid.domain.logic.command.pass.purchase.threeday.PurchaseThreeDayPassCommand;
import transitdroid.service.rest.requests.passes.PurchaseMonthlyPassRequest;
import transitdroid.service.rest.requests.passes.PurchaseNightlyPassRequest;
import transitdroid.service.rest.requests.passes.PurchaseSinglePassRequest;
import transitdroid.service.rest.requests.passes.PurchaseThreeDayPassRequest;
import transitdroid.service.rest.requests.passes.PurchaseYearlyPassRequest;
import transitdroid.service.rest.responses.passes.PurchaseMonthlyPassResponse;
import transitdroid.service.rest.responses.passes.PurchaseNightlyPassResponse;
import transitdroid.service.rest.responses.passes.PurchaseSinglePassResponse;
import transitdroid.service.rest.responses.passes.PurchaseThreeDayPassResponse;
import transitdroid.service.rest.responses.passes.PurchaseYearlyPassResponse;

public class PurchasingManagerTest {

	@SuppressWarnings("unused")
	@Test
	public void testPurchaseSinglePass() {
		PurchasingManager pm = new PurchasingManager();
		PurchaseSinglePassRequest request = new PurchaseSinglePassRequest();
		request.setDate(new Date(234234l));
		request.setMobileDeviceMAC("456456");
		request.setQuantity(5);
		request.setVersion(1);
		
		PurchaseSinglePassCommand command = mock(PurchaseSinglePassCommand.class);
		
		
		PurchaseSinglePassResponse res = pm.purchaseSinglePass(request);
		
		
	}

	@Test
	public void testPurchaseThreeDayPass() {
		
		PurchasingManager pm = new PurchasingManager();
		
		PurchaseThreeDayPassRequest request = new PurchaseThreeDayPassRequest();
		request.setDate(new Date(123123123l));
		request.setMobileDeviceMAC("234234234");
		request.setVersion(1);
		PurchaseThreeDayPassCommand command = mock(PurchaseThreeDayPassCommand.class);
		doNothing().when(command).execute();
		
		
		PurchaseThreeDayPassResponse res = pm.purchaseThreeDayPass(request);
		assertNotNull(res);
		
		
		
	}

	@Test
	public void testPurchaseNightlyPass() {
		
		PurchasingManager pm = new PurchasingManager();
		
		PurchaseNightlyPassRequest request = new PurchaseNightlyPassRequest();
		request.setDate(new Date(123123123l));
		request.setMobileDeviceMac("234234234");
		request.setVersion(1);
		PurchaseThreeDayPassCommand command = mock(PurchaseThreeDayPassCommand.class);
		doNothing().when(command).execute();
		
		
		PurchaseNightlyPassResponse res = pm.purchaseNightlyPass(request);
		assertNotNull(res);
	
	}

	@Test
	public void testPurchaseMonthlyPass() {
		
	PurchasingManager pm = new PurchasingManager();
		
		PurchaseMonthlyPassRequest request = new PurchaseMonthlyPassRequest();
		request.setMonth(4);
		request.setYear(2013);
		request.setMobileDeviceMAC("234234234");
		request.setVersion(1);
		PurchaseThreeDayPassCommand command = mock(PurchaseThreeDayPassCommand.class);
		doNothing().when(command).execute();
		
		
		PurchaseMonthlyPassResponse res = pm.purchaseMonthlyPass(request);
		assertNotNull(res);
	
		
	}

	@Test
	public void testPurchaseYearlyPass() {
		
		
	PurchasingManager pm = new PurchasingManager();
		
		PurchaseYearlyPassRequest request = new PurchaseYearlyPassRequest();
		request.setDate(new Date(123123123l));
		request.setMobileDeviceMAC("234234234");
		request.setVersion(1);
		PurchaseThreeDayPassCommand command = mock(PurchaseThreeDayPassCommand.class);
		doNothing().when(command).execute();
		
		
		PurchaseYearlyPassResponse res = pm.purchaseYearlyPass(request);
		assertNotNull(res);
	
	}

}
