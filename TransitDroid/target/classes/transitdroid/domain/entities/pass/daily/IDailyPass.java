package transitdroid.domain.entities.pass.daily;

import java.util.Date;

import transitdroid.domain.core.IDomainObject;
import transitdroid.domain.core.exceptions.ProxyException;

public interface IDailyPass extends IDomainObject {

	public int getVersion();

	public void setVersion(int version) throws ProxyException;

	public Date getDate() throws ProxyException;

	public void setDate(Date date) throws ProxyException;

	public int hashCode();

	public boolean equals(Object obj);

	@Override
	public String toString();
}
