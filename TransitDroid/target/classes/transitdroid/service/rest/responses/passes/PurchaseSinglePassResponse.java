package transitdroid.service.rest.responses.passes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PurchaseSinglePassResponse {

	private boolean isSucceed;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PurchaseSinglePassResponse() {
	}

	@XmlElement(name = "succeed")
	public boolean getIsSucceed() {

		return isSucceed;
	}

	public void setSucceed(boolean isSucceed) {
		this.isSucceed = isSucceed;
	}

}
