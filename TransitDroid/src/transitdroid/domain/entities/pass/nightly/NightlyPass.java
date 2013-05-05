package transitdroid.domain.entities.pass.nightly;

import java.util.Date;
import java.util.UUID;
import transitdroid.domain.core.DomainObject;


public class NightlyPass extends DomainObject implements INightlyPass {
	
	private Date date;
	
	public NightlyPass(UUID id, int version, Date date) {
		super(id, version);
		this.date = date;
	}

	public NightlyPass() {
	}

	public NightlyPass(UUID id, int version) {
		super(id, version);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
