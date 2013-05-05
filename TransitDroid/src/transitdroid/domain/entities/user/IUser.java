package transitdroid.domain.entities.user;

import java.util.List;

import transitdroid.domain.core.IDomainObject;

public interface IUser extends IDomainObject{
	public List<UserRole> getRoles();
	public void setRoles(List<UserRole> roles);
	public String getFirstName();
	public void setFirstName(String firstName);
	public String getLastName();
	public void setLastName(String lastName);
	public String getUsername();
	public void setUsername(String username);
	public byte[] getPassword();
	public void setPassword(byte[] password);
	public byte[] getSalt();
	public void setSalt(byte[] salt);
}
