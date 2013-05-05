package transitdroid.domain.entities.user;

import java.util.List;
import java.util.UUID;


import transitdroid.domain.core.BaseProxy;
import transitdroid.domain.core.exceptions.ProxyException;

/**
 * 
 * @author TransitDroid Team
 * @class UserProxy
 *  Acts as a Proxy to User DomainObjects. This class extends BaseProxy and implements IUser.
 * 
 * This is an object that doesn't contain all the data about a User but knows how to get it. This is
 * a common method called Lazy Loading. If each object loaded into memory loads up all associated 
 * objects then one may end up with all the database loaded into memory slowing the application. So 
 * instead of loading a User object into memory, it will only be loaded when needed via the help of
 * its UserProxy.
 *
 */
public class UserProxy extends BaseProxy<User> implements IUser{
	/**
	 *  Parameterized Constructor
	 * @param id UUID of the UserProxy
	 */
	public UserProxy(UUID id) {
		super(id, User.class);
	}
	/**
	 *  Compare and check if two proxies are equal
	 * @param Object
	 */
	public boolean equals(Object arg0) {
		
		return getInnerObject().equals(arg0);
	}
	/**
	 *  get the User Roles of the UserProxy's innerObject
	 * @return List<UserRole>
	 */
	public List<UserRole> getRoles() {
		return getInnerObject().getRoles();
	}
	/**
	 *  set the User Roles of the UserProxy's innerObject
	 * @param List<UserRole>
	 */
	public void setRoles(List<UserRole> roles) {
		getInnerObject().setRoles(roles);
	}
	/**
	 *  get the first name of the UserProxy's innerObject
	 * @return String
	 */
	public String getFirstName() {
		return getInnerObject().getFirstName();
	}
	/**
	 *  set the first name of the UserProxy's innerObject
	 * @param String
	 */
	public void setFirstName(String firstName) {
		getInnerObject().setFirstName(firstName);
	}
	/**
	 *  get the last name of the UserProxy's innerObject
	 * @return String
	 */
	public String getLastName() {
		return getInnerObject().getLastName();
	}
	/**
	 *  set the last name of the UserProxy's innerObject
	 * @param String
	 */
	public void setLastName(String lastName) {
		getInnerObject().setLastName(lastName);
	}
	/**
	 *  get the username of the UserProxy's innerObject
	 * @return String
	 */
	public String getUsername() {
		return getInnerObject().getUsername();
	}
	/**
	 *  get the password of the UserProxy's innerObject
	 * @return byte[]
	 */
	public byte[] getPassword() {
		return getInnerObject().getPassword();
	}
	/**
	 *  get the hashcode of the UserProxy's innerObject
	 * @return int
	 */
	public int hashCode() {
		return getInnerObject().hashCode();
	}
	/**
	 *  set the user name of the UserProxy's innerObject
	 * @param String
	 */
	public void setUsername(String username) {
		getInnerObject().setUsername(username);
	}
	/**
	 *  set the password of the UserProxy's innerObject
	 * @param byte[]
	 */
	public void setPassword(byte[] password) {
		getInnerObject().setPassword(password);
	}
	/**
	 *  get the salt of the UserProxy's innerObject
	 * @return byte[]
	 */
	public byte[] getSalt(){
		return getInnerObject().getSalt();
	}
	/**
	 *  set the salt of the UserProxy's innerObject
	 * @return byte[]
	 */
	public void setSalt(byte[] salt){
		getInnerObject().setSalt(salt);
	}

	@Override
	public int getVersion() {
		return getInnerObject().getVersion();
	}
	@Override
	public String toString() {
		String result = null;
		try {
			result = getInnerObject().toString();
		} catch (ProxyException e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public void setVersion(int i) {
		getInnerObject().setVersion(i);
		
	}
}
