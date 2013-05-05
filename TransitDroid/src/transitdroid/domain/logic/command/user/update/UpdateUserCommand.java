package transitdroid.domain.logic.command.user.update;

import java.sql.SQLException;
import java.util.List;

import transitdroid.data.LostUpdateException;
import transitdroid.domain.core.Guard;
import transitdroid.domain.core.UnitOfWork;
import transitdroid.domain.core.exceptions.CommitUnitOfWorkException;
import transitdroid.domain.core.exceptions.MapperException;
import transitdroid.domain.entities.user.User;
import transitdroid.domain.entities.user.UserFactory;
import transitdroid.domain.entities.user.UserRole;
import transitdroid.domain.logic.command.CommandParameterNotSetException;
import transitdroid.domain.logic.command.ICommand;

public class UpdateUserCommand implements ICommand {
	
	UpdateUserCommandRequest request = new UpdateUserCommandRequest();
	UpdateUserCommandResponse response = new UpdateUserCommandResponse();
	@SuppressWarnings("unchecked")
	@Override
	public void execute() {
		if (!Guard.notNull(request.getFirstName(), request.getId(), request.getLastName(),
				request.getPassword(), request.getRoles(), request.getSalt(),
				request.getUsername(), request.getVersion())){
			response.setException(new CommandParameterNotSetException(request.toString()));
			response.setSucceed(false);
			return;
		}
		User user = UserFactory.createClean(request.getId(), request.getVersion(), request.getRoles(), request.getFirstName(),
				request.getLastName(), request.getUsername(), request.getPassword(), request.getSalt());
		UnitOfWork.getInstance().RegisterDirty(user);
		try {
			UnitOfWork.getInstance().commit();
		} catch (LostUpdateException e) {
			response.setException(e);
			response.setSucceed(false);
			return;
		} catch (MapperException e) {
			response.setException(e);
			response.setSucceed(false);
			return;
		} catch (CommitUnitOfWorkException e) {
			e.appendMessage("Most Likely you have passed the wrong version of the object to update" + e.getStackTrace().toString());
			response.setException(e);
			response.setSucceed(false);
			return;
		} catch (SQLException e) {
			response.setException(e);
			response.setSucceed(false);
			return;
		}
		response.setSucceed(true);
	}
	public void setId(String id){
		request.setId(id);
	}
	public void setRoles(List<UserRole> roles) {
		request.setRoles(roles);
	}
	public void setFirstName(String firstName) {
		request.setFirstName(firstName);
	}
	public void setLastName(String lastName) {
		request.setLastName(lastName);
	}
	public void setUsername(String username) {
		request.setUsername(username);
	}
	public void setPassword(byte[] password) {
		request.setPassword(password);
	}
	public void setSalt(byte[] salt) {
		request.setSalt(salt);
	}
	public void setVersion(int version){
		request.setVersion(version);
	}
	public Exception getException(){
		return response.getException();
	}
	public boolean isSucceed() {
		return response.isSucceed();
	}
}
