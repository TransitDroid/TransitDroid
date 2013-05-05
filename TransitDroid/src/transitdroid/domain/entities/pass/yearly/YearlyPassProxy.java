package transitdroid.domain.entities.pass.yearly;

import java.util.Date;
import java.util.UUID;


import transitdroid.domain.core.BaseProxy;

public class YearlyPassProxy extends BaseProxy<YearlyPass> implements IYearlyPass {

	public YearlyPassProxy(UUID id) {
		super(id, YearlyPass.class);
	}

	public int getVersion() {

		return getInnerObject().getVersion();
	}

	public void setVersion(int version) {

		getInnerObject().setVersion(version);
	}

	public Date getDate() {

		return getInnerObject().getDate();
	}

	public void setDate(Date date) {

		getInnerObject().setDate(date);
	}

	public int hashCode() {

		return getInnerObject().hashCode();
	}

	public boolean equals(Object obj) {

		return getInnerObject().equals(obj);
	}

	public String toString() {

		return getInnerObject().toString();
	}



}
