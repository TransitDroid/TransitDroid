package transitdroid.domain.logic.command.mobiledevice.register;

import java.util.ArrayList;
import java.util.List;

import transitdroid.domain.core.CommandResponse;
import transitdroid.domain.entities.user.User;

public class RegisterDeviceCommandResponse extends CommandResponse {
	private boolean succeed;
	private User user;
	private Exception exception;
	private List<String> keys = new ArrayList<String>();
	private String salt;
	boolean isSucceed() {
		return succeed;
	}

	void setSucceed(boolean succeed) {
		this.succeed = succeed;
	}

	Exception getException() {
		return exception;
	}

	void setException(Exception exception) {
		this.exception = exception;
	}

	User getUser() {
		return user;
	}

	void setUser(User user) {
		this.user = user;
	}

	public List<String> getKeys() {
		return keys;
	}

	public void addKeys(String keys) {
		this.keys.add(keys);
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public void setKeys(List<String> keys2) {
		this.keys = keys2;
	}
	
	
}
