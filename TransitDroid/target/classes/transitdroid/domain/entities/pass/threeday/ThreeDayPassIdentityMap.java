package transitdroid.domain.entities.pass.threeday;

import java.util.IdentityHashMap;
import java.util.UUID;


public class ThreeDayPassIdentityMap {
	
	private static ThreeDayPassIdentityMap instance = null;
	private static IdentityHashMap<UUID, ThreeDayPass> map = new IdentityHashMap<UUID, ThreeDayPass>();
	
	private ThreeDayPassIdentityMap(){
	}
	public static ThreeDayPassIdentityMap getUniqueInstance() {
		if(instance == null){
			instance = new ThreeDayPassIdentityMap();
		}
		return instance;
	}

	public ThreeDayPass get(UUID id){
		return map.get(id);
	}
	
	public void put(UUID uuid, ThreeDayPass threeDayPass){
		map.put(uuid, threeDayPass);
	}

}
