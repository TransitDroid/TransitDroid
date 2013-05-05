package transitdroid.domain.entities.user;

import java.sql.SQLException;



import transitdroid.data.LostUpdateException;
import transitdroid.data.user.UserTOG;
import transitdroid.domain.core.BaseOutputMapper;
import transitdroid.domain.core.exceptions.MapperException;

/**
 * 
 * @author TransitDroid Team
 *  UserOutputMapper will act as a gate which outputs data from the domain layer to the data source. 
 *        It outputs data from User DomainObjects to the data source UserTOG.
 *        
 * UserOutputMapper is located in the Domain Layer of the Application. It communicates directly with its
 * corresponding TableOutputGateway i.e UserTOG. The UserOutputMapper contains insert, update and remove methods. 
 * A user of this class can insert a User object, Update a User Object, or remove a User object. The UserOutputMapper's
 * methods delegate the work and functionality to their corresponding static methods in the UserTOG. This class insures 
 * separation of concerns and produce cleaner code. This makes sure that SQL statements of the type "insert", "update",
 * and "delete" i.e remove are kept separate in the data source layer.
 */
public class UserOutputMapper extends BaseOutputMapper<User>{

	/**
	 *  passes a User DomainObject to UserTOG which inserts it into the database.
	 * @param User
	 */
	@Override
	public boolean insert(User user){
		try {
				UserTOG.insert(user.getId(), user.getVersion(), 
						user.getFirstName(), user.getLastName(), 
						user.getUsername(),
						user.getPassword(),
						user.getSalt());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	/**
	 *  passes a User DomainObject to UserTOG which updates it into the database.
	 * @param User
	 * @throws MapperException 
	 */
	
	@Override
	public boolean update(User user) throws MapperException{
		try {
			final int count = UserTOG.update(user.getId(), user.getVersion(), user.getFirstName(),
					user.getLastName(), user.getUsername(), user.getPassword(), user.getSalt());
			throwLostUpdateOnCountOfZero(user, count);
			user.setVersion(user.getVersion() + 1);
			return true;
		} catch (final SQLException e) {
			throw new MapperException(e);
		} catch (LostUpdateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public static void throwLostUpdateOnCountOfZero( User user,int count)
			throws LostUpdateException {
		if (count == 0)
			throw new LostUpdateException("User: id = " + user.getId()
					+ "; version = " + user.getVersion() + " not found");
	}
	/**
	 *  passes a User DomainObject to UserTOG which removes it from the database.
	 * @param User
	 * @throws LostUpdateException 
	 * @throws MapperException 
	 */
	@Override
	public boolean remove(User user) throws LostUpdateException, MapperException {
		// TODO Auto-generated method stub
		try {
			final int count = UserTOG.delete(user.getId(), user.getVersion());
			throwLostUpdateOnCountOfZero(user, count);
			return true;
		} catch (final SQLException e) {
			throw new MapperException(e);
		}
	}
}
