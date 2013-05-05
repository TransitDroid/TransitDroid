package transitdroid.domain.logic.command.user.create;

import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.xml.ws.RespectBinding;

import transitdroid.data.LostUpdateException;
import transitdroid.domain.core.Guard;
import transitdroid.domain.core.MapperRepository;
import transitdroid.domain.core.UnitOfWork;
import transitdroid.domain.core.exceptions.CommitUnitOfWorkException;
import transitdroid.domain.core.exceptions.MapperException;
import transitdroid.domain.entities.user.User;
import transitdroid.domain.entities.user.UserFactory;
import transitdroid.domain.entities.user.UserOutputMapper;
import transitdroid.domain.entities.user.UserRole;
import transitdroid.domain.logic.command.CommandException;
import transitdroid.domain.logic.command.CommandParameterNotSetException;
import transitdroid.domain.logic.command.ICommand;
import transitdroid.domain.logic.technical.EncryptionService;



@SuppressWarnings("unused")
public class CreateUserCommand implements ICommand {

	private CreateUserCommandRequest req;
	private CreateUserCommandResponse res;
	
	public CreateUserCommand(){
		this.req = new CreateUserCommandRequest();
		this.res = new CreateUserCommandResponse();
	}
	
	@Override
	public void execute() {
		if (!Guard.notNull(req.getFirstName(), req.getLastName(), req.getPassword(), req.getUsername())){
			throw new CommandParameterNotSetException(req.toString());
		}
		User user = null;		
		try {
			byte[] salt = EncryptionService.generateSalt();
			byte[] password = EncryptionService.encryptPassword(req.getPassword().toString(), salt);
			
			user = UserFactory.createNew(null, req.getFirstName(), 
					req.getLastName(),
					req.getUsername(),
					password, salt);
//			((UserOutputMapper)MapperRepository.getOutputMapper(User.class)).insert(user);
			UnitOfWork.getInstance().commit();

		} catch (URISyntaxException e) {
			res.setResponseException(new CommandException(e));
			res.setSucceed(false);
			return;
		} catch (NoSuchAlgorithmException e) {
			res.setResponseException(new CommandException(e));
			res.setSucceed(false);
			return;
		} catch (InvalidKeySpecException e) {
			res.setResponseException(new CommandException(e));
			res.setSucceed(false);
			return;
		} catch (LostUpdateException e) {
			res.setResponseException(new CommandException(e));
			res.setSucceed(false);
		} catch (MapperException e) {
			res.setResponseException(new CommandException(e));
			res.setSucceed(false);
		} catch (CommitUnitOfWorkException e) {
			res.setResponseException(new CommandException(e));
			res.setSucceed(false);
		} catch (SQLException e) {
			res.setResponseException(new CommandException(e));
			res.setSucceed(false);
		}

		res.setSucceed(true);
		res.setUser(user);

	}
	/**
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		req.setUsername(username);
	}
	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		req.setPassword(password);
	}
	/**
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		req.setFirstName(firstName);
	}
	/**
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		req.setLastName(lastName);
	}
	/**
	 * 
	 * @return
	 */
	public User getUser() {
		return res.getUser();
	}
	public Exception getException(){
		return res.getResponseException();
	}
	/**
	 * 
	 * @return
	 */
	public boolean isSucceed(){
		return res.isSucceed();
	}

}
