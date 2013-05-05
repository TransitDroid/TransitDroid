package transitdroid.domain.logic.command;

public class CommandParameterNotSetException extends RuntimeException {

	private static final long serialVersionUID = 5447028344445288734L;
	public CommandParameterNotSetException(String message){
		super(message);
	}
	public CommandParameterNotSetException(){
		super();
	}
	@Override
	public String getMessage(){
		return "You have to set all parameters for the request:" + super.getMessage();
	}
}
