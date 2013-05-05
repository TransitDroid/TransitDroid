package transitdroid.service.rest.requests;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import transitdroid.domain.entities.user.UserRole;

@XmlRootElement
public class UpdateUserRequest {
	private List<UserRole> roles;
	private String firstName;
	private String lastName;
	private String username;
	private byte[] password;
	private byte[] salt;
	private int version;
	private String id;
	
	public UpdateUserRequest(){}
	
	@XmlElement
	public List<UserRole> getRoles() {
		return roles;
	}
	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
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
	public byte[] getPassword() {
		return password;
	}
	public void setPassword(byte[] password) {
		this.password = password;
	}
	@XmlElement
	public byte[] getSalt() {
		return salt;
	}
	public void setSalt(byte[] salt) {
		this.salt = salt;
	}
	@XmlElement
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	@XmlElement
	public String getId() {
		return this.id;
	}
	
	public void setId(String id){
		this.id = id;
	}
}
