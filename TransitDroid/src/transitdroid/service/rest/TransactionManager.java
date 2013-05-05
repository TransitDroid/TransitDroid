package transitdroid.service.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import transitdroid.domain.logic.command.pass.transaction.ProcessTransactionCommand;
import transitdroid.service.rest.requests.TransactionRequest;
import transitdroid.service.rest.responses.TransactionResponse;

@Path("/transaction")
public class TransactionManager {

	@POST
	@Path("/process")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TransactionResponse process(TransactionRequest request) {
		TransactionResponse response = new TransactionResponse();
		ProcessTransactionCommand command = new ProcessTransactionCommand();
		command.setRequestKeys((List<String>) request.getKeys());
		command.SetPhoneMac(request.getPhoneMac());
		command.setRequestPasscode(request.getPasscode());
		command.execute();
		if (command.getResponseCode() == "SUCCESS"){
			response.setKeys(command.getResponseKeys());

			response.setPasscode(command.getResponsePasscode());
			response.setCode(command.getResponseCode());
			return response;
		} else {
			if (command.getException() != null){
				response.setMessage(command.getException().getMessage()+
						command.getException().toString()+command.getException().fillInStackTrace());
			}
			response.setCode(command.getResponseCode());
		}
		return response;
	}
}
