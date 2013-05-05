package transitdroid.data.pass.monthly;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class MonthlyPassTOG extends MonthlyPassTDG {
	
	static
	{
		INSERT = "INSERT INTO "+TABLE+" (id, version) values(?, ?)";
		UPDATE = "UPDATE "+TABLE+" SET version=version+1 WHERE id=? and version=?";
		DELETE = "DELETE FROM "+TABLE+" WHERE id=? AND version=?";
	}
		
	public static synchronized void insert(UUID uuid, int version) throws SQLException{
		PreparedStatement s = prepareStatement(INSERT);
		s.setString(1, uuid.toString());
		s.setInt(2, version);
		s.executeUpdate();
	}
	
	public static synchronized ResultSet findAll() {
		return null;
		
		
	}

	public static synchronized ResultSet find(long id) throws SQLException {
		return null;	
	}
	
	public static synchronized int  update(UUID id, int version) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement s = prepareStatement(UPDATE);
		s.setString(1, id.toString());
		s.setInt(2,version);
		
		//count is for the update.
		final int count = s.executeUpdate();
		return count;
	}

	public static synchronized int delete(UUID id, int version) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement s = prepareStatement(DELETE);
		s.setString(1,id.toString());
		s.setInt(2,version);
		
		final int count = s.executeUpdate();
		return count;
	}

}
