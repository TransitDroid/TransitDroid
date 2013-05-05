package transitdroid.domain.entities.pass.threeday;

import java.util.Date;
import java.util.UUID;


import transitdroid.domain.core.BaseProxy;

public class ThreeDayPassProxy extends BaseProxy<ThreeDayPass> implements IThreeDayPass {

	public ThreeDayPassProxy(UUID id) {
		super(id, ThreeDayPass.class);
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

	public int getVersion() {

		return getInnerObject().getVersion();
	}

	public void setVersion(int version) {

		getInnerObject().setVersion(version);
	}


}
