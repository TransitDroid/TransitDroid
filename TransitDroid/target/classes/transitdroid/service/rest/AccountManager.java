package transitdroid.service.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import transitdroid.domain.logic.command.mobiledevice.register.RegisterDeviceCommand;
import transitdroid.domain.logic.command.user.create.CreateUserCommand;
import transitdroid.domain.logic.command.user.login.UserLoginCommand;
import transitdroid.domain.logic.command.user.update.UpdateUserCommand;
import transitdroid.service.entities.User;
import transitdroid.service.rest.requests.CreateUserRequest;
import transitdroid.service.rest.requests.LoginRequest;
import transitdroid.service.rest.requests.RegisterDeviceRequest;
import transitdroid.service.rest.requests.UpdateUserRequest;
import transitdroid.service.rest.responses.CreateUserResponse;
import transitdroid.service.rest.responses.LoginResponse;
import transitdroid.service.rest.responses.RegisterDeviceResponse;
import transitdroid.service.rest.responses.UpdateUserResponse;

@Path("/account/*")
public class AccountManager {

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LoginResponse login(LoginRequest request) {
		
		UserLoginCommand command = new UserLoginCommand();
		command.setPassword(request.getPassword());
		command.setUsername(request.getUsername());
		command.execute();
		LoginResponse response = new LoginResponse();
		if (command.isSucceed()){
			response.setUser(command.getUser());
			response.setSucceed(command.isSucceed());
			return response;
		}
		response.setSucceed(command.isSucceed());
		response.setMessage(command.getException().getMessage());
		return response;
	}

	@GET
	@Path("/logout/{param}")
	@Produces("text/plain")
	public String logout(@PathParam("param") String text) {
		return "Hello " + text;
	}

	@POST
	@Path("/user/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CreateUserResponse createUser(CreateUserRequest request){
		CreateUserResponse response = new CreateUserResponse();
		CreateUserCommand command = new CreateUserCommand(){};
		command.setFirstName(request.getFirstName());
		command.setLastName(request.getLastName());
		command.setPassword(request.getPassword());
		command.setUsername(request.getUsername());
		
		command.execute();
		
		response.setUser(command.getUser());
		response.setSucceed(command.isSucceed());
		return response;
	}
	
	@POST
	@Path("/user/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UpdateUserResponse updateUser(UpdateUserRequest updateRequest){
		UpdateUserCommand command = new UpdateUserCommand();
		command.setVersion(updateRequest.getVersion());
		command.setId(updateRequest.getId());
		command.setFirstName(updateRequest.getFirstName());
		command.setLastName(updateRequest.getLastName());
		command.setPassword(updateRequest.getPassword());
		command.setRoles(updateRequest.getRoles());
		command.setSalt(updateRequest.getSalt());
		command.setUsername(updateRequest.getUsername());
		command.execute();
		UpdateUserResponse response = new UpdateUserResponse();
		response.setSucceed(command.isSucceed());
		if (!command.isSucceed()){
			response.setMessage(command.getException().getMessage());
		}
		return response;
	}
	
	@POST
	@Path("/device/register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RegisterDeviceResponse registerDevice(RegisterDeviceRequest request){
		RegisterDeviceResponse response = new RegisterDeviceResponse();
		RegisterDeviceCommand command = new RegisterDeviceCommand(request.getMobileDeviceMAC(), request.getUsername(), request.getPassword());
		command.execute();
		if (command.isSucceed()){
			response.setSucceed(command.isSucceed());
			response.setKeys(command.getKeys());
			response.setSalt(command.getSalt());
			response.setUser(new User(command.getUser()));
		} else{
			response.setSucceed(false);
			response.setMessage(command.getException().getMessage());
		}
		return response;
	}
}
