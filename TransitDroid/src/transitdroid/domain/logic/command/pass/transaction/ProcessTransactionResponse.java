package transitdroid.domain.logic.command.pass.transaction;

import java.util.ArrayList;
import java.util.List;

import transitdroid.domain.core.CommandResponse;
import transitdroid.domain.entities.enums.TransactionResponseCode;

class ProcessTransactionResponse extends CommandResponse {
	private List<String> keys = new ArrayList<String>();
	private String passcode;
	private TransactionResponseCode code;
	private Exception exception;
	
	public ProcessTransactionResponse(){}
	
	public List<String> getKeys() {
		return keys;
	}
	void setKeys(List<String> keys) {
		this.keys = keys;
	}
	public String getPasscode() {
		return passcode;
	}
	void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	public TransactionResponseCode getCode() {
		return code;
	}
	void setCode(TransactionResponseCode code) {
		this.code = code;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}
	
	
}
