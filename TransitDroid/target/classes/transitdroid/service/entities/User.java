package transitdroid.service.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import transitdroid.domain.entities.user.UserRole;

@XmlType
public class User {
	private transitdroid.domain.entities.user.User user;

	public User(){}
	
	public User(transitdroid.domain.entities.user.User user) {
		this.user = user;
	}
	@XmlElement(name = "id")
	public String getId() {
		return user.getId().toString();
	}
	@XmlElement(name = "roles")
	public List<UserRole> getRoles() {
		return user.getRoles();
	}
	@XmlElement(name = "firstName")
	public String getFirstName() {
		return user.getFirstName();
	}
	@XmlElement(name = "lastName")
	public String getLastName() {
		return user.getLastName();
	}
	@XmlElement(name = "username")
	public String getUsername() {
		return user.getUsername();
	}
	@XmlElement(name = "salt")
	public byte[] getSalt(){
		return user.getSalt();
	}
}
