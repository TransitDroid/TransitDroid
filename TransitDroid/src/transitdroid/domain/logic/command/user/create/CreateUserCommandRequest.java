package transitdroid.domain.logic.command.user.create;

import java.util.List;

import transitdroid.domain.core.CommandRequest;
import transitdroid.domain.entities.user.UserRole;

class CreateUserCommandRequest extends CommandRequest{
	private String username;
	private List<UserRole> roles;
	private String password;
	private String firstName;
	private String lastName;
	
	public CreateUserCommandRequest(){}
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<UserRole> getRoles() {
		return roles;
	}
	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "CreateUserCommandRequest [username=" + username + ", roles="
				+ roles + ", password=" + (password !=null)
				+ ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}
