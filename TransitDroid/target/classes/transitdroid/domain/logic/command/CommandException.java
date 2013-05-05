package transitdroid.domain.logic.command;

public class CommandException extends RuntimeException {

	
	private static final long serialVersionUID = -5432966224939009881L;
	private Exception innerException;
	
	public CommandException(Exception e){
		setInnerException(e);
	}

	public CommandException(){
		super();
	}
	public Exception getInnerException() {
		return innerException;
	}

	public void setInnerException(Exception innerException) {
		this.innerException = innerException;
	}
	
}
