package transitdroid.service.rest.requests.passes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PurchaseMonthlyPassRequest {
	
	private String mobileDeviceMAC;
	private int version;
	private int month;
	private int year;
	
	
	public PurchaseMonthlyPassRequest(){}
	
	
	@XmlElement
	public int getVersion(){
		return version;
	}
	@XmlElement
	public int getMonth(){
		return month;
	}
	@XmlElement
	public int getYear(){
		return year;
		
	}

	public void setVersion(int version) {
		this.version = version;
	}


	public void setMonth(int month) {
		this.month = month;
	}


	public void setYear(int year) {
		this.year = year;
	}

	@XmlElement
	public String getMobileDeviceMAC() {
		return mobileDeviceMAC;
	}


	public void setMobileDeviceMAC(String mobileDeviceMAC) {
		this.mobileDeviceMAC = mobileDeviceMAC;
	}
	


}
