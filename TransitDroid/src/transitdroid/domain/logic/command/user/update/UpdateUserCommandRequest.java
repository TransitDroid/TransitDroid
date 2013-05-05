package transitdroid.domain.logic.command.user.update;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;


import transitdroid.domain.core.CommandRequest;
import transitdroid.domain.entities.user.UserRole;

public class UpdateUserCommandRequest extends CommandRequest {
	private UUID id;
	private List<UserRole> roles;
	private String firstName;
	private String lastName;
	private String username;
	private byte[] password;
	private byte[] salt;
	private int version;
	
	public UpdateUserCommandRequest(){}
	
	public void setId(String id){
		this.id = UUID.fromString(id);
	}
	public UUID getId(){
		return this.id;
	}
	public List<UserRole> getRoles() {
		return roles;
	}
	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public byte[] getPassword() {
		return password;
	}
	public void setPassword(byte[] password) {
		this.password = password;
	}
	public byte[] getSalt() {
		return salt;
	}
	public void setSalt(byte[] salt) {
		this.salt = salt;
	}
	public void setVersion(int version){
		this.version = version;
	}
	public int getVersion() {
		return version;
	}

	@Override
	public String toString() {
		return "UpdateUserCommandRequest [id=" + id + ", roles=" + roles
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", username=" + username + ", password="
				+ Arrays.toString(password) + ", salt=" + Arrays.toString(salt)
				+ ", version=" + version + "]";
	}
}
