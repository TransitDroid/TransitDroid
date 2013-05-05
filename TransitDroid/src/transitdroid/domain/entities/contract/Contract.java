package transitdroid.domain.entities.contract;

import java.util.List;
import java.util.UUID;

import transitdroid.domain.core.DomainObject;
import transitdroid.domain.entities.card.ICard;
import transitdroid.domain.entities.mobiledevice.IMobileDevice;
import transitdroid.domain.entities.mobiledevice.MobileDevice;
import transitdroid.domain.entities.user.IUser;
import transitdroid.domain.entities.user.User;
/**
 * 
 * @author TransitDroid Team
 * @class Contract
 *  Contract is a domain entity that extends DomainObject and implements IContract
 *
 * Contract is the domain entity that holds all information about a user and a transaction together.
 * It contains a byte list of keys for identification and authentication of users. It also contains
 * a phone, card and user interfaces. This domain entity is considered to be the core that connects
 * all domain entities together.
 */
public class Contract extends DomainObject implements IContract{


	private List<byte[]> keys;
	private IMobileDevice phone;
	private ICard card;
	private IUser user;
	private byte[] salt;
	/**
	 * 
	 * @param id Contract UUID
	 * @param version Contract Version Number (int)
	 * @param keys Authentication keys (List<byte[]>)
	 * @param phone MobileDevice info, containing phoneMAC (IMobileDevice)
	 * @param card (ICard)
	 */
	public Contract(UUID id, int version, List<byte[]> keys, IMobileDevice phone, ICard card, IUser user, byte[] salt){
		super(id, version);
		this.keys = keys;
		this.phone = phone;
		this.card = card;
		this.user = user;
		this.salt = salt;
	}
	public Contract(UUID id, int version, MobileDevice md, ICard card2, User user2) {
		super(id, version);
		this.phone = md;
		this.card = card2;
		this.user = user2;
	}
	/**
	 *  get the authentication keys
	 * @return List<byte[]> 
	 */
	public List<byte[]> getKeys() {
		return keys;
	}
	/**
	 *  sets the authentication keys
	 * @param keys
	 */
	public void setKeys(List<byte[]> keys) {
		this.keys = keys;
	}
	/**
	 *  get the inner IMobileDevice object
	 * @return IMobileDevice
	 */
	public IMobileDevice getMobileDevice() {
		return phone;
	}
	/**
	 *  set the IMobileDevice inner object
	 * @param phone
	 */
	public void setMobileDevice(IMobileDevice phone) {
		this.phone = phone;
	}
	/**
	 *  get the inner ICard object
	 * @return ICard
	 */
	public ICard getCard() {
		return card;
	}
	/**
	 *  set the inner ICard object
	 * @param card
	 */
	public void setCard(ICard card) {
		this.card = card;
	}
	/**
	 *  get the inner IUser object
	 * @return IUser
	 */
	public IUser getUser() {
		return user;
	}
	/**
	 *  set the inner IUser object
	 * @param user
	 */
	public void setUser(IUser user) {
		this.user = user;
	}
	public byte[] getSalt() {
		return salt;
	}
	public void setSalt(byte[] salt) {
		this.salt = salt;
	}
	
}
