package transitdroid.domain.entities.pass.nightly;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import transitdroid.data.pass.nightly.NightlyPassTIG;
import transitdroid.domain.core.IdentityMapRepository;




public class NightlyPassInputMapper {

	
	public static NightlyPass find(UUID id){
		ResultSet set = null;
		NightlyPass nightlyPass = null;
		if ((nightlyPass = (NightlyPass) IdentityMapRepository.getIdentityMap(NightlyPass.class).get(id)) != null){
			return nightlyPass;
		}
		try{
			set = NightlyPassTIG.find(id);
			if (set.next())
			nightlyPass = map(set);
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return nightlyPass;
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
	
	private static NightlyPass map(ResultSet set) throws SQLException{
		NightlyPass nightlyPass = null;
		if ((nightlyPass = (NightlyPass) IdentityMapRepository.getIdentityMap(NightlyPass.class).get(UUID.fromString(set.getString(1)))) != null){
			return nightlyPass;
		}
		nightlyPass = NightlyPassFactory.createClean(UUID.fromString(set.getString(1)), set.getInt(2));	
		IdentityMapRepository.getIdentityMap(NightlyPass.class).put(nightlyPass);
		return nightlyPass;
	}

}
