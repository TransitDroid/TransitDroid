package transitdroid.domain.entities.pass.single;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


import transitdroid.data.pass.single.SinglePassTIG;
import transitdroid.domain.core.BaseInputMapper;
import transitdroid.domain.core.IdentityMapRepository;



public class SinglePassInputMapper extends BaseInputMapper<SinglePass>{
	
	public SinglePass find(UUID id){
		ResultSet set = null;
		SinglePass singlePass = null;
		if ((singlePass = (SinglePass) IdentityMapRepository.getIdentityMap(SinglePass.class).get(id)) != null){
			return singlePass;
		}
		try{
			set = SinglePassTIG.find(id);
			if (set.next())
			singlePass = map(set);
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return singlePass;
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
	
	protected SinglePass map(ResultSet set) throws SQLException{
		SinglePass singlePass = null;
		if ((singlePass = (SinglePass) IdentityMapRepository.getIdentityMap(SinglePass.class).get(UUID.fromString(set.getString(1)))) != null){
			return singlePass;
		}
		singlePass = SinglePassFactory.createClean(UUID.fromString(set.getString(1)), set.getInt(2), set.getInt(3), set.getDouble(4), set.getDate(5));	
		IdentityMapRepository.getIdentityMap(SinglePass.class).put(singlePass);
		return singlePass;
	}



}
