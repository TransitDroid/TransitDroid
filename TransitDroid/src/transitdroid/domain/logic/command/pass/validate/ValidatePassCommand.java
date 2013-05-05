package transitdroid.domain.logic.command.pass.validate;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import transitdroid.domain.core.MapperRepository;
import transitdroid.domain.entities.card.ICard;
import transitdroid.domain.entities.contract.Contract;
import transitdroid.domain.entities.contract.ContractInputMapper;
import transitdroid.domain.logic.command.ICommand;
import transitdroid.domain.logic.technical.EncryptionService;
import transitdroid.domain.logic.technical.exceptions.EncryptionException;

public class ValidatePassCommand implements ICommand {

	private ValidatePassCommandRequest req = new ValidatePassCommandRequest();
	private ValidatePassCommandResponse res = new ValidatePassCommandResponse();
	
	public ValidatePassCommand(){}
	public ValidatePassCommand(ICard card){
		this.req.setCard(card);
	}
	@Override
	public void execute() {
		this.res.setSuccess(true);
	}

	@SuppressWarnings("unused")
	private static boolean validate(List<byte[]> phoneKeys, String phoneMac,
			byte[] salt) throws SQLException, EncryptionException {
		//get the contract and retrieve keys
		Contract contract = ((ContractInputMapper) MapperRepository
				.getInputMapper(Contract.class)).findByMobileDevice(phoneMac);
		
		List<byte[]> contractKeys = contract.getKeys();
		
		if (contractKeys.size() != phoneKeys.size())
			return false;
		
		return authenticate(contractKeys, phoneKeys, salt);
	}
	
	private static boolean authenticate(List<byte[]> keysFromContract,List<byte[]> keysFromPhone, byte[] salt) throws EncryptionException{
		Iterator<byte[]> phoneKeysIt = keysFromPhone.iterator();
		Iterator<byte[]> contractKeysIt = keysFromContract.iterator();

		while (phoneKeysIt.hasNext()) {
			byte[] key = EncryptionService.decrypt(phoneKeysIt.next(), salt);
			if (key != contractKeysIt.next()) {
				return false;
			}
		}
		return true;
	}
	public void setCard(ICard card){
		this.req.setCard(card);
	}

	public boolean isSuccess() {
		return res.isSuccess();
	}
	
}
