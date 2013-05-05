package transitdroid.domain.logic.command.user.login;

import java.util.UUID;

import transitdroid.domain.core.CommandResponse;
import transitdroid.domain.entities.user.User;

class UserLoginCommandResponse extends CommandResponse{

	private User user;
	private String fullName;
	private UUID id;
	private boolean succeed;
	private Exception exception;

	public User getUser() {
		return user;
	}

	public String getFullName() {
		return fullName;
	}

	public UUID getId() {
		return id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void setSucceed(boolean b) {
		this.succeed = b;
	}
	
	public boolean isSucceed(){
		return this.succeed;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}
}
