package transitdroid.service.rest.responses;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TransactionResponse{
	
	private String passcode;
	private Collection<String> keys = new ArrayList<String>();
	private String code;
	private String message;
	
	public TransactionResponse(){}
	
	@XmlElement
	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	@XmlElement
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	@XmlElement
	public Collection<String> getKeys() {
		return keys;
	}

	public void setKeys(Collection<String> keys) {
		this.keys = keys;
	}
	
	public void addKey(String key){
		this.keys.add(key);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
