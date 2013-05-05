package transitdroid.domain.logic.command.user.create;

import transitdroid.domain.core.CommandResponse;
import transitdroid.domain.entities.user.User;

class CreateUserCommandResponse extends CommandResponse{
	private User user;
	private Exception responseException;
	private boolean succeed;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setSucceed(boolean succeed) {
		this.succeed = succeed;
	}
	public boolean isSucceed() {
		return succeed;
	}
	public Exception getResponseException() {
		return responseException;
	}
	public void setResponseException(Exception responseException) {
		this.responseException = responseException;
	}
	
}
