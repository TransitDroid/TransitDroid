package transitdroid.domain.entities.pass.monthly;

import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.UUID;

import transitdroid.domain.core.UnitOfWork;

public class MonthlyPassFactory {
	
	public static MonthlyPass createNew(Calendar monthAndYear) throws Exception{
		UUID id = UUID.randomUUID();
		return createNew(id, 1, monthAndYear);
		
	}
	
	public static MonthlyPass createNew(UUID id, int version, Calendar monthAndYear){
		MonthlyPass monthlyPass= new MonthlyPass(id, version, monthAndYear);
		return monthlyPass;
	}
	
	public static MonthlyPass createNew(UUID id, int version, int month, int year){
		MonthlyPass monthlyPass=new MonthlyPass(id, version, month, year);
		return monthlyPass;
	}

	@SuppressWarnings("unchecked")
	public static MonthlyPass createNew() throws URISyntaxException {
		UUID id = UUID.randomUUID();
		
		MonthlyPass monthlyPass = new MonthlyPass(id, 1);
		UnitOfWork.getInstance().RegisterNew(monthlyPass);
		return monthlyPass;
	}
	
	public static MonthlyPass createClean(UUID id, int version){
		MonthlyPass monthlyPass = new MonthlyPass(id, version);
		return monthlyPass;
	}
	
	
}
