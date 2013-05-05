package transitdroid.service.rest.requests.passes;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class PurchaseYearlyPassRequest {
	
	private String mobileDeviceMAC;
	private int version;
	private Date date;
	
	
	public PurchaseYearlyPassRequest(){}
	
	@XmlElement
	public String getMobileDeviceMAC(){
		return mobileDeviceMAC;
	}
	
	@XmlElement
	public int getVersion(){
		return version;
	}
	
	@XmlElement
	public Date getDate(){
		return date;
	}

	public void setMobileDeviceMAC(String id) {
		this.mobileDeviceMAC = id;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
