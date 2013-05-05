package transitdroid.domain.logic.command.user.login;


import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.UUID;
import transitdroid.domain.core.Guard;
import transitdroid.domain.core.MapperRepository;
import transitdroid.domain.entities.user.User;
import transitdroid.domain.entities.user.UserFactory;
import transitdroid.domain.entities.user.UserInputMapper;
import transitdroid.domain.entities.user.UserRole;
import transitdroid.domain.logic.command.CommandException;
import transitdroid.domain.logic.command.CommandParameterNotSetException;
import transitdroid.domain.logic.command.ICommand;
import transitdroid.domain.logic.technical.EncryptionService;
import transitdroid.domain.logic.technical.exceptions.AuthenticationException;

@SuppressWarnings("unused")
public class UserLoginCommand implements ICommand{

	private UserLoginCommandRequest req = new UserLoginCommandRequest();
	private UserLoginCommandResponse res = new UserLoginCommandResponse();
	
	public void execute() {
		if (!Guard.notNull(req.getUsername(), req.getPassword())){
			throw new CommandParameterNotSetException();
		}
		User user = null;
			try {
				user = ((UserInputMapper)MapperRepository.getInputMapper(User.class)).find(req.getUsername(),
						req.getPassword());
				if (user == null){
					throw new UserNameOrPasswordFailedException();
				}
			String password = req.getPassword();
			
			EncryptionService.authenticate(password,
					user.getPassword(), user.getSalt());
			} catch (SQLException e) {
				res.setException(e);
				res.setSucceed(false);
				return;
			} catch (NoSuchAlgorithmException e) {
				res.setException(e);
				res.setSucceed(false);
				return;
			} catch (InvalidKeySpecException e) {
				res.setException(e);
				res.setSucceed(false);
				return;
			} catch (AuthenticationException e) {
				res.setException(e);
				res.setSucceed(false);
				return;
			} catch (UserNameOrPasswordFailedException e) {
				res.setException(e);
				res.setSucceed(false);
				return;
			}
			res.setSucceed(true);
			res.setFullName(user.getFirstName()+" "+user.getLastName());
			res.setId(user.getId());
			res.setUser(user);
		}

	public void setUsername(String username) {
		req.setUsername(username);
	}

	public void setPassword(String password) {
		req.setPassword(password);
	}

	public User getUser() {
		return res.getUser();
	}

	public String getFullName() {
		return res.getFullName();
	}

	public UUID getId() {
		return res.getId();
	}

	public boolean isSucceed(){
		return res.isSucceed();
	}
	public Exception getException(){
		return res.getException();
	}
}
