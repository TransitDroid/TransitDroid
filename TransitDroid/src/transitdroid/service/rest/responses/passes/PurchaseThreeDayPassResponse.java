package transitdroid.service.rest.responses.passes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PurchaseThreeDayPassResponse {

	private boolean isSucceed;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PurchaseThreeDayPassResponse() {
	}

	@XmlElement(name = "succeed")
	public boolean isSucceed() {

		return isSucceed;
	}

	public void setSucceed(boolean isSucceed) {
		this.isSucceed = isSucceed;
	}

}
