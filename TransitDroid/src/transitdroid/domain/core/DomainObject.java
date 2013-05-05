package transitdroid.domain.core;

import java.util.UUID;

/**
 * 
 * @author TransitDroid Team
 * @class DomainObject
 *  An Abstract class to all Domain Object. This class is to be extended by 
 * 		  all Domain Object Entities. DomainObject objects implement IDomainObject 
 * 		  interface.
 *
 */
public abstract class DomainObject implements IDomainObject{

	private UUID id;
	private int version;
	
	public DomainObject(){};
	
	/**
	 *  Parameterized Constructor which takes a UUID (Universal Unique IDentifier), and an int.
	 * 		  This 
	 * @param id each DomainObject will have a unique ID to identify it from other DomainObjects. DomainObject
	 * 		  id's are kept and saved in the database to know what object to load if needed.
	 * @param version DomainObjects have version numbers to keep track of the most recent DomainObject.
	 * 		  having a version field in DomainObject as part of in-memory objects insures that the most recent
	 *        version of the Object is loaded once an update is triggered. The versions of in-memory DomainObjects
	 *        can be compared with those in the database. If the versions match the update is allowed, else an 
	 *        exception can be thrown.  
	 */
	public DomainObject(UUID id, int version) {
		this.id = id;
		this.version = version;
	}
	/**
	 *  gets the UUID (Universal Unique IDentifier) of the DomainObject.
	 * @return UUID.
	 */
	public UUID getId() {
		return id;
	}
	/**
	 *  sets the UUID (Universal Unique IDentifier) of the DomainObject.
	 *        receives a UUID (Universal Unique IDentifier) as a parameter.
	 * @param id.
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 *  gets the int version number of the DomainObject.
	 * @return int
	 */
	public int getVersion() {
		return version;
	}

	/**
	 *  sets the int version number of the DomainObject.
	 * @param version
	 */
	public void setVersion(int version) {
		this.version = version;
	}
}
