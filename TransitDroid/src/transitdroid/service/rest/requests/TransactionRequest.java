package transitdroid.service.rest.requests;

import java.util.Collection;
import java.util.LinkedList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TransactionRequest{

	@XmlElementWrapper(name = "keys")
	@XmlElement(name = "key")
	Collection<String> keys = new LinkedList<String>();
	@XmlElement
	String passcode;
	@XmlElement
	String phoneMac;
	
	public TransactionRequest(){}
	
	
	public Collection<String> getKeys() {
		return keys;
	}
	public void setKeys(Collection<String> keys) {
		this.keys = keys;
	}
	
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	
	public String getPhoneMac() {
		return phoneMac;
	}
	public void setPhoneMac(String phoneMac) {
		this.phoneMac = phoneMac;
	}
}
