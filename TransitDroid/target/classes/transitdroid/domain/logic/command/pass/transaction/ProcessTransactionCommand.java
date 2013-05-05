package transitdroid.domain.logic.command.pass.transaction;

import java.sql.SQLException;
import java.util.List;

import transitdroid.domain.entities.contract.Contract;
import transitdroid.domain.entities.contract.ContractInputMapper;
import transitdroid.domain.entities.enums.TransactionResponseCode;
import transitdroid.domain.logic.command.ICommand;
import transitdroid.domain.logic.command.encryption.keys.GenerateKeysCommand;
import transitdroid.domain.logic.command.pass.validate.ValidatePassCommand;
import transitdroid.domain.logic.technical.EncryptionService;
import transitdroid.domain.logic.technical.exceptions.EncryptionException;

public class ProcessTransactionCommand implements ICommand{
	private ProcessTransactionRequest request = new ProcessTransactionRequest();
	private ProcessTransactionResponse response = new ProcessTransactionResponse();
	
	@Override
	public void execute() {
		try {
			ContractInputMapper mapper = new ContractInputMapper();
			Contract contract= mapper.findByMobileDevice(request.getPhoneMac());
			if (EncryptionService.authenticate(this.request.getKeys(), contract.getKeys(), this.request.getPasscode())){
				ValidatePassCommand vpc = new ValidatePassCommand(contract.getCard());
				vpc.execute();
				if (vpc.isSuccess()){
					GenerateKeysCommand keys = new GenerateKeysCommand();
					keys.execute();
					contract.setKeys(keys.getOriginals());
					contract.setSalt(keys.getSalt());
					response.setKeys(keys.getEncrypted());
					response.setPasscode(keys.getSaltString());
					
					response.setCode(TransactionResponseCode.SUCCESS);
					return;
				}
			}
		} catch (SQLException e) {
			response.setException(e);
			response.setCode(TransactionResponseCode.FAILED);
			return;
		} catch (EncryptionException e) {
			response.setException(e);
			response.setCode(TransactionResponseCode.FAILED);
			return;
		}
		response.setCode(TransactionResponseCode.FAILED);
	}
//	private List<String> encryptKeys(Contract contract) throws NoSuchAlgorithmException, EncryptionException {
//		contract.setSalt(EncryptionService.generateSalt());
//		return EncryptionService.encryptListOfBytes(contract.getKeys(), contract.getSalt());
//	}
//	//Helper Methods
//	private List<byte[]> getNewKeys() throws NoSuchAlgorithmException{
//		List<byte[]> keys = new ArrayList<byte[]>();
//		keys.add(EncryptionService.generateSalt());
//		keys.add(EncryptionService.generateSalt());
//		keys.add(EncryptionService.generateSalt());
//		keys.add(EncryptionService.generateSalt());
//		return keys;
//	}
	
	
	//Set Request
	public void setRequestPasscode(String passcode){
		this.request.setPasscode(passcode);
	}
	public void setRequestKeys(List<String> keys){
		this.request.setKeys(keys);
	}
	public void SetPhoneMac(String phone){
		this.request.setPhoneMac(phone);
	}
	//Get Response
	public String getResponseKey(int index){
		return response.getKeys().get(index);
	}
	public List<String> getResponseKeys(){
		return response.getKeys();
	}
	public String getResponseCode(){
		return response.getCode().toString();
	}
	public String getResponsePasscode(){
		return response.getPasscode();
	}
	public Exception getException(){
		return response.getException();
	}
}
