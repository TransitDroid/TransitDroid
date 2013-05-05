package transitdroid.domain.entities.pass.daily;

import java.util.Date;
import java.util.UUID;


import transitdroid.domain.core.BaseProxy;
import transitdroid.domain.core.exceptions.ProxyException;

public class DailyPassProxy extends BaseProxy<DailyPass> implements IDailyPass {

	public DailyPassProxy(UUID id) {
		super(id, DailyPass.class);
	}

	public int getVersion() {
		int version = 0;
		try {
			version = getInnerObject().getVersion();
		} catch (ProxyException e) {
			e.printStackTrace();
		}
		return version;
	}

	public void setVersion(int version) throws ProxyException {
		getInnerObject().setVersion(version);
	}

	public Date getDate() throws ProxyException {
		return getInnerObject().getDate();
	}

	public void setDate(Date date) throws ProxyException {
		getInnerObject().setDate(date);
	}

	public int hashCode() {
		int hash = 0;
		try {
			hash = getInnerObject().hashCode();
		} catch (ProxyException e) {
			e.printStackTrace();
		}
		return hash;
	}

	public boolean equals(Object obj) {
		boolean result = false;
		try {
			result = getInnerObject().equals(obj);
		} catch (ProxyException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String toString() {
		String result = null;
		try {
			result = getInnerObject().toString();
		} catch (ProxyException e) {
			e.printStackTrace();
		}
		return result;
	}


}
