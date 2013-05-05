package transitdroid.data.card;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.UUID;

import org.junit.Test;

import transitdroid.data.pass.daily.DailyPassTOG;
import transitdroid.data.pass.monthly.MonthlyPassTOG;
import transitdroid.data.pass.nightly.NightlyPassTOG;
import transitdroid.data.pass.single.SinglePassTOG;
import transitdroid.data.pass.threeday.ThreeDayPassTOG;
import transitdroid.data.pass.yearly.YearlyPassTOG;
import transitdroid.domain.entities.card.Card;
import transitdroid.domain.entities.card.CardFactory;
import transitdroid.domain.entities.pass.daily.DailyPass;
import transitdroid.domain.entities.pass.monthly.MonthlyPass;
import transitdroid.domain.entities.pass.nightly.NightlyPass;
import transitdroid.domain.entities.pass.single.SinglePass;
import transitdroid.domain.entities.pass.threeday.ThreeDayPass;
import transitdroid.domain.entities.pass.yearly.YearlyPass;

public class CardTOGTest {

	

	@Test
	public void testInsert() throws SQLException {
		
		MonthlyPass mp = new MonthlyPass();
		mp.setId(UUID.randomUUID());
		MonthlyPassTOG.insert(mp.getId(), 1);
		
		
		NightlyPass np = new NightlyPass();
		np.setId(UUID.randomUUID());
		NightlyPassTOG.insert(np.getId(), 1);
		
		SinglePass sp = new SinglePass();
		sp.setId(UUID.randomUUID());
		SinglePassTOG.insert(sp.getId(), 1);
		
		
		ThreeDayPass tdp = new ThreeDayPass();
		tdp.setId(UUID.randomUUID());
		ThreeDayPassTOG.insert(tdp.getId(), 1);
		
		YearlyPass yp = new YearlyPass();
		yp.setId(UUID.randomUUID());
		YearlyPassTOG.insert(yp.getId(), 1);
		
		DailyPass dp = new DailyPass();
		dp.setId(UUID.randomUUID());
		DailyPassTOG.insert(dp.getId(), 1);
		
		UUID id = UUID.randomUUID();
		int version = 1;
		
		try {
			
			Card card = CardFactory.createNew(id,version,mp, np, dp, sp, tdp, yp);
			CardTOG.insert(card.getId(), card.getVersion(), card.getMonthlyPass().getId(), card.getNightlyPass().getId(),card.getDailyPass().getId(), card.getSinglePass().getId(), card.getThreeDayPass().getId(), card.getYearlyPass().getId());
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		//DbRegistry.rollback();
		//DbRegistry.close();
	}

	@Test
	public void testFindAll() {
		//fail("Not yet implemented");
	}

	@Test
	public void testFind() {
		//fail("Not yet implemented");
	}

	@Test
	public void testUpdate() throws SQLException {
		
	}

	@Test
	public void testDelete() {
		//fail("Not yet implemented");
	}

}
