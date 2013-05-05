package transitdroid.domain.logic.command.pass.purchase.monthly;

import transitdroid.domain.core.CommandRequest;

public class PurchaseMonthlyPassCommandRequest extends CommandRequest {

	private String mobileDeviceMAC;
	private int version;
	private int month;
	private int year;

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMobileDeviceMAC() {
		return mobileDeviceMAC;
	}

	public void setMobileDeviceMAC(String mobileDeviceMAC) {
		this.mobileDeviceMAC = mobileDeviceMAC;
	}

	

}
