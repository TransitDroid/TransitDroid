package transitdroid.service.rest.requests;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RegisterDeviceRequest {
	@XmlElement
	private String mobileDeviceMAC;
	@XmlElement
	private  String  userId;
	@XmlElement
	private String username;
	@XmlElement
	private String password;
	
	public RegisterDeviceRequest(){}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMobileDeviceMAC() {
		return mobileDeviceMAC;
	}
	public void setMobileDeviceMAC(String mobileDeviceMAC) {
		this.mobileDeviceMAC = mobileDeviceMAC;
	}
	
}
