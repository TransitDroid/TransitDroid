package transitdroid.service.rest.responses;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import transitdroid.service.entities.User;


@XmlRootElement
public class LoginResponse {
	private User user;
	private boolean isSucceed;
	private String message;
	
	public LoginResponse(){}
	@XmlElement
	public User getUser() {
		return user;
	}
	public void setUser(transitdroid.domain.entities.user.User user) {
		this.user = new User(user);
	}
	@XmlElement
	public boolean isSucceed() {
		return isSucceed;
	}
	public void setSucceed(boolean isSucceed) {
		this.isSucceed = isSucceed;
	}
	@XmlElement
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
