package transitdroid.domain.entities.pass.monthly;

import java.util.Calendar;
import java.util.UUID;
import transitdroid.domain.core.DomainObject;


public class MonthlyPass extends DomainObject implements IMonthlyPass {
	
	private int month;
	private int year;
	

	
	public MonthlyPass(UUID id, int version, Calendar monthAndYear) {
		super(id, version);
		this.month= monthAndYear.get(Calendar.MONTH+1);
		this.year= monthAndYear.get(Calendar.YEAR);
	}

	public MonthlyPass(UUID id,int version, int month, int year){
		super(id, version);
		this.month=month;
		this.year=year;
	}
	
	public MonthlyPass() {
	}

	public MonthlyPass(UUID id, int version) {
		super(id, version);
	}
	
	public MonthlyPass(UUID id, int version,int month) {
		super(id, version);
		this.month = month;
	}

	public int getMonth() {
		return month;
	}


	public void setMonth(int month) {
		this.month = month;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}
}
	