package transitdroid.service.rest.requests;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CreateUserRequest {
	private List<String> roles = new ArrayList<String>();
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	public CreateUserRequest(){}
	@XmlElementWrapper(name = "roles")
	@XmlElement(name = "role")
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> InRoles) {
		this.roles = InRoles;
	}
	@XmlElement
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@XmlElement
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@XmlElement
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@XmlElement
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
