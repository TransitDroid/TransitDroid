package transitdroid.domain.entities.pass.nightly;

import java.util.IdentityHashMap;
import java.util.UUID;


public class NightlyPassIdentityMap {
	
	private static NightlyPassIdentityMap instance = null;
	private static IdentityHashMap<UUID, NightlyPass> map = new IdentityHashMap<UUID, NightlyPass>();
	
	private NightlyPassIdentityMap(){
	}
	public static NightlyPassIdentityMap getUniqueInstance() {
		if(instance == null){
			instance = new NightlyPassIdentityMap();
		}
		return instance;
	}

	public NightlyPass get(UUID id){
		return map.get(id);
	}
	
	public void put(UUID uuid, NightlyPass nightlyPass){
		map.put(uuid, nightlyPass);
	}

}
