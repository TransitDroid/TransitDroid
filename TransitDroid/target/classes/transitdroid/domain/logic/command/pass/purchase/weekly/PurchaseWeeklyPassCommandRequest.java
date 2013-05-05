package transitdroid.domain.logic.command.pass.purchase.weekly;

import java.util.Date;
import java.util.UUID;

import transitdroid.domain.core.CommandRequest;

public class PurchaseWeeklyPassCommandRequest extends CommandRequest {

	private UUID mobileDeviceMAC;
	private int version;
	private Date date;

	public UUID getMobileDeviceMAC() {
		return mobileDeviceMAC;
	}

	public void setMobileDeviceMAC(UUID contractId) {
		this.mobileDeviceMAC = contractId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
