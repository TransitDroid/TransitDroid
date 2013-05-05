package transitdroid.domain.entities.mobiledevice;

import java.net.URISyntaxException;
import java.util.UUID;

import transitdroid.domain.core.UnitOfWork;
/**
 * 
 * @author TransitDroid Team
 * @class MobileDeviceFactory
 *  This class is a Factory Class of the domain entity MobileDevice. It manages creation of new
 *        in-memory MobileDevice objects. The Factory Class makes the appropriate calls to the UOW. 
 */
public class MobileDeviceFactory {

	/**
	 *  Creates a new MobileDevice object with the specified parameters passed. specifically UUID and version.
	 * 
	 * @param id UUID of the MobileDevice
	 * @param version int version of the in-memory MobileDevice object
	 * @param PMAC String phoneMAC address
	 * @return MobileDevice
	 */
	@SuppressWarnings("unchecked")
	public static MobileDevice createNew(UUID id, int version, String PMAC)
	{
		MobileDevice mobileDevice = new MobileDevice(id,version,PMAC);
		UnitOfWork.getInstance().RegisterNew(mobileDevice);
		MobileDeviceIdentityMap.getUniqueInstance().put(mobileDevice);
		return mobileDevice;
	}
	/**
	 *  Creates a new MobileDevice object with the specified parameters passed i.e phoneMAC. 
	 * 
	 * @param PMAC String phoneMAC address
	 * @return MobileDevice 
	 * @throws URISyntaxException
	 */
	public static MobileDevice createNew(String PMAC) throws URISyntaxException
	{
		UUID id= UUID.randomUUID();
		
		MobileDevice device =  createNew(id,1,PMAC);
		return device;
	}
	/**
	 *  Creates a new MobileDevice object with the specified parameters passed. specifically UUID and version.
	 * 
	 * @param id UUID of the MobileDevice
	 * @param version int version of the in-memory MobileDevice object
	 * @param PMAC String phoneMAC address
	 * @return MobileDevice
	 */
	public static MobileDevice createClean(UUID id, int version, String PMAC)
	{
		MobileDevice mobileDevice = new MobileDevice(id,version,PMAC);
		MobileDeviceIdentityMap.getUniqueInstance().put(mobileDevice);
		return mobileDevice;
	}
	
	public static MobileDevice createEmpty(){
		return new MobileDevice();
	}
}
