package transitdroid.domain.logic.command.pass.purchase.single;

import java.sql.SQLException;

import transitdroid.data.LostUpdateException;
import transitdroid.domain.core.Guard;
import transitdroid.domain.core.UnitOfWork;
import transitdroid.domain.core.exceptions.CommitUnitOfWorkException;
import transitdroid.domain.core.exceptions.MapperException;
import transitdroid.domain.entities.contract.Contract;
import transitdroid.domain.entities.contract.ContractInputMapper;
import transitdroid.domain.entities.pass.single.ISinglePass;
import transitdroid.domain.logic.command.CommandParameterNotSetException;
import transitdroid.domain.logic.command.ICommand;

public class PurchaseSinglePassCommand implements ICommand {

	private PurchaseSinglePassCommandRequest req = new PurchaseSinglePassCommandRequest();
	private PurchaseSinglePassCommandResponse res = new PurchaseSinglePassCommandResponse();

	@SuppressWarnings("unchecked")
	@Override
	public void execute() {
		if (!Guard.notNull(req.getMobileDeviceMAC(), req.getVersion(),
				req.getQuantity())) {
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

		ISinglePass pass = contract.getCard().getSinglePass();

		pass.setQuantity(req.getQuantity());
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

	public void setMobileDeviceMAC(String mac) {
		req.setMobileDeviceMAC(mac);
	}

	public void setVersion(int version) {
		req.setVersion(version);
	}

	public void setQuantity(int quantity) {
		req.setQuantity(quantity);
	}

	public boolean isSucceed() {
		return res.isSucceed();
	}

	public Exception getException() {
		return res.getException();
	}

}
