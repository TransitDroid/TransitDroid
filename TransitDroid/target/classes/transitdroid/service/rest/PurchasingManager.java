package transitdroid.service.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import transitdroid.domain.logic.command.pass.purchase.monthly.PurchaseMonthlyPassCommand;
import transitdroid.domain.logic.command.pass.purchase.nightly.PurchaseNightlyPassCommand;
import transitdroid.domain.logic.command.pass.purchase.single.PurchaseSinglePassCommand;
import transitdroid.domain.logic.command.pass.purchase.threeday.PurchaseThreeDayPassCommand;
import transitdroid.domain.logic.command.pass.purchase.yearly.PurchaseYearlyPassCommand;
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

@Path("/purchase/*")
public class PurchasingManager {

	@POST
	@Path("/single")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PurchaseSinglePassResponse purchaseSinglePass(
			PurchaseSinglePassRequest request) {

		PurchaseSinglePassCommand command = new PurchaseSinglePassCommand();

		command.setMobileDeviceMAC(request.getMobileDeviceMAC());
		command.setVersion(request.getVersion());
		command.setQuantity(request.getQuantity());
		command.execute();

		PurchaseSinglePassResponse response = new PurchaseSinglePassResponse();
		if (command.isSucceed()) {
			response.setSucceed(command.isSucceed());
			return response;
		}
		response.setSucceed(command.isSucceed());
		response.setMessage(command.getException().getMessage());
		return response;
	}

	//
	// @POST
	// @Path("/daily")
	// @Consumes(MediaType.APPLICATION_JSON)
	// @Produces(MediaType.APPLICATION_JSON)
	// public PurchaseDailyPassResponse purchaseDailyPass(
	// PurchaseDailyPassRequest request) {
	// PurchaseDailyPassCommand command = new PurchaseDailyPassCommand();
	// command.setId(request.getId());
	// command.setVersion(request.getVersion());
	// command.setDate(request.getDate());
	// command.execute();
	// PurchaseDailyPassResponse response = new PurchaseDailyPassResponse();
	// // response.setUser(command.getUser());
	// // response.setSucceed(command.isSucceed());
	// return response;
	// }

	@POST
	@Path("/threeday")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PurchaseThreeDayPassResponse purchaseThreeDayPass(
			PurchaseThreeDayPassRequest request) {

		PurchaseThreeDayPassCommand command = new PurchaseThreeDayPassCommand();

		command.setMobileDeviceMAC(request.getMobileDeviceMAC());
		command.setVersion(request.getVersion());
		command.setDate(request.getDate());
		command.execute();

		PurchaseThreeDayPassResponse response = new PurchaseThreeDayPassResponse();
		if (command.isSucceed()) {
			response.setSucceed(command.isSucceed());
			return response;
		}
		response.setSucceed(command.isSucceed());
		response.setMessage(command.getException().getMessage());
		return response;
	}

	@POST
	@Path("/nightly")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PurchaseNightlyPassResponse purchaseNightlyPass(
			PurchaseNightlyPassRequest request) {

		PurchaseNightlyPassCommand command = new PurchaseNightlyPassCommand();

		command.setMobileDeviceMAC(request.getMobileDeviceMAC());
		command.setVersion(request.getVersion());
		command.setDate(request.getDate());
		command.execute();

		PurchaseNightlyPassResponse response = new PurchaseNightlyPassResponse();
		if (command.isSucceed()) {
			response.setSucceed(command.isSucceed());
			return response;
		}
		response.setSucceed(command.isSucceed());
		response.setMessage(command.getException().getMessage());
		return response;
	}

	//
	// @POST
	// @Path("/weekly")
	// @Consumes(MediaType.APPLICATION_JSON)
	// @Produces(MediaType.APPLICATION_JSON)
	// public PurchaseWeeklyPassResponse purchaseWeeklyPass(
	// PurchaseWeeklyPassRequest request) {
	// PurchaseWeeklyPassCommand command = new PurchaseWeeklyPassCommand();
	// //command.setPassword(request.getPassword());
	// //command.setUsername(request.getUsername());
	// command.execute();
	// PurchaseWeeklyPassResponse response = new PurchaseWeeklyPassResponse();
	// //response.setUser(command.getUser());
	// //response.setSucceed(command.isSucceed());
	// return response;
	// }

	@POST
	@Path("/monthly")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PurchaseMonthlyPassResponse purchaseMonthlyPass(
			PurchaseMonthlyPassRequest request) {

		PurchaseMonthlyPassCommand command = new PurchaseMonthlyPassCommand();

		command.setMobileDeviceMAC(request.getMobileDeviceMAC());
		command.setVersion(request.getVersion());
		command.setMonth(request.getMonth());
		command.setYear(request.getYear());
		command.execute();

		PurchaseMonthlyPassResponse response = new PurchaseMonthlyPassResponse();
		if (command.isSucceed()) {
			response.setSucceed(command.isSucceed());
			return response;
		}
		response.setSucceed(command.isSucceed());
		response.setMessage(command.getException().getMessage());
		return response;
	}

	@POST
	@Path("/yearly")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PurchaseYearlyPassResponse purchaseYearlyPass(
			PurchaseYearlyPassRequest request) {

		PurchaseYearlyPassCommand command = new PurchaseYearlyPassCommand();

		command.setMobileDeviceMAC(request.getMobileDeviceMAC());
		command.setVersion(request.getVersion());
		command.setDate(request.getDate());
		command.execute();

		PurchaseYearlyPassResponse response = new PurchaseYearlyPassResponse();
		if (command.isSucceed()) {
			response.setSucceed(command.isSucceed());
			return response;
		}
		response.setSucceed(command.isSucceed());
		response.setMessage(command.getException().getMessage());
		return response;
	}

}
