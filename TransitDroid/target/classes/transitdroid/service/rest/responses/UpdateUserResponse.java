package transitdroid.service.rest.responses;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UpdateUserResponse {
	private boolean succeed;
	private String message;
	
	public UpdateUserResponse(){}
	
	@XmlElement
	public boolean isSucceed() {
		return succeed;
	}

	public void setSucceed(boolean succeed) {
		this.succeed = succeed;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	@XmlElement
	public String getMessage() {
		return message;
	}

}
