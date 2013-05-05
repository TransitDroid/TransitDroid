package transitdroid.domain.entities.contract;

import java.util.List;

import transitdroid.domain.entities.card.ICard;
import transitdroid.domain.entities.mobiledevice.IMobileDevice;
import transitdroid.domain.entities.user.IUser;

public interface IContract {

	public List<byte[]> getKeys();
	public void setKeys(List<byte[]> keys);
	public IMobileDevice getMobileDevice();
	public void setMobileDevice(IMobileDevice mobileDevice);
	public ICard getCard();
	public void setCard(ICard card);
	public void setSalt(byte[] salt);
	public byte[] getSalt();
	public IUser getUser();
	public void setUser(IUser user);
}
