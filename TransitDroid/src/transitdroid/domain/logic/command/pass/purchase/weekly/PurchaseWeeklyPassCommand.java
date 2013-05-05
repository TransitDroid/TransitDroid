package transitdroid.domain.logic.command.pass.purchase.weekly;

import transitdroid.domain.logic.command.ICommand;

public class PurchaseWeeklyPassCommand implements ICommand {
	
	/*private PurchaseWeeklyPassCommandRequest req = new PurchaseWeeklyPassCommandRequest();
	private PurchaseWeeklyPassCommandResponse res = new PurchaseWeeklyPassCommandResponse();*/

	
	
	@Override
	public void execute() {
		
		
//		if (!Guard.notNull(req.getContractId(), req.getVersion(), req.getDate())) {
//			throw new CommandParameterNotSetException();
//		}
//
//		ContractInputMapper cim = new ContractInputMapper();
//		Contract contract = cim.find(req.getContractId());
//
//		WeeklyPass pass = contract.getCard().getWeeklyPass();
//		pass.setDate(req.getDate());
//		pass.setVersion(req.getVersion());
//		UnitOfWork.getInstance().RegisterDirty(pass);
//		try {
//			try {
//				UnitOfWork.getInstance().commit();
//			} catch (CommitUnitOfWorkException e) {
//				res.setException(e);
//				res.setSucceed(false);
//				return;
//			}
//		} catch (LostUpdateException e) {
//			res.setException(e);
//			res.setSucceed(false);
//			return;
//
//		} catch (MapperException e) {
//			res.setException(e);
//			res.setSucceed(false);
//			return;
//		}
//		res.setSucceed(true);
//		
	}

}
