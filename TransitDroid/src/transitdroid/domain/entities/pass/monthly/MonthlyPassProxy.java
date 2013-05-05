package transitdroid.domain.entities.pass.monthly;

import java.util.UUID;

import transitdroid.domain.core.BaseProxy;

public class MonthlyPassProxy extends BaseProxy<MonthlyPass> implements IMonthlyPass {

	public MonthlyPassProxy(UUID id) {
		super(id, MonthlyPass.class);
	}

	public int getVersion() {
		return getInnerObject().getVersion();
	}

	public void setVersion(int version) {
		getInnerObject().setVersion(version);
	}

	public int getMonth() {
		return getInnerObject().getMonth();
	}

	public void setMonth(int month) {
		getInnerObject().setMonth(month);
	}

	public int getYear() {
		return getInnerObject().getYear();
	}

	public void setYear(int year) {
		getInnerObject().setYear(year);
	}

	public int hashCode() {
		return getInnerObject().hashCode();
	}

	public boolean equals(Object obj) {
		return getInnerObject().equals(obj);
	}

	@Override
	public String toString() {
		return getInnerObject().toString();
	}

}
