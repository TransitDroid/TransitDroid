package transitdroid.domain.logic.command.pass.purchase.threeday;

import java.sql.SQLException;
import java.util.Date;

import transitdroid.data.LostUpdateException;
import transitdroid.domain.core.Guard;
import transitdroid.domain.core.UnitOfWork;
import transitdroid.domain.core.exceptions.CommitUnitOfWorkException;
import transitdroid.domain.core.exceptions.MapperException;
import transitdroid.domain.entities.contract.Contract;
import transitdroid.domain.entities.contract.ContractInputMapper;
import transitdroid.domain.entities.pass.threeday.IThreeDayPass;
import transitdroid.domain.logic.command.CommandParameterNotSetException;
import transitdroid.domain.logic.command.ICommand;

public class PurchaseThreeDayPassCommand implements ICommand {

	private PurchaseThreeDayPassCommandRequest req = new PurchaseThreeDayPassCommandRequest();
	private PurchaseThreeDayPassCommandResponse res = new PurchaseThreeDayPassCommandResponse();

	@SuppressWarnings("unchecked")
	@Override
	public void execute() {

		if (!Guard
				.notNull(req.getMobileDeviceMAC(), req.getVersion(), req.getDate())) {
			throw new CommandParameterNotSetException();
		}

		ContractInputMapper cim = new ContractInputMapper();
		Contract contract;
		try {
			contract = cim.findByMobileDevice(req.getMobileDeviceMAC());
		} catch (SQLException e1) {
			res.setException(e1);
			res.setSucceed(false);
			return;
		}

		IThreeDayPass pass = contract.getCard().getThreeDayPass();
		pass.setDate(req.getDate());
		pass.setVersion(req.getVersion());

		UnitOfWork.getInstance().RegisterDirty(pass);
		try {
			UnitOfWork.getInstance().commit();

		} catch (LostUpdateException e) {
			res.setException(e);
			res.setSucceed(false);
			return;

		} catch (MapperException e) {
			res.setException(e);
			res.setSucceed(false);
			return;
		} catch (CommitUnitOfWorkException e) {
			res.setException(e);
			res.setSucceed(false);
			return;
		} catch (SQLException e) {
			res.setException(e);
			res.setSucceed(false);
			return;
		}
		res.setSucceed(true);

	}

	public void setMobileDeviceMAC(String mac) {
		req.setMobileDeviceMAC(mac);
	}

	public void setVersion(int version) {
		req.setVersion(version);
	}

	public void setDate(Date date) {
		req.setDate(date);
	}

	public boolean isSucceed() {
		return res.isSucceed();
	}

	public Exception getException() {
		return res.getException();
	}

}
