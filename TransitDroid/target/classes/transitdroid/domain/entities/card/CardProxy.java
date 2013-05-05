package transitdroid.domain.entities.card;

import java.util.UUID;

import transitdroid.domain.core.BaseProxy;
import transitdroid.domain.entities.pass.daily.IDailyPass;
import transitdroid.domain.entities.pass.monthly.IMonthlyPass;
import transitdroid.domain.entities.pass.nightly.INightlyPass;
import transitdroid.domain.entities.pass.single.ISinglePass;
import transitdroid.domain.entities.pass.threeday.IThreeDayPass;
import transitdroid.domain.entities.pass.yearly.IYearlyPass;

public class CardProxy extends BaseProxy<Card> implements ICard {

	public CardProxy(UUID id) {
		super(id, Card.class);
	}

	@Override
	public int getVersion() {

		return getInnerObject().getVersion();
	}

	@Override
	public void setId(UUID id) {
		getInnerObject().setId(id);
	}

	@Override
	public boolean equals(Object obj) {
		return getInnerObject().equals(obj);
	}

	@Override
	public void setVersion(int version) {
		getInnerObject().setVersion(version);
	}

	@Override
	public INightlyPass getNightlyPass() {
		return getInnerObject().getNightlyPass();
	}

	@Override
	public void setNightlyPass(INightlyPass nightlyPass) {
		getInnerObject().getNightlyPass();
	}

	@Override
	public void setMonthlyPass(IMonthlyPass monthlyPass) {
		getInnerObject().setMonthlyPass(monthlyPass);
	}

	@Override
	public IMonthlyPass getMonthlyPass() {
		return getInnerObject().getMonthlyPass();
	}


	@Override
	public IDailyPass getDailyPass() {
		return getInnerObject().getDailyPass();
	}

	@Override
	public void setDailyPass(IDailyPass dailyPass) {
		getInnerObject().setDailyPass(dailyPass);
	}

	@Override
	public ISinglePass getSinglePass() {
		return getInnerObject().getSinglePass();
	}

	@Override
	public void setSinglePass(ISinglePass singlePass) {
		getInnerObject().setSinglePass(singlePass);
	}

	@Override
	public IThreeDayPass getThreeDayPass() {
		return getInnerObject().getThreeDayPass();
	}

	@Override
	public void setThreeDayPass(IThreeDayPass threeDayPass) {
		getInnerObject().setThreeDayPass(threeDayPass);
	}

	@Override
	public IYearlyPass getYearlyPass() {
		return getInnerObject().getYearlyPass();
	}

	@Override
	public int hashCode() {
		return getInnerObject().hashCode();
	}

	@Override
	public void setYearlyPass(IYearlyPass yearlyPass) {
		getInnerObject().setYearlyPass(yearlyPass);
	}

	@Override
	public String toString() {
		return getInnerObject().toString();
	}

}
