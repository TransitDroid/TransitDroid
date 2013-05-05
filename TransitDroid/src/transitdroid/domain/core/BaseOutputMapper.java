package transitdroid.domain.core;

import transitdroid.data.LostUpdateException;
import transitdroid.domain.core.exceptions.MapperException;


/** An abastract class of all OutputMappers. This class is to be extended by all
 * OutputMappers. It accepts as a parameter an object that extends DomainObject
 * 
 * 
 * @author TransitDroid Team
 * @class BaseOutputMapper
 *  An abastract class of all OutputMappers. This class is to be extended by all
 * 		  OutputMappers. It accepts as a parameter an object that extends DomainObject.
 * @param <DO>
 */
public abstract class BaseOutputMapper<DO extends IDomainObject> {

	public abstract boolean insert(DO object);
	public abstract boolean update(DO object) throws LostUpdateException, MapperException;
	public abstract boolean remove(DO object) throws LostUpdateException, MapperException;
}
