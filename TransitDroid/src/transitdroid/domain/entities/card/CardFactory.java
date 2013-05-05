package transitdroid.domain.entities.card;

import java.net.URISyntaxException;
import java.util.UUID;

import transitdroid.domain.core.UnitOfWork;
import transitdroid.domain.entities.pass.daily.DailyPass;
import transitdroid.domain.entities.pass.daily.IDailyPass;
import transitdroid.domain.entities.pass.monthly.IMonthlyPass;
import transitdroid.domain.entities.pass.monthly.MonthlyPass;
import transitdroid.domain.entities.pass.nightly.INightlyPass;
import transitdroid.domain.entities.pass.nightly.NightlyPass;
import transitdroid.domain.entities.pass.single.ISinglePass;
import transitdroid.domain.entities.pass.single.SinglePass;
import transitdroid.domain.entities.pass.threeday.IThreeDayPass;
import transitdroid.domain.entities.pass.threeday.ThreeDayPass;
import transitdroid.domain.entities.pass.yearly.IYearlyPass;
import transitdroid.domain.entities.pass.yearly.YearlyPass;

/**
 * 
 * @author TransitDroid Team
 * @class CardFactory
 *  This class is a Factory Class of the domain entity Card. It manages creation of new
 *        in-memory Card objects. The Factory Class makes the appropriate calls to the UOW. 
 */
public class CardFactory {
/**
 *  Creates a new Card object with the specified parameters passed. specifically UUID and version.
 * 
 * @param id
 * @param version
 * @param monthlyPass
 * @param nightlyPass
 * @param dailyPass
 * @param singlePass
 * @param threeDayPass
 * @param yearlyPass
 * @return Card
 * @throws URISyntaxException
 */
	@SuppressWarnings("unchecked")
	public static Card createNew(UUID id, int version, MonthlyPass monthlyPass, NightlyPass nightlyPass, DailyPass dailyPass, 
			SinglePass singlePass, ThreeDayPass threeDayPass, YearlyPass yearlyPass) throws URISyntaxException{
	
		Card card= new Card(id, version, monthlyPass, nightlyPass, dailyPass, singlePass, threeDayPass, yearlyPass);
		UnitOfWork.getInstance().RegisterNew(card);
		CardIdentityMap.getUniqueInstance().put(card);
		return card;
	}
	/**
	 *  Create a new Card object with the specified parameters but not with the UUID and version.
	 *        It generates its own UUID.
	 * @param monthlyPass
	 * @param nightlyPass
	 * @param dailyPass
	 * @param singlePass
	 * @param threeDayPass
	 * @param yearlyPass
	 * @return Card
	 * @throws URISyntaxException
	 */
	public static Card createNew(MonthlyPass monthlyPass, NightlyPass nightlyPass, DailyPass dailyPass, SinglePass singlePass, ThreeDayPass threeDayPass, 
			YearlyPass yearlyPass) throws URISyntaxException{
		
		UUID id = UUID.randomUUID();
		
		return createNew(id, 1, monthlyPass, nightlyPass, dailyPass, singlePass, threeDayPass, yearlyPass);
				
	}
	/**
	 *  Creates a new Card object with the specified parameters passed. specifically UUID and version.
	 * @param id
	 * @param version
	 * @param monthlyPass
	 * @param nightlyPass
	 * @param dailyPass
	 * @param singlePass
	 * @param threeDayPass
	 * @param yearlyPass
	 * @return Card
	 */
	@SuppressWarnings("unchecked")
	public static Card createClean(UUID id, int version, IMonthlyPass monthlyPass, INightlyPass nightlyPass,
			IDailyPass dailyPass, ISinglePass singlePass, IThreeDayPass threeDayPass, IYearlyPass yearlyPass){
		Card card = new Card(id, version, monthlyPass, nightlyPass, dailyPass,
				singlePass, threeDayPass, yearlyPass);
		UnitOfWork.getInstance().RegisterNew(card);
		return card;
	}

	
}