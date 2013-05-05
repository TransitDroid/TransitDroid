package transitdroid.domain.entities.mobiledevice;

import java.util.IdentityHashMap;
import java.util.UUID;
/**
 * 
 * @author TransitDroid Team 
 * @class MobileDeviceIdentityMap
 *  Ensures that each MobileDevice object gets loaded only once in-memory by keeping every MobileDevice
 *        object in a map. It looks up the MobileDevice objects in the map when it needs to access them.
 *        
 * Problems can arise if a MobileDevice object is loaded into memory more than once and one instance is 
 * changed in one way, while another instance is changed in a different way (conflicts/concurrency issues). 
 * Correctness can not be guaranteed if both those changes were written to the database. The use of Identity
 * maps also help eliminate Cyclic Dependencies.
 *
 */
public class MobileDeviceIdentityMap {

	private static MobileDeviceIdentityMap instance = null;
	private static IdentityHashMap<UUID, MobileDevice> map = new IdentityHashMap<UUID, MobileDevice>();
	/**
	 *  Empty Constructor
	 */
	private MobileDeviceIdentityMap()
	{
	}
	/**
	 *  get the specific MobileDeviceIdentityMap instance. If doesn't exist then create one and return it.
	 * @return MobileDeviceIdentityMap
	 */
	public static MobileDeviceIdentityMap getUniqueInstance()
	{
		if(instance == null){
			instance = new MobileDeviceIdentityMap();
		}
		return instance;
	}
	/**
	 *  get the MobileDevice from the MobileDeviceIdentityMap's map with the specific UUID.
	 * @param UUID
	 * @return MobileDevice
	 */
	public MobileDevice get(UUID id)
	{
		return map.get(id);
	}
	/**
	 *  Put the specific MobileDevice with the UUID into the MobileDeviceIdentityMap's map.
	 * @param UUID
	 * @param MobileDevice
	 */
	public void put(MobileDevice mobileDevice)
	{
		map.put(mobileDevice.getId(), mobileDevice);
	}
	
}
