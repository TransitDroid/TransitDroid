package transitdroid.domain.entities.user;

import java.util.IdentityHashMap;
import java.util.UUID;
/**
 * 
 * @author TransitDroid Team 
 * @class UserIdentityMap
 *  Ensures that each User object gets loaded only once in-memory by keeping every User
 *        object in a map. It looks up the User objects in the map when it needs to access them.
 *        
 * Problems can arise if a User object is loaded into memory more than once and one instance is 
 * changed in one way, while another instance is changed in a different way (conflicts/concurrency issues). 
 * Correctness can not be guaranteed if both those changes were written to the database. The use of Identity
 * maps also help eliminate Cyclic Dependencies.
 *
 */
class UserIdentityMap {

	private static UserIdentityMap instance = null;
	private static IdentityHashMap<UUID, User> map = new IdentityHashMap<UUID, User>();
	/**
	 *  Empty Constructor
	 */
	private UserIdentityMap(){
	}
	/**
	 *  get the specific UserIdentityMap instance. If doesn't exist then create one and return it.
	 * @return UserIdentityMap
	 */
	static UserIdentityMap getUniqueInstance() {
		if(instance == null){
			instance = new UserIdentityMap();
		}
		return instance;
	}
	/**
	 *  get the User from the UserIdentityMap's map with the specific UUID.
	 * @param UUID
	 * @return User
	 */
	User get(UUID id){
		return map.get(id);
	}
	/**
	 *  Put the specific User with the UUID into the UserIdentityMap's map.
	 * @param UUID
	 * @param User
	 */
	void put(UUID uuid, User user){
		map.put(uuid, user);
	}
}
