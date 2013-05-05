package transitdroid.domain.entities.card;

import transitdroid.domain.core.IDomainObject;
import transitdroid.domain.entities.pass.daily.IDailyPass;
import transitdroid.domain.entities.pass.monthly.IMonthlyPass;
import transitdroid.domain.entities.pass.nightly.INightlyPass;
import transitdroid.domain.entities.pass.single.ISinglePass;
import transitdroid.domain.entities.pass.threeday.IThreeDayPass;
import transitdroid.domain.entities.pass.yearly.IYearlyPass;


public interface  ICard extends IDomainObject{
	
	public boolean equals(Object obj);

	public void setVersion(int version);

	public INightlyPass getNightlyPass();

	public void setNightlyPass(INightlyPass nightlyPass);


	public void setMonthlyPass(IMonthlyPass monthlyPass);

	public IMonthlyPass getMonthlyPass();

	public IDailyPass getDailyPass();

	public void setDailyPass(IDailyPass dailyPass);

	public ISinglePass getSinglePass();

	public void setSinglePass(ISinglePass singlePass);

	public IThreeDayPass getThreeDayPass();

	public void setThreeDayPass(IThreeDayPass threeDayPass);

	public IYearlyPass getYearlyPass();

	public int hashCode();

	public void setYearlyPass(IYearlyPass yearlyPass);

	public String toString();


}
