package transitdroid.domain.entities.mobiledevice;

import java.util.UUID;

import transitdroid.domain.core.BaseProxy;

public class MobileDeviceProxy extends BaseProxy<MobileDevice> implements IMobileDevice {

	public MobileDeviceProxy(UUID id) {
		super(id, MobileDevice.class);
	}

	@Override
	public int getVersion() {
		return getInnerObject().getVersion();
		
	}

	@Override
	public void setMobileDeviceMAC(String PMAC) {
		getInnerObject().setMobileDeviceMAC(PMAC);
		
	}

	@Override
	public String getMobileDeviceMAC() {
		return getInnerObject().getMobileDeviceMAC();
		
	}

	@Override
	public void setVersion(int i) {
		getInnerObject().setVersion(i);
		
	}

}
