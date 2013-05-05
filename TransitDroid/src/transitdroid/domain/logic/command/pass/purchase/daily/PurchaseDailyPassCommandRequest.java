package transitdroid.domain.logic.command.pass.purchase.daily;

import java.util.Date;

import transitdroid.domain.core.CommandRequest;


public class PurchaseDailyPassCommandRequest extends CommandRequest {

	private String mobileDeviceMAC;
	private int version;
	private Date date;


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

	public String getMobileDeviceMAC() {
		return mobileDeviceMAC;
	}

	public void setMobileDeviceMAC(String mobileDeviceMAC) {
		this.mobileDeviceMAC = mobileDeviceMAC;
	}

}
