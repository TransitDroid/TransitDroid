package transitdroid.service.rest.responses;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import transitdroid.service.entities.User;

@XmlRootElement
public class CreateUserResponse {
	boolean succeed;
	User user;

	public CreateUserResponse(){}
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
	public void setUser(transitdroid.domain.entities.user.User user) {
		this.user = new User(user);
	}
	
	
}
