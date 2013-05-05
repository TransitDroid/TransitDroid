package transitdroid.data.contract;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.junit.Test;

import transitdroid.data.DbRegistry;
import transitdroid.data.card.CardTIG;
import transitdroid.data.card.CardTOG;

public class ContractTOGTest {

	@Test
	public void testInsert() throws SQLException {
		
		UUID id = UUID.randomUUID();
		int version = 1;
		UUID monthlyPassId = UUID.randomUUID();
		UUID nightlyPassId = UUID.randomUUID();
		UUID dailyPassId = UUID.randomUUID();
		UUID threeDayPassId = UUID.randomUUID();
		UUID singlePassId = UUID.randomUUID();
		UUID yearlyPassId = UUID.randomUUID();
		
		
		CardTOG.insert(id, version, monthlyPassId, nightlyPassId, dailyPassId, threeDayPassId, singlePassId, yearlyPassId);
		ResultSet rs = CardTIG.find(id);
		assertNotNull(rs);
		
		
		UUID monthlyPassId2 = UUID.randomUUID();
		UUID nightlyPassId2 = UUID.randomUUID();
		UUID dailyPassId2 = UUID.randomUUID();
		UUID threeDayPassId2 = UUID.randomUUID();
		UUID singlePassId2 = UUID.randomUUID();
		UUID yearlyPassId2 = UUID.randomUUID();
		
		CardTOG.update(id, 2, monthlyPassId2, nightlyPassId2, dailyPassId2, threeDayPassId2, singlePassId2, yearlyPassId2);
		ResultSet rs2 = CardTIG.find(id);
		assertNotNull(rs2);
		
		CardTOG.delete(id, 2);
		ResultSet rs3 = CardTIG.find(id);
		assertNotNull(rs3);
		
		DbRegistry.rollback();
		DbRegistry.close();
	
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

}
