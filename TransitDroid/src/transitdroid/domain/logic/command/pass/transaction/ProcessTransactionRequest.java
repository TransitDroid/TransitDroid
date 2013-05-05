package transitdroid.domain.logic.command.pass.transaction;

import java.util.ArrayList;
import java.util.List;

import transitdroid.domain.core.CommandRequest;

class ProcessTransactionRequest extends CommandRequest {
	private List<String> keys = new ArrayList<String>();
	private String passcode;
	private String phoneMac;
	
	public ProcessTransactionRequest(){}
	
	List<String> getKeys() {
		return keys;
	}
	public void setKeys(List<String> keys) {
		this.keys = keys;
	}
	String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	String getPhoneMac() {
		return phoneMac;
	}
	public void setPhoneMac(String phoneMac) {
		this.phoneMac = phoneMac;
	}
}
