package transitdroid.domain.entities.pass.threeday;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


import transitdroid.data.pass.threeday.ThreeDayPassTIG;
import transitdroid.domain.core.BaseInputMapper;



public class ThreeDayPassInputMapper extends BaseInputMapper<ThreeDayPass>{
	
	public ThreeDayPass find(UUID id){
		ResultSet set = null;
		ThreeDayPass threeDayPass = null;
		if ((threeDayPass = ThreeDayPassIdentityMap.getUniqueInstance().get(id)) != null){
			return threeDayPass;
		}
		try{
			set = ThreeDayPassTIG.find(id);
			if (set.next())
			threeDayPass = map(set);
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return threeDayPass;
	}
	
//	public static User find(String username, String password) throws SQLException {
//		ResultSet set = null;
//		User user = null;
//			set = UserTIG.find(username, password);
//			if (!set.next()){
//				throw new SQLException();
//			}
//			user = map(set);
//		return user;
//	}
	
	protected ThreeDayPass map(ResultSet set) throws SQLException{
		ThreeDayPass threeDayPass = null;
		if ((threeDayPass = ThreeDayPassIdentityMap.getUniqueInstance().get(UUID.fromString(set.getString(1)))) != null){
			return threeDayPass;
		}
		threeDayPass = ThreeDayPassFactory.createClean(UUID.fromString(set.getString(1)), set.getInt(2));	
		ThreeDayPassIdentityMap.getUniqueInstance().put(threeDayPass.getId(), threeDayPass);
		return threeDayPass;
	}


}
