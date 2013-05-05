package transitdroid.domain.entities.user;
/**
 * 
 * @author TransitDroid Team
 * @class UserRole enum
 *  An enum to indicate if a User is an ADMINISTRATOR or a PASSENGER
 *
 */
public enum UserRole {

	ADMINISTRATOR (0),
	PASSENGER (1);
	
	private final int index;   

	UserRole(int index) {
        this.index = index;
    }

    public int index() { 
        return index; 
    }
	 
}
