package transitdroid.domain.logic.command.mobiledevice.register;

import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import transitdroid.data.LostUpdateException;
import transitdroid.domain.core.UnitOfWork;
import transitdroid.domain.core.exceptions.CommitUnitOfWorkException;
import transitdroid.domain.core.exceptions.MapperException;
import transitdroid.domain.entities.card.CardFactory;
import transitdroid.domain.entities.card.ICard;
import transitdroid.domain.entities.contract.Contract;
import transitdroid.domain.entities.contract.ContractFactory;
import transitdroid.domain.entities.contract.ContractInputMapper;
import transitdroid.domain.entities.contract.IContract;
import transitdroid.domain.entities.mobiledevice.MobileDeviceFactory;
import transitdroid.domain.entities.pass.daily.DailyPass;
import transitdroid.domain.entities.pass.daily.DailyPassFactory;
import transitdroid.domain.entities.pass.monthly.MonthlyPass;
import transitdroid.domain.entities.pass.monthly.MonthlyPassFactory;
import transitdroid.domain.entities.pass.nightly.NightlyPass;
import transitdroid.domain.entities.pass.nightly.NightlyPassFactory;
import transitdroid.domain.entities.pass.single.SinglePass;
import transitdroid.domain.entities.pass.single.SinglePassFactory;
import transitdroid.domain.entities.pass.threeday.ThreeDayPass;
import transitdroid.domain.entities.pass.threeday.ThreeDayPassFactory;
import transitdroid.domain.entities.pass.yearly.YearlyPass;
import transitdroid.domain.entities.pass.yearly.YearlyPassFactory;
import transitdroid.domain.logic.command.ICommand;
import transitdroid.domain.logic.command.encryption.keys.GenerateKeysCommand;
import transitdroid.domain.logic.command.user.login.UserLoginCommand;
import transitdroid.domain.logic.technical.EncryptionService;
import transitdroid.domain.logic.technical.exceptions.EncryptionException;
import transitdroid.domain.entities.user.User;

public class RegisterDeviceCommand implements ICommand {
	RegisterDeviceCommandRequest request = new RegisterDeviceCommandRequest();
	RegisterDeviceCommandResponse response = new RegisterDeviceCommandResponse();

	public RegisterDeviceCommand() {
	}

	public RegisterDeviceCommand(String MobileDeviceMAC, String username,
			String password) {
		request.setPhoneId(MobileDeviceMAC);
		request.setUsername(username);
		request.setPassword(password);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute() {
		IContract contract = null;
		ContractInputMapper contractInputMapper = new ContractInputMapper();

		UserLoginCommand login = new UserLoginCommand();
		login.setPassword(request.getPassword());
		login.setUsername(request.getUsername());
		login.execute();

		// if not the correct username or password (FAILED)
		if (!login.isSucceed()) {
			response.setSucceed(false);
			return;
		} else {
			response.setUser(login.getUser());
		}
		try {
			contract = contractInputMapper.findByMobileDevice(request.getPhoneId());
			if (contract != null) {
				// If the contract already exists for this user we just need to
				// return the details
				if (contract.getUser().getId().compareTo(login.getUser().getId()) == 0) {
					response.setSucceed(true);
					response.setKeys(EncryptionService.encryptListOfBytes(contract.getKeys(), contract.getSalt()));
					response.setSalt(EncryptionService.encode(contract.getSalt()));
					return;
				}
				// If the contract is set for another person we need to clear
				// the device on that contract
				contract.setMobileDevice(MobileDeviceFactory.createEmpty());
				
				UnitOfWork.getInstance().RegisterDirty((Contract) contract);
			}

			// Create New Contract
			contract = ContractFactory.createNew(
					MobileDeviceFactory.createNew(request.getPhoneId()),
					generateNewCard(),
					login.getUser());
			GenerateKeysCommand newKeys = new GenerateKeysCommand();
			newKeys.execute();
			contract.setKeys(newKeys.getOriginals());
			contract.setSalt(newKeys.getSalt());
			// finish unit of work
			UnitOfWork.getInstance().commit();

			response.setKeys(newKeys.getEncrypted());
			response.setSalt(newKeys.getSaltString());
			response.setSucceed(true);
			
		} catch (URISyntaxException e) {
			response.setException(e);
			response.setSucceed(false);
		} catch (NoSuchAlgorithmException e) {
			response.setException(e);
			response.setSucceed(false);
		} catch (LostUpdateException e) {
			response.setException(e);
			response.setSucceed(false);
		} catch (MapperException e) {
			response.setException(e);
			response.setSucceed(false);
		} catch (CommitUnitOfWorkException e) {
			response.setException(e);
			response.setSucceed(false);
		} catch (SQLException e) {
			response.setException(e);
			response.setSucceed(false);
		} catch (EncryptionException e) {
			response.setException(e);
			response.setSucceed(false);
		}
	}

	// helper Methods
	private ICard generateNewCard() throws URISyntaxException,
			NoSuchAlgorithmException {
		MonthlyPass monthlyPass = MonthlyPassFactory.createNew();
		NightlyPass nightlyPass = NightlyPassFactory.createNew();
		DailyPass dailyPass = DailyPassFactory.createNew();
		SinglePass singlePass = SinglePassFactory.createNew();
		ThreeDayPass threeDayPass = ThreeDayPassFactory.createNew();
		YearlyPass yearlyPass = YearlyPassFactory.createNew();

		return CardFactory.createNew(monthlyPass, nightlyPass, dailyPass,
				singlePass, threeDayPass, yearlyPass);
	}
//
//	private List<String> encryptKeys(List<byte[]> keys, byte[] salt)
//			throws NoSuchAlgorithmException, EncryptionException {
//		return EncryptionService.encryptListOfBytes(keys,
//				salt);
//	}
//
//	// Helper Methods
//	private List<byte[]> getNewKeys() throws NoSuchAlgorithmException {
//		List<byte[]> keys = new ArrayList<byte[]>();
//		keys.add(EncryptionService.generateSalt());
//		keys.add(EncryptionService.generateSalt());
//		keys.add(EncryptionService.generateSalt());
//		keys.add(EncryptionService.generateSalt());
//		return keys;
//	}

	public void setPhoneId(String phoneId) {
		request.setPhoneId(phoneId);
	}

	public boolean isSucceed() {
		return response.isSucceed();
	}

	public List<String> getKeys() {
		return response.getKeys();
	}

	public String getSalt() {
		return response.getSalt();
	}

	public User getUser() {
		return response.getUser();
	}

	public Exception getException() {
		return response.getException();
	}
}
