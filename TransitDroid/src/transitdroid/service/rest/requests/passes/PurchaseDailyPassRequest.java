package transitdroid.service.rest.requests.passes;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PurchaseDailyPassRequest {

	private String mobileDeviceMAC;
	private int version;
	private Date date;

	public PurchaseDailyPassRequest() {
	}

	
	public String getMobileDeviceMAC() {
		return mobileDeviceMAC;
	}

	public void setMobileDeviceMAC(String id) {
		this.mobileDeviceMAC = id;
	}

	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
