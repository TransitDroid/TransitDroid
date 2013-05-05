package transitdroid.domain.entities.user;

import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

import transitdroid.domain.core.UnitOfWork;


/**
 * 
 * @author TransitDroid Team
 * @class UserFactory
 *  This class is a Factory Class of the domain entity User. It manages creation of new
 *        in-memory User objects. The Factory Class makes the appropriate calls to the UOW. 
 */
public class UserFactory {

	/**
	 *  Creates a new User object with the specified parameters passed. No UUID or version number.
	 * 
	 * @param roles UserRole list
	 * @param firstName String
	 * @param lastName String
	 * @param card ICard to link the User to a specific Card
	 * @param username String
	 * @param password Array of bytes to specify the password
	 * @param salt Array of bytes that is changed upon every transaction to secure authentication
	 * @return User
	 * @throws URISyntaxException
	 */
	public static User createNew(List<UserRole> roles, String firstName,
			String lastName, String username, byte[] password, byte[] salt) throws URISyntaxException{

		UUID id = UUID.randomUUID();
		
		return createNew(id, 1, roles, firstName, lastName, username, password, salt);
		
	}
	/**
	 *   Creates a new User object with the specified parameters passed. With UUID and version number.
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
	 * @return User
	 */
	@SuppressWarnings("unchecked")
	public static User createNew(UUID id, int version, List<UserRole> roles, String firstName,
			String lastName, String username, byte[] password, byte[] salt){
		User user = new User(id, version, roles, firstName, lastName, username, password, salt);
		UserIdentityMap.getUniqueInstance().put(user.getId(), user);
		UnitOfWork.getInstance().RegisterNew(user);
		return user;
	}
	/**
	 *  Creates a new User object with the specified parameters passed. With UUID and version number.
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
	 * @return User
	 */
	public static User createClean(UUID id, int version, List<UserRole> roles, String firstName,
			String lastName, String username, byte[] password, byte[] salt){
		User user = new User(id, version, roles, firstName, lastName, username, password, salt);
		return user;
	}

	
}
