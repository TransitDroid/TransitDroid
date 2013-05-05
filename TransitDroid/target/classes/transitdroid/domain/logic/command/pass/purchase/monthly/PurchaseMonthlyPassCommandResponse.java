package transitdroid.domain.logic.command.pass.purchase.monthly;

import transitdroid.domain.core.CommandResponse;

public class PurchaseMonthlyPassCommandResponse extends CommandResponse {

	private boolean succeed;
	private Exception exception;

	public boolean isSucceed() {
		return succeed;
	}

	public void setSucceed(boolean succeed) {
		this.succeed = succeed;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	
}
