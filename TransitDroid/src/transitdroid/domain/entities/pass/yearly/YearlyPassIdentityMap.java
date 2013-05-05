package transitdroid.domain.entities.pass.yearly;

import java.util.IdentityHashMap;
import java.util.UUID;


public class YearlyPassIdentityMap {
	
	private static YearlyPassIdentityMap instance = null;
	private static IdentityHashMap<UUID, YearlyPass> map = new IdentityHashMap<UUID, YearlyPass>();
	
	private YearlyPassIdentityMap(){
	}
	public static YearlyPassIdentityMap getUniqueInstance() {
		if(instance == null){
			instance = new YearlyPassIdentityMap();
		}
		return instance;
	}

	public YearlyPass get(UUID id){
		return map.get(id);
	}
	
	public void put(UUID id, YearlyPass yearlyPass){
		map.put(id, yearlyPass);
	}

}
