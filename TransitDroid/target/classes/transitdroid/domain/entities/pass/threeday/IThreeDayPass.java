package transitdroid.domain.entities.pass.threeday;

import java.util.Date;

import transitdroid.domain.core.IDomainObject;

public interface IThreeDayPass extends IDomainObject {

	public void setVersion(int version);
	public int getVersion();
	public Date getDate();
	public void setDate(Date date);
}
