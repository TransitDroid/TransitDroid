package transitdroid.domain.logic.command.user;

public class InvalidUsernameOrPasswordException extends RuntimeException {

	private static final long serialVersionUID = 5306773233562297030L;

	@Override
	public String getMessage(){
		return "Invalid username or password::" + super.getMessage();
	}
}
