package transitdroid.service.rest.requests.passes;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PurchaseNightlyPassRequest {
	
	private String monbileDeviceMAC;
	private int version;
	private Date date;
	
	
	public PurchaseNightlyPassRequest(){}
	
	@XmlElement
	public String getMobileDeviceMAC() {
		return monbileDeviceMAC;
	}
	public void setMobileDeviceMac(String id) {
		this.monbileDeviceMAC = id;
	}
	@XmlElement
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	@XmlElement
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
