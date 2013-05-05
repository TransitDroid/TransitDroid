package transitdroid.domain.entities.pass.daily;

import java.util.IdentityHashMap;
import java.util.UUID;

import transitdroid.domain.core.IIdentityMap;


public class DailyPassIdentityMap implements IIdentityMap<DailyPass>{
	
	private static DailyPassIdentityMap instance = null;
	private static IdentityHashMap<UUID, DailyPass> map = new IdentityHashMap<UUID, DailyPass>();
	
	private DailyPassIdentityMap(){
	}
	public static DailyPassIdentityMap getUniqueInstance() {
		if(instance == null){
			instance = new DailyPassIdentityMap();
		}
		return instance;
	}

	public DailyPass get(UUID id){
		return map.get(id);
	}
	
	public void put(DailyPass dailyPass){
		map.put(dailyPass.getId(), dailyPass);
	}

}
