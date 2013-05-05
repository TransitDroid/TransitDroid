package transitdroid.domain.entities.pass.single;

import java.util.IdentityHashMap;
import java.util.UUID;



public class SinglePassIdentityMap {
	
	private static SinglePassIdentityMap instance = null;
	private static IdentityHashMap<UUID, SinglePass> map = new IdentityHashMap<UUID, SinglePass>();
	
	private SinglePassIdentityMap(){
	}
	public static SinglePassIdentityMap getUniqueInstance() {
		if(instance == null){
			instance = new SinglePassIdentityMap();
		}
		return instance;
	}

	public SinglePass get(UUID id){
		return map.get(id);
	}
	
	public void put(UUID id, SinglePass singlePass){
		map.put(id, singlePass);
	}

}
