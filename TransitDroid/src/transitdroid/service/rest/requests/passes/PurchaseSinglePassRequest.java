package transitdroid.service.rest.requests.passes;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class PurchaseSinglePassRequest {
	
	private String mobileDeviceMAC;
	private int version;
	private int quantity;
	private Date date;
	
	public PurchaseSinglePassRequest(){}
	
	public void setMobileDeviceMAC(String id) {
		this.mobileDeviceMAC = id;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@XmlElement
	public String getMobileDeviceMAC(){
		
		return mobileDeviceMAC;
	}
	
	@XmlElement
	public int getVersion(){
		
		return version;
	}
	
	@XmlElement
	public int getQuantity(){
		return quantity;
	}
	
	@XmlElement
	public Date getDate(){
		return date;
	}
	
	

}
