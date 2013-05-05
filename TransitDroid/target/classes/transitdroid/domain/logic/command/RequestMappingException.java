package transitdroid.domain.logic.command;

public class RequestMappingException extends RuntimeException {

	private static final long serialVersionUID = -3158347809363839829L;

	public String getMessage(){
		return super.getMessage()+": The Request used in the command does not match the command.";
	}
}
