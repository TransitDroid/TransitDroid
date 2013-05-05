package transitdroid.domain.logic.command.pass.purchase.weekly;

import transitdroid.domain.core.CommandResponse;

public class PurchaseWeeklyPassCommandResponse extends CommandResponse {

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
