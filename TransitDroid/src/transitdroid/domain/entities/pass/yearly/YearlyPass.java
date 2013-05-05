package transitdroid.domain.entities.pass.yearly;

import java.util.Date;
import java.util.UUID;


import transitdroid.domain.core.DomainObject;


public class YearlyPass extends DomainObject implements IYearlyPass {

	private Date date;
	
	
	public YearlyPass(UUID id, int version, Date date) {
		super(id, version);
		this.date = date;
	}
	public YearlyPass() {}
	public YearlyPass(UUID id, int version) {
		super(id, version);
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

}
