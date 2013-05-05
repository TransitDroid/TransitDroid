package transitdroid.domain.core;

import java.util.HashMap;
import java.util.Map;


public class IdentityMapRepository {
	private static Map<Class<? extends IDomainObject>, IdentityMap<?>> identityMaps = new HashMap<Class<? extends IDomainObject>, IdentityMap<?>>();
	
	public static <O extends IDomainObject>  IdentityMap<O> getIdentityMap(Class<? extends IDomainObject> objectClass){
		@SuppressWarnings("unchecked")
		IdentityMap<O> iMap = (IdentityMap<O>) identityMaps.get(objectClass);
		if ( iMap == null){
				iMap = new IdentityMap<O>();
				identityMaps.put(objectClass, iMap);
		}
		return iMap;
	}
}
