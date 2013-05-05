package transitdroid.domain.logic.command.pass.purchase.monthly;

import java.sql.SQLException;

import transitdroid.data.LostUpdateException;
import transitdroid.domain.core.Guard;
import transitdroid.domain.core.UnitOfWork;
import transitdroid.domain.core.exceptions.CommitUnitOfWorkException;
import transitdroid.domain.core.exceptions.MapperException;
import transitdroid.domain.entities.contract.Contract;
import transitdroid.domain.entities.contract.ContractInputMapper;
import transitdroid.domain.entities.pass.monthly.IMonthlyPass;
import transitdroid.domain.logic.command.CommandParameterNotSetException;
import transitdroid.domain.logic.command.ICommand;

public class PurchaseMonthlyPassCommand implements ICommand {

	private PurchaseMonthlyPassCommandRequest req = new PurchaseMonthlyPassCommandRequest();
	private PurchaseMonthlyPassCommandResponse res = new PurchaseMonthlyPassCommandResponse();

	@SuppressWarnings("unchecked")
	@Override
	public void execute() {

		if (!Guard.notNull(req.getMobileDeviceMAC(), req.getVersion(),
				req.getMonth(), req.getMonth())) {
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

		IMonthlyPass pass = contract.getCard().getMonthlyPass();

		pass.setMonth(req.getMonth());
		pass.setYear(req.getYear());
		pass.setVersion(req.getVersion());

		UnitOfWork.getInstance().RegisterDirty(pass);
		try {
			try {
				UnitOfWork.getInstance().commit();
			} catch (CommitUnitOfWorkException e) {
				res.setException(e);
				res.setSucceed(false);
				return;
			} catch (SQLException e) {
				res.setException(e);
				res.setSucceed(false);
				return;
			}
		} catch (LostUpdateException e) {
			res.setException(e);
			res.setSucceed(false);
			return;

		} catch (MapperException e) {
			res.setException(e);
			res.setSucceed(false);
			return;
		}
		res.setSucceed(true);

	}

	public void setMobileDeviceMAC(String mobileDeviceMAC) {
		req.setMobileDeviceMAC(mobileDeviceMAC);
	}

	public int getVersion() {
		return req.getVersion();
	}

	public void setVersion(int version) {
		req.setVersion(version);
	}

	public void setYear(int year) {
		req.setYear(year);
	}

	public void setMonth(int month) {
		req.setMonth(month);
	}

	public boolean isSucceed() {
		return res.isSucceed();
	}

	public Exception getException() {
		return res.getException();
	}

}
