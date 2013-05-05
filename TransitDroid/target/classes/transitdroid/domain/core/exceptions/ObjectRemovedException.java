package transitdroid.domain.core.exceptions;

import transitdroid.domain.core.IDomainObject;

/**
 * 
 * @author TransitDroid Team
 * @class ObjectRemovedException 
 *  This class extends Throwable and it throws an Exception if there was a problem
 *        removing an Object from its Identity Map.
 *
 */
public class ObjectRemovedException extends Throwable{

	private static final long serialVersionUID = 43721849032146L;

	public IDomainObject getRemovedObject() {
		return null;
	}

}
