package transitdroid.domain.entities.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


import transitdroid.data.user.UserTIG;
import transitdroid.domain.core.BaseInputMapper;

/**
 * 
 * @author TransitDroid Team
 *  UserInputMapper will act as a gate which inputs data from the data source layer. It inputs
 *        data to the instances of User DomainObjects.
 *        
 * UserInputMapper is located in the Domain Layer of the Application. It communicates directly with its
 * corresponding TableInputGateway i.e UserTIG. The UserInputMapper contains find and map methods. A user
 * of this class can find if an object exists in the database or in-memory by simply passing the desired 
 * UUID of that object. The UserInputMapper will try to find it in the UserIdentityMap (if it is in-memory), 
 * else it will delegate finding it in the database to UserTIG. This class insures separation of concerns
 * and produce cleaner code. This makes sure that SQL statements of the type "find" are kept separate
 * in the data source layer.
 *
 */
public class UserInputMapper extends BaseInputMapper<User>{

	//TODO: remove findAll - should not exist
	/**
	 *  find and return a User Object. Search in the UserIdentityMap and return the User object. 
	 * If not found in the UserIdentityMap, pass the UUID of the object to UserTIG and return the User
	 * from the database. 
	 * @return User
	 */
		public User find(UUID id){
			ResultSet set = null;
			User user = null;
			if ((user = UserIdentityMap.getUniqueInstance().get(id)) != null){
				return user;
			}
			try{
				set = UserTIG.find(id);
				if (set.next())
				user = map(set);
			} catch(SQLException e){
				e.printStackTrace();
			}
			
			return user;
		}
		/**
		 *  find and return a User Object. Search in the UserIdentityMap and return the User object. 
		 * If not found in the UserIdentityMap, pass the "username" and "password" of the object to UserTIG 
		 * and return the User from the database. 
		 * @return User
		 */
		public User find(String username, String password) throws SQLException {
			ResultSet set = null;
			User user = null;
				set = UserTIG.find(username);
				if (set.next()){
					user = map(set);
				}
			return user;
		}
		//TODO(PS): user roles
		/**
		 *  In this method after retrieving a new User object from the UserTIG (database) it creates
		 *        a new in-memory User object and adds it to the UserFactory's create clean and then adds it
		 *        to the UserIdentityMap. If the User already exists in the UserIdentity just load it.
		 * @return User
		 */
		protected User map(ResultSet set) throws SQLException{
			User user = null;
			if ((user = UserIdentityMap.getUniqueInstance().get(UUID.fromString(set.getString(1)))) != null){
				return user;
			}
			user = UserFactory.createClean(UUID.fromString(set.getString("id")), set.getInt("version"), null, set.getString("firstName"),
					set.getString("lastName"), set.getString("username"), set.getBytes("password"), set.getBytes("salt"));	
			UserIdentityMap.getUniqueInstance().put(user.getId(), user);
			return user;
		}

}
