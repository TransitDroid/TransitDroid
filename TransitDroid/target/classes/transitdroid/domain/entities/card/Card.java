package transitdroid.domain.entities.card;

import java.util.UUID;


import transitdroid.domain.core.DomainObject;
import transitdroid.domain.entities.pass.daily.IDailyPass;
import transitdroid.domain.entities.pass.monthly.IMonthlyPass;
import transitdroid.domain.entities.pass.nightly.INightlyPass;
import transitdroid.domain.entities.pass.single.ISinglePass;
import transitdroid.domain.entities.pass.threeday.IThreeDayPass;
import transitdroid.domain.entities.pass.yearly.IYearlyPass;

/**
 * 
 * @author TransitDroid Team
 * @class Card
 *  This is a domain entity that extends DomainObject and implements ICard.
 * 
 * Card Class contains private attributes indicating what type of Pass a specific card
 * may contain. It also have a private List of Passes to keep track of all the passes 
 * a card my be subscribed for.
 */
public class Card extends DomainObject implements ICard {

	private IMonthlyPass monthlyPass;
	private INightlyPass nightlyPass;
	private IDailyPass dailyPass;
	private ISinglePass singlePass;
	private IThreeDayPass threeDayPass;
	private IYearlyPass yearlyPass;
	/**
	 *  parameterized constructor with a UUID and a version number of the in-memory object.
	 * 
	 * @param id Card UUID
	 * @param version Card version number
	 * @param monthlyPass
	 * @param nightlyPass
	 * @param dailyPass
	 * @param singlePass
	 * @param threeDayPass
	 * @param yearlyPass
	 */
	public Card(UUID id, int version, IMonthlyPass monthlyPass, INightlyPass nightlyPass,
			IDailyPass dailyPass, ISinglePass singlePass,
			IThreeDayPass threeDayPass, IYearlyPass yearlyPass) {
		super(id, version);
		this.monthlyPass= monthlyPass;
		this.nightlyPass = nightlyPass;
		this.dailyPass = dailyPass;
		this.singlePass = singlePass;
		this.threeDayPass = threeDayPass;
		this.yearlyPass = yearlyPass;
		
	}	
	Card(){}
	/**
	 *  get the nightly pass attribute.
	 * @return NightlyPass
	 */
	public INightlyPass getNightlyPass() {
		return nightlyPass;
	}
	/**
	 *  set the nightly pass attribute.
	 * @param NightlyPass
	 */
	public void setNightlyPass(INightlyPass nightlyPass) {
		this.nightlyPass = nightlyPass;
	}
	/**
	 *  set the MonthlyPass attribute
	 * @param MonthlyPass
	 */
	public void setMonthlyPass(IMonthlyPass monthlyPass) {
		this.monthlyPass = monthlyPass;
	}
	/**
	 *  get the MonthlyPass Attribute
	 * @return MonthlyPass
	 */
	public IMonthlyPass getMonthlyPass() {
		return monthlyPass;
	}
	/**
	 *  set the MonthlyPass attribute
	 * @param MonthlyPass
	 */
	public void setMonthlyPassWindow(IMonthlyPass monthlyPass) {
		this.monthlyPass= monthlyPass;
	}
	/**
	 *  get the DailyPass attribute
	 * @return DailyPass
	 */
	public IDailyPass getDailyPass() {
		return dailyPass;
	}
	/**
	 *  set the DailyPass attribute
	 * @param DailyPass
	 */
	public void setDailyPass(IDailyPass dailyPass) {
		this.dailyPass = dailyPass;
	}
	/**
	 *  get the SinglePass attribute
	 * @return SinglePass
	 */
	public ISinglePass getSinglePass() {
		return singlePass;
	}
	/**
	 *  set the SinglePass attribute
	 * @param SinglePass
	 */
	public void setSinglePass(ISinglePass singlePass) {
		this.singlePass = singlePass;
	}
	/**
	 *  get the ThreeDayPass attribute
	 * @return ThreeDayPass
	 */
	public IThreeDayPass getThreeDayPass() {
		return threeDayPass;
	}
	/**
	 *  set the ThreeDatPass attribute
	 * @param ThreeDayPass
	 */
	public void setThreeDayPass(IThreeDayPass threeDayPass) {
		this.threeDayPass = threeDayPass;
	}
	/**
	 *  get the YearlyPass attribute
	 * @return YearlyPass
	 */
	public IYearlyPass getYearlyPass() {
		return yearlyPass;
	}
	/**
	 *  set the YearlyPass attribute
	 * @param YearlyPass
	 */
	public void setYearlyPass(IYearlyPass yearlyPass) {
		this.yearlyPass = yearlyPass;
	}

	

	
	
	
}
