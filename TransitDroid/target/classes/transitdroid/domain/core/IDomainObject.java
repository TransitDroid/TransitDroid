package transitdroid.domain.core;

import java.util.UUID;
/**
 * 
 * @author TransitDroid Team
 * @class IDomainObject interface
 *  An interface which is implemented by DomainObject. This interface contains 
 *        methods that have to be implemented in all DomainObjects.
 */
public interface IDomainObject {

	UUID getId();

	public int getVersion();
		
	public void setVersion(int i);
	
	public void setId(UUID id);
	
	
}
