package transitdroid.domain.entities.pass.daily;

import java.net.URISyntaxException;
import java.util.Date;
import java.util.UUID;

import transitdroid.domain.core.UnitOfWork;

public class DailyPassFactory {
	
	public static DailyPass createNew(Date date) throws URISyntaxException{
		UUID id =  UUID.randomUUID();
		return createNew(id,1);
		
	}
	
	public static DailyPass createNew(UUID id, int version){
		DailyPass dailyPass= new DailyPass(id, version);
		return dailyPass;
	}

	@SuppressWarnings("unchecked")
	public static DailyPass createNew() throws URISyntaxException {
		UUID id = UUID.randomUUID();
		DailyPass dailyPass = new DailyPass(id, 1);
		UnitOfWork.getInstance().RegisterNew(dailyPass);
		DailyPassIdentityMap.getUniqueInstance().put(dailyPass);
		return dailyPass;
	}

	public static DailyPass createClean(UUID id, int version){
		DailyPass dailyPass = new DailyPass(id, version);
		return dailyPass;
	}
}
