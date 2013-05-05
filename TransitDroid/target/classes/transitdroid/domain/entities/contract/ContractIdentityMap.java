package transitdroid.domain.entities.contract;

import java.util.IdentityHashMap;
import java.util.UUID;

public class ContractIdentityMap {

	private static ContractIdentityMap instance = null;
	private static IdentityHashMap<UUID, Contract> map = new IdentityHashMap<UUID, Contract>();
	/**
	 *  Empty Constructor
	 */
	private ContractIdentityMap(){
	}
	/**
	 *  get the specific UserIdentityMap instance. If doesn't exist then create one and return it.
	 * @return UserIdentityMap
	 */
	static ContractIdentityMap getUniqueInstance() {
		if(instance == null){
			instance = new ContractIdentityMap();
		}
		return instance;
	}
	/**
	 *  get the User from the UserIdentityMap's map with the specific UUID.
	 * @param UUID
	 * @return User
	 */
	Contract get(UUID id){
		return map.get(id);
	}
	/**
	 *  Put the specific User with the UUID into the UserIdentityMap's map.
	 * @param UUID
	 * @param User
	 */
	void put(Contract contract){
		map.put(contract.getId(), contract);
	}
}
