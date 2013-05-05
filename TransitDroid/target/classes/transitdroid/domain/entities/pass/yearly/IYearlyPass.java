package transitdroid.domain.entities.pass.yearly;

import java.util.Date;

import transitdroid.domain.core.IDomainObject;

public interface IYearlyPass extends IDomainObject {

	public Date getDate();
	public void setDate(Date date);
}
