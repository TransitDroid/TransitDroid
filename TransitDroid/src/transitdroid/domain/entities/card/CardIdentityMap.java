package transitdroid.domain.entities.card;

import java.util.IdentityHashMap;
import java.util.UUID;
/**
 * 
 * @author TransitDroid Team 
 * @class CardIdentityMap
 *  Ensures that each Card object gets loaded only once in-memory by keeping every card
 *        object in a map. It looks up the Card objects in the map when it needs to access them.
 *        
 * Problems can arise if a card object is loaded into memory more than once and one instance is 
 * changed in one way, while another instance is changed in a different way (conflicts/concurrency issues). 
 * Correctness can not be guaranteed if both those changes were written to the database. The use of Identity
 * maps also help eliminate Cyclic Dependencies.
 *
 */

public class CardIdentityMap {
	
	private static CardIdentityMap instance = null;
	private static IdentityHashMap<UUID, Card> map = new IdentityHashMap<UUID, Card>();
	/**
	 *  Empty Constructor
	 */
	private CardIdentityMap(){
	}
	/**
	 *  get the specific CardIdentityMap instance. If doesn't exist then create one and return it.
	 * @return CardIdentityMap
	 */
	public static CardIdentityMap getUniqueInstance() {
		if(instance == null){
			instance = new CardIdentityMap();
		}
		return instance;
	}
	/**
	 *  get the card from the CardIdentityMap's map with the specific UUID.
	 * @param UUID
	 * @return Card
	 */
	public Card get(UUID id){
		return map.get(id);
	}
	/**
	 *  Put the specific Card with the UUID into the CardIdentityMap's map.
	 * @param UUID
	 * @param Card
	 */
	public void put(Card card){
		map.put(card.getId(), card);
	}

}
