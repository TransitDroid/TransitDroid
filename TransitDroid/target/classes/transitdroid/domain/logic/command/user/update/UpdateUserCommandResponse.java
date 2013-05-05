package transitdroid.domain.logic.command.user.update;

import transitdroid.domain.core.CommandResponse;

public class UpdateUserCommandResponse extends CommandResponse {
	private boolean succeed;
	private Exception exception;
	
	public UpdateUserCommandResponse(){}

	public boolean isSucceed() {
		return succeed;
	}
	public void setSucceed(boolean succeed) {
		this.succeed = succeed;
	}

	public void setException(Exception exception) {
		this.exception = exception;
		
	}

	public Exception getException() {
		return exception;
	}
}
