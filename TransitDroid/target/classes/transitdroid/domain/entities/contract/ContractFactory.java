package transitdroid.domain.entities.contract;

import java.util.List;
import java.util.UUID;

import transitdroid.domain.core.IdentityMapRepository;
import transitdroid.domain.core.UnitOfWork;
import transitdroid.domain.entities.card.ICard;
import transitdroid.domain.entities.mobiledevice.IMobileDevice;
import transitdroid.domain.entities.mobiledevice.MobileDevice;
import transitdroid.domain.entities.user.IUser;
/**
 * 
 * @author TransitDroid Team
 * @class ContractFactory
 *  This class is a Factory Class of the domain entity Contract. It manages creation of new
 *        in-memory Contract objects. The Factory Class makes the appropriate calls to the UOW. 
 */
public class ContractFactory {

	/**
	 *  Creates a new Contract object with the specified parameters passed. No UUID passed.
	 * @param keys
	 * @param phoneId
	 * @param card
	 * @return Contract
	 */
	public static Contract createNew(List<byte[]> keys,  IMobileDevice phoneId, ICard card, IUser user, byte[] salt){
		
		UUID id = UUID.randomUUID();

		return createNew(id, keys, phoneId, card, user, salt);
	}
	/**
	 *  Creates a new Contract object with the specified parameters passed. With UUID.
	 * @param id
	 * @param keys
	 * @param phoneId
	 * @param card
	 * @return Contract
	 */
	@SuppressWarnings("unchecked")
	public static Contract createNew(UUID id, List<byte[]> keys, IMobileDevice phoneId, ICard card, IUser user, byte[] salt){
		Contract contract = new Contract(id, 1, keys, phoneId, card, user, salt);
		UnitOfWork.getInstance().RegisterNew(contract);
		IdentityMapRepository.getIdentityMap(Contract.class).put(contract);
		return contract;
	}
	/**
	 * 
	 * @param id
	 * @param keys
	 * @param phoneId
	 * @param card
	 * @param user
	 * @param salt
	 * @return
	 */
	public static Contract createClean(UUID id, List<byte[]> keys, IMobileDevice phoneId, ICard card, IUser user, byte[] salt){
		Contract contract = new Contract(id, 1, keys, phoneId, card, user, salt);
		IdentityMapRepository.getIdentityMap(Contract.class).put(contract);
		return contract;
	}
	@SuppressWarnings("unchecked")
	public static IContract createNew(MobileDevice md, ICard card,
			transitdroid.domain.entities.user.User user) {
		UUID id = UUID.randomUUID();
		Contract contract = new Contract(id, 1, md, card, user);
		UnitOfWork.getInstance().RegisterNew(contract);
		IdentityMapRepository.getIdentityMap(Contract.class).put(contract);
		return contract;
	}
}
