package transitdroid.domain.entities.mobiledevice;

import transitdroid.domain.core.IDomainObject;

public interface IMobileDevice extends IDomainObject{
	
	public void setMobileDeviceMAC(String PMAC);
	public String getMobileDeviceMAC();
}
