package transitdroid.domain.entities.pass.daily;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


import transitdroid.data.pass.daily.DailyPassTIG;
import transitdroid.domain.core.BaseInputMapper;



public class DailyPassInputMapper extends BaseInputMapper<DailyPass>{
	
	private DailyPassInputMapper(){}
	public DailyPass find(UUID id){
		ResultSet set = null;
		DailyPass dailyPass = null;
		if ((dailyPass = DailyPassIdentityMap.getUniqueInstance().get(id)) != null){
			return dailyPass;
		}
		try{
			set = DailyPassTIG.find(id);
			if (set.next())
			dailyPass = map(set);
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return dailyPass;
	}
	
	protected DailyPass map(ResultSet set) throws SQLException{
		DailyPass dailyPass= null;
		if ((dailyPass = DailyPassIdentityMap.getUniqueInstance().get(UUID.fromString(set.getString(1)))) != null){
			return dailyPass;
		}
		dailyPass = DailyPassFactory.createClean(UUID.fromString(set.getString(1)), set.getInt(2));	
		DailyPassIdentityMap.getUniqueInstance().put(dailyPass);
		return dailyPass;
	}

}
