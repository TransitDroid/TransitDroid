package transitdroid.domain.entities.user;

import java.util.List;
import java.util.UUID;


import transitdroid.domain.core.DomainObject;

/**
 * User Class contains private attributes indicating specific information about the User. The firstName,
 * lastName,userName, a byte[] password, ICard, the byte[] salt, and a list of UserRole.

 * @author TransitDroid Team
 * @class User
 * 

 */
public class User extends DomainObject implements IUser {

	private List<UserRole> roles;
	private String firstName;
	private String lastName;
	private String username;
	private byte[] password;
	private byte[] salt;
	/**
	 *  Parameterized Constructor
	 * 
	 * @param id UUID of the User object
	 * @param version int version number of the in-memory User object
	 * @param roles UserRole list
	 * @param firstName String
	 * @param lastName String
	 * @param card ICard to link the User to a specific Card
	 * @param username String
	 * @param password Array of bytes to specify the password
	 * @param salt Array of bytes that is changed upon every transaction to secure authentication
	 */
	public User(UUID id, int version, List<UserRole> roles, String firstName,
			String lastName, String username, byte[] password, byte[] salt) {
		super(id, version);
		this.roles = roles;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.setSalt(salt);
	}
	/**
	 *  Empty Constructor
	 */
	User(){}
	/**
	 *  get the User Roles
	 * @return List<UserRole>
	 */
	public List<UserRole> getRoles() {
		return roles;
	}
	/**
	 *  set the User Roles
	 * @param List<UserRole>
	 */
	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}
	/**
	 *  get the first name of the user
	 * @return String
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 *  set the first name of the User
	 * @param String
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 *  get the last name of the User
	 * @return String
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 *  set the last name of the User
	 * @param String
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 *  get the user name of the User
	 * @return String
	 */
	public String getUsername() {
		return username;
	}
	/**
	 *  set the user name of the User
	 * @param String
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 *  get the password of the User
	 * @return byte[]
	 */
	public byte[] getPassword() {
		return password;
	}
	/**
	 *  set the password of the User
	 * @param byte[]
	 */
	public void setPassword(byte[] password) {
		this.password = password;
	}
	/**
	 *  get the salt of the User
	 * @return byte[]
	 */
	public byte[] getSalt() {
		return salt;
	}
	/**
	 *  set the salt of the User
	 * @param byte[]
	 */
	public void setSalt(byte[] salt) {
		this.salt = salt;
	}
	
}
