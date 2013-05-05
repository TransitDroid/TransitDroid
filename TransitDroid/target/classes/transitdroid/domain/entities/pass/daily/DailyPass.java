package transitdroid.domain.entities.pass.daily;

import java.util.Date;
import java.util.UUID;


import transitdroid.domain.core.DomainObject;


public class DailyPass extends DomainObject implements IDailyPass {
	

	private Date date;
	
	public DailyPass(UUID id,int version, Date date) {
		super(id, version);
		this.date = date;
	}
	
	
	public DailyPass() {
	}


	public DailyPass(UUID id, int version) {
		super(id, version);
		
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
