package transitdroid.domain.entities.mobiledevice;

import java.util.UUID;

import transitdroid.domain.core.DomainObject;

/**
 * 
 * @author TransitDroid Team
 * @class MobileDevice
 *  This is a domain entity that extends DomainObject and implements IMobileDevice.
 * 
 * MobileDevice Class contains private attributes indicating specific information about the phone.
 * The mobileDeviceMAC address, phone brand, and androidVersion running on the phone are examples of
 * such attributes.
 */
public class MobileDevice extends DomainObject implements IMobileDevice{

	private String mobileDeviceMAC;
	/**
	 *  parameterized constructor with a UUID and a version number of the in-memory object.
	 * 
	 * @param id UUID of the MobileDevice DomainObject
	 * @param version of the MobileDevice DomainObject (int)
	 * @param PMAC of the MobileDevice DomainObject (String)
	 */
	public MobileDevice(UUID id, int version, String PMAC)
	{
		super(id, version);
		this.mobileDeviceMAC = PMAC;
	}
	public MobileDevice() {	}
	/**
	 *  set the mobileDeviceMAC attribute
	 * @param PMAC String
	 */
	public void setMobileDeviceMAC(String PMAC) {
		// TODO Auto-generated method stub
		mobileDeviceMAC = PMAC;
	}
	/**
	 *  get the mobileDeviceMAC attribute
	 * @return String mobileDeviceMAC
	 */
	public String getMobileDeviceMAC() {
		// TODO Auto-generated method stub
		return mobileDeviceMAC;
	}
	
	
	
}
