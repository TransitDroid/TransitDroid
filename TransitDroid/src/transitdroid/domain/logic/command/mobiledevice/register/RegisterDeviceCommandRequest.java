package transitdroid.domain.logic.command.mobiledevice.register;

import transitdroid.domain.core.CommandRequest;

public class RegisterDeviceCommandRequest extends CommandRequest {
	private String PhoneId;
	private String username;
	private String password;

	String getPhoneId() {
		return PhoneId;
	}
	void setPhoneId(String phoneId) {
		PhoneId = phoneId;
	}
	String getUsername() {
		return username;
	}
	void setUsername(String username) {
		this.username = username;
	}
	String getPassword() {
		return password;
	}
	void setPassword(String password) {
		this.password = password;
	}
}
