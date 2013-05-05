package transitdroid.domain.entities.user;
/**
 * 
 * @author TransitDroid Team
 * @class UserType enum
 *  An enum to indicate if a User is REGULAR, SENIOR,STUDENT, or AID
 *
 */
enum UserType {

	REGULAR (0),
	SENIOR (1),
	STUDENT (2),
	AID (3);
	
	private final int index;   

	UserType(int index) {
        this.index = index;
    }

    public int index() { 
        return index; 
    }
}
