package transitdroid.domain.entities.pass.monthly;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import transitdroid.data.pass.monthly.MonthlyPassTIG;
import transitdroid.domain.core.BaseInputMapper;
import transitdroid.domain.core.IdentityMapRepository;


public class MonthlyPassInputMapper extends BaseInputMapper<MonthlyPass>{

	
	public MonthlyPass find(UUID id){
		ResultSet set = null;
		MonthlyPass monthlyPass = null;
		if ((monthlyPass = (MonthlyPass) IdentityMapRepository.getIdentityMap(MonthlyPass.class).get(id)) != null){
			return monthlyPass;
		}
		try{
			set = MonthlyPassTIG.find(id);
			if (set.next())
			monthlyPass = map(set);
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return monthlyPass;
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
	
	protected MonthlyPass map(ResultSet set) throws SQLException{
		MonthlyPass monthlyPass = null;
		if ((monthlyPass = (MonthlyPass) IdentityMapRepository.getIdentityMap(MonthlyPass.class).get(UUID.fromString(set.getString(1)))) != null){
			return monthlyPass;
		}
		monthlyPass = MonthlyPassFactory.createClean(UUID.fromString(set.getString(1)), set.getInt(2));	
		IdentityMapRepository.getIdentityMap(MonthlyPass.class).put(monthlyPass);
		return monthlyPass;
	}
}
