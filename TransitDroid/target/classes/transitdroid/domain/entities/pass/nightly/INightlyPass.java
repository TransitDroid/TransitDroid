package transitdroid.domain.entities.pass.nightly;

import java.util.Date;

import transitdroid.domain.core.IDomainObject;

public interface INightlyPass extends IDomainObject {


	public Date getDate();

	public void setDate(Date date);
}
