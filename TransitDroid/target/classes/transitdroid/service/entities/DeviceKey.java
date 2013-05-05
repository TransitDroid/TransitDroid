package transitdroid.service.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DeviceKey {
	private byte[] key;
	
	public DeviceKey(){}
	@XmlElement
	public byte[] getKey() {
		return key;
	}

	public void setKey(byte[] key) {
		this.key = key;
	}
	
}
