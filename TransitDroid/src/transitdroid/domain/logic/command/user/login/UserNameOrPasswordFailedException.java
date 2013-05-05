package transitdroid.domain.logic.command.user.login;

public class UserNameOrPasswordFailedException extends Exception {

	
	private static final long serialVersionUID = 9106882152900652917L;

	public String getMessage(){
		return "Invalid credentials were given!";
	}
}
