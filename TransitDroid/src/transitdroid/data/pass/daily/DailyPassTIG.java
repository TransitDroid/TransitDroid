package transitdroid.data.pass.daily;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class DailyPassTIG extends DailyPassTDG {
	
	static 
	{
		SELECT = "SELECT * FROM "+TABLE+" WHERE id= ?";
	}
	
	public static final String SELECT_ALL = "SELECT * FROM "+TABLE;
	
	public static synchronized ResultSet findAll() throws SQLException {
		PreparedStatement s = prepareStatement(SELECT_ALL);
		return s.executeQuery();
				
	}
	
	
	
	public static synchronized ResultSet find(UUID id) throws SQLException {
		PreparedStatement s = prepareStatement(SELECT);
		s.setString(1, id.toString());
		return s.executeQuery();
	}

}
