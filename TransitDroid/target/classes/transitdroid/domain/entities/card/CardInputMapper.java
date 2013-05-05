package transitdroid.domain.entities.card;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


import transitdroid.data.card.CardTIG;
import transitdroid.domain.core.BaseInputMapper;
import transitdroid.domain.entities.pass.daily.DailyPassProxy;
import transitdroid.domain.entities.pass.monthly.MonthlyPassProxy;
import transitdroid.domain.entities.pass.nightly.NightlyPassProxy;
import transitdroid.domain.entities.pass.single.SinglePassProxy;
import transitdroid.domain.entities.pass.threeday.ThreeDayPassProxy;
import transitdroid.domain.entities.pass.yearly.YearlyPassProxy;
/**
 * 
 * @author TransitDroid Team
 *  CardInputMapper will act as a gate which inputs data from the data source layer. It inputs
 *        data to the instances of Card DomainObjects.
 *        
 * CardInputMapper is located in the Domain Layer of the Application. It communicates directly with its
 * corresponding TableInputGateway i.e CardTIG. The CardInputMapper contains find and map methods. A user
 * of this class can find if an object exists in the database or in-memory by simply passing the desired 
 * UUID of that object. The CardInputMapper will try to find it in the CardIdentityMap (if it is in-memory), 
 * else it will delegate finding it in the database to CardTIG. This class insures separation of concerns
 * and produce cleaner code. This makes sure that SQL statements of the type "find" are kept separate
 * in the data source layer.
 *
 */
public class CardInputMapper extends BaseInputMapper<Card>{
	/**
	 *  find and return a Card Object. Search in the CardIdentityMap and return the Card object. 
	 * If not found in the CardIdentityMap, pass the UUID of the object to CardTIG and return the Card
	 * from the database. 
	 * @return Card
	 */
	public Card find(UUID id){
		ResultSet set = null;
		Card card= null;
		if ((card = CardIdentityMap.getUniqueInstance().get(id)) != null){
			return card;
		}
		try{
			set = CardTIG.find(id);
			if(set.next())
				card = map(set);
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return card;
	}
	/**
	 *  In this method after retrieving a new Card object from the CardTIG (database) it creates
	 *        a new in-memory Card object and adds it to the CardFactory's create clean and then adds it
	 *        to the CardIdentityMap. If the Card already exists in the CardIdentity just load it.
	 * @return Card
	 */
	protected Card map(ResultSet set) throws SQLException{
		Card card = null;
		if ((card = CardIdentityMap.getUniqueInstance().get(UUID.fromString(set.getString(1)))) != null){
			return card;
		}
		card= CardFactory.createClean(UUID.fromString(set.getString(1)), set.getInt(2), new MonthlyPassProxy(UUID.fromString(set.getString(3))), new NightlyPassProxy(UUID.fromString(set.getString(4))), new DailyPassProxy(UUID.fromString(set.getString(5))), new SinglePassProxy(UUID.fromString(set.getString(6))), new ThreeDayPassProxy(UUID.fromString(set.getString(7))), new YearlyPassProxy(UUID.fromString(set.getString(8))));	
		CardIdentityMap.getUniqueInstance().put( card);
		return card;
	}

}
