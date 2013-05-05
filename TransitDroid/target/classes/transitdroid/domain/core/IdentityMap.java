package transitdroid.domain.core;

import java.util.IdentityHashMap;
import java.util.UUID;


public class IdentityMap<O extends IDomainObject> {
	IdentityHashMap<UUID, O> map = new IdentityHashMap<UUID, O>();
	public IdentityMap(){}
	
	/**
	 *  get the specific MobileDeviceIdentityMap instance. If doesn't exist then create one and return it.
	 * @return MobileDeviceIdentityMap
	 */

	
	/**
	 *  get the MobileDevice from the MobileDeviceIdentityMap's map with the specific UUID.
	 * @param UUID
	 * @return MobileDevice
	 */
	public O get(UUID id)
	{
		return map.get(id);
	}
	/**
	 *  Put the specific MobileDevice with the UUID into the MobileDeviceIdentityMap's map.
	 * @param UUID
	 * @param MobileDevice
	 */
	public void put(O domainObject)
	{
		map.put(domainObject.getId(), domainObject);
	}
}
