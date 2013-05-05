package transitdroid.domain.entities.pass.yearly;

import java.net.URISyntaxException;
import java.util.Date;
import java.util.UUID;

import transitdroid.domain.core.UnitOfWork;


public class YearlyPassFactory {

	

	public static YearlyPass createNew(Date date) throws URISyntaxException{
		UUID id = UUID.randomUUID();
		return createNew(id, 1, date);
		
	}
	
	public static YearlyPass createNew(UUID id, int version, Date date){
		YearlyPass yearlyPass = new YearlyPass(id, version, date);
		return yearlyPass;
	}

	@SuppressWarnings("unchecked")
	public static YearlyPass createNew() throws URISyntaxException {
		UUID id = UUID.randomUUID();
		YearlyPass yearlyPass = new YearlyPass(id, 1);
		UnitOfWork.getInstance().RegisterNew(yearlyPass);
		return yearlyPass;
	}
	
	public static YearlyPass createClean(UUID id, int version){
		YearlyPass yearlyPass= new YearlyPass(id, version);
		return yearlyPass;
	}
}
