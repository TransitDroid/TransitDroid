package transitdroid.domain.logic.command.user.login;

import transitdroid.domain.core.CommandRequest;

class UserLoginCommandRequest extends CommandRequest {

	private String username;
	private String password;

	// public UserLoginCommandRequest(String username, String password) {
	// super();
	// this.username = username;
	// this.password = password;
	// }

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
