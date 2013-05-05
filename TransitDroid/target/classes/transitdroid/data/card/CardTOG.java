package transitdroid.data.card;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


/**
 * 
 * @author TransitDroid Team 
 * @class CardTOG
 *  Contains the SQL logic to insert,update and remove objects from the database. The CardTOG's methods are static
 *        and to be used in the CardOutputMapper. Extends CardTDG to implement and use the preparedStatements.
 *
 */
public class CardTOG extends CardTDG {
	
	static {
		INSERT = "INSERT INTO "+TABLE+" (id, version, monthlyPassId, nightlyPassId, dailyPassId, " +
			"threeDayPassId, singlePassId, yearlyPassId) values(?, ?, ?, ?, ?, ?, ?, ?)";
		UPDATE = "UPDATE "+TABLE+" set version=version+1, monthlyPassId=?, " +
				"nightlyPassId=?, dailyPassId=?, threeDayPassId=?, singlePassId=?, yearlyPassId=? WHERE id=? and version=?";
		DELETE = "DELETE FROM "+TABLE+" WHERE id=? AND version=?";
	}
	
	/**
	 *  contains SQL logic to insert Card objects into the database.
	 * 
	 * @param uuid
	 * @param version
	 * @param monthlyPassId
	 * @param nightlyPassId
	 * @param dailyPassId
	 * @param threeDayPassId
	 * @param singlePassId
	 * @param yearlyPassId
	 * @throws SQLException
	 */
	public static synchronized void insert(UUID uuid, int version, UUID monthlyPassId, UUID nightlyPassId, UUID dailyPassId, UUID threeDayPassId, 
			UUID singlePassId, UUID yearlyPassId) throws SQLException{
		PreparedStatement s = prepareStatement(INSERT);
		s.setString(1, uuid.toString());
		s.setInt(2, version);
		s.setString(3, monthlyPassId.toString());
		s.setString(4, nightlyPassId.toString());
		s.setString(5, dailyPassId.toString());
		s.setString(6, singlePassId.toString());
		s.setString(7, threeDayPassId.toString());
		s.setString(8, yearlyPassId.toString());
		s.executeUpdate();
	}
	
	public static synchronized ResultSet findAll() {
		return null;
		
		
	}

	public static synchronized ResultSet find(long id) throws SQLException {
		return null;	
	}

	public static synchronized int update(UUID id, int version, UUID id2, UUID id3,
			UUID id4, UUID id5, UUID id6, UUID id7) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement s = prepareStatement(UPDATE);
		s.setString(7, id.toString());
		s.setInt(8, version);
		s.setString(1, id2.toString());
		s.setString(2, id3.toString());
		s.setString(3, id4.toString());
		s.setString(4, id5.toString());
		s.setString(5, id6.toString());
		s.setString(6, id7.toString());
		
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
