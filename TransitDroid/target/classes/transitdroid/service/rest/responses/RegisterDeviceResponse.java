package transitdroid.service.rest.responses;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import transitdroid.service.entities.User;

@XmlRootElement
public class RegisterDeviceResponse {
	private boolean succeed;
	private User user;
	private String Message;
	private List<String> keys = new ArrayList<String>();
	private String salt;
	public RegisterDeviceResponse(){}
	
	@XmlElement
	public boolean isSucceed() {
		return succeed;
	}

	public void setSucceed(boolean succeed) {
		this.succeed = succeed;
	}
	@XmlElement
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@XmlElement
	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
	@XmlElement
	public List<String> getKeys() {
		return keys;
	}

	public void setKeys(List<String> keys) {
		this.keys = keys;
	}
	@XmlElement
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	
}
