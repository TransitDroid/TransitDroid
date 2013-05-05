package transitdroid.service.rest.responses.passes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PurchaseDailyPassResponse {

	private boolean isSucceed;
	private String message;

	public PurchaseDailyPassResponse() {
	}

	@XmlElement(name = "succeed")
	public boolean isSucceed() {
		return isSucceed;
	}

	public void setSucceed(boolean isSucceed) {
		this.isSucceed = isSucceed;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
