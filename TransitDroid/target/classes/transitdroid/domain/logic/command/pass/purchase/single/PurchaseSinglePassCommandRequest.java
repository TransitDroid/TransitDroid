package transitdroid.domain.logic.command.pass.purchase.single;

import transitdroid.domain.core.CommandRequest;

public class PurchaseSinglePassCommandRequest extends CommandRequest {

	private String mobilcDeviceMAC;
	private int version;
	private int quantity;

	

	public String getMobileDeviceMAC() {
		return mobilcDeviceMAC;
	}

	public void setMobileDeviceMAC(String contractId) {
		this.mobilcDeviceMAC = contractId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
