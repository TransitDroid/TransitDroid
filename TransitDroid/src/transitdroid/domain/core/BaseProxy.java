package transitdroid.domain.core;

import java.sql.SQLException;
import java.util.UUID;

import transitdroid.domain.core.IDomainObject;
import transitdroid.domain.core.exceptions.ObjectRemovedException;
import transitdroid.domain.core.exceptions.ProxyException;


/**
 * 
 * @author TransitDroid Team
 * @class BaseProxy
 * @brief An abstract class of all proxies. This class is to be extended by all proxies.
 *        It accepts as a parameter an Object that extends IDomainObject.
 *        
 * @param <DOMAIN_OBJECT>
 */
public abstract class BaseProxy<DOMAIN_OBJECT extends IDomainObject>{

	private UUID id;
	private DOMAIN_OBJECT innerObject;
	private Class<?> innerObjectClass;
	/**
	 * @brief A constructor that receives a UUID ( Universal Unique IDentifier)as a parameter. 
	 * @param id
	 * @param class1 
	 */
	protected BaseProxy(UUID id, Class<?> class1){
		this.id = id;
		this.innerObjectClass = class1;
	}
	/**
	 * @brief return the Inner real Object that the Proxy represents.
	 * @return DOMAIN_OBJECT
	 */
	@SuppressWarnings("unchecked")
	public synchronized DOMAIN_OBJECT getInnerObject() {
		if(innerObject==null)
			try{
				innerObject = getFromMapper();
			} catch (ObjectRemovedException e) {
				return (DOMAIN_OBJECT) e.getRemovedObject();
			} catch (Exception e) {
				throw new ProxyException(e);
			}
		return innerObject;
	}
	
	@SuppressWarnings("unchecked")
	protected  DOMAIN_OBJECT getFromMapper() throws ObjectRemovedException, SQLException{
		if (innerObject == null){
		innerObject = (DOMAIN_OBJECT) MapperRepository.getInputMapper(innerObjectClass).find(this.id);
		}
		return innerObject;
	}
	/**
	 * @brief gets the UUID of the Proxy
	 * @return UUID
	 */
	public UUID getId() {
		return id;
	}
	/**
	 * @brief sets the UUIS of the Proxy
	 * @param id
	 */
	public void setId(UUID id) {
		this.id = id;
	}
	public Class<?> getInnerObjectClass() {
		return innerObjectClass;
	}
	public void setInnerObjectClass(Class<?> innerObjectClass) {
		this.innerObjectClass = innerObjectClass;
	}
	
	
}
