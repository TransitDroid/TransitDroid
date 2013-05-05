package transitdroid.domain.entities.pass.monthly;

import java.util.IdentityHashMap;
import java.util.UUID;



public class MonthlyPassIdentityMap {
	
	private static MonthlyPassIdentityMap instance = null;
	private static IdentityHashMap<UUID, MonthlyPass> map = new IdentityHashMap<UUID, MonthlyPass>();
	
	private MonthlyPassIdentityMap(){
	}
	public static MonthlyPassIdentityMap getUniqueInstance() {
		if(instance == null){
			instance = new MonthlyPassIdentityMap();
		}
		return instance;
	}

	public MonthlyPass get(UUID id){
		return map.get(id);
	}
	
	public void put(UUID id, MonthlyPass monthlyPass){
		map.put(id, monthlyPass);
	}

}
