package transitdroid.domain.entities.pass.threeday;

import java.util.Date;
import java.util.UUID;


import transitdroid.domain.core.DomainObject;


public class ThreeDayPass extends DomainObject implements IThreeDayPass {

	private Date date;
	
	
	public ThreeDayPass(UUID id, int version, Date date) {
		super(id, version);
		this.date = date;
	}
	public ThreeDayPass() {
	}
	public ThreeDayPass(UUID id, int version) {
		super(id, version);
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
