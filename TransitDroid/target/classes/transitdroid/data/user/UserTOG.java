package transitdroid.data.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


/**
 * 
 * @author TransitDroid Team 
 * @class UserTOG
 *  Contains the SQL logic to insert,update and remove objects from the database. The UserTOG's methods are static
 *        and to be used in the UserOutputMapper. Extends UserTDG to implement and use the preparedStatements.
 *
 */
public class UserTOG extends UserTDG {

	static 
	{
		INSERT = "INSERT INTO "+TABLE+" (id, version, firstName, lastName, " +
				"username, password, salt) values(?, ?, ?, ?, ?, ?, ?)";
		UPDATE = "UPDATE "+TABLE+" SET version=version+1, firstName=?, " +
				"lastName =?, username=?, password=?, salt=? WHERE id=? and version =?";
		DELETE = "DELETE FROM "+TABLE+" WHERE id=? AND version=?";
	}
	
	/**
	 *  contains SQL logic to insert User objects into the database.
	 * 
	 * @param uuid
	 * @param version
	 * @param firstName
	 * @param lastName
	 * @param uuid2
	 * @param username
	 * @param password
	 * @param salt
	 * @throws SQLException
	 */
	public static synchronized void insert(UUID uuid, int version, String firstName, String lastName,
			String username, byte[] password, byte[] salt) throws SQLException{
		PreparedStatement s = prepareStatement(INSERT);
		s.setString(1, uuid.toString());
		s.setInt(2, version);
		s.setString(3, firstName);
		s.setString(4, lastName);
		s.setString(5, username);
		s.setBytes(6, password);
		s.setBytes(7, salt);
		s.executeUpdate();
	}

	public static synchronized int update(UUID uuid, int version,String firstName, String lastName,
			String username, byte[] password, byte[] salt) throws SQLException 
	{
		PreparedStatement s = prepareStatement(UPDATE);
		s.setString(6, uuid.toString());
		s.setInt(7,version);
		s.setString(1, firstName);
		s.setString(2,lastName);
		s.setString(3, username);
		s.setBytes(4, password);
		s.setBytes(5, salt);
		
		//count is for the update.
		final int count = s.executeUpdate();
		return count;
	}
	
	public static synchronized int delete(UUID uuid, int version) throws SQLException{
		PreparedStatement s = prepareStatement(DELETE);
		s.setString(1,uuid.toString());
		s.setInt(2,version);
		
		final int count = s.executeUpdate();
		return count;
	}
	
	
	
	public static synchronized ResultSet findAll() {
		return null;
		
		
	}

	public static synchronized ResultSet find(long id) throws SQLException {
		return null;	
	}
}
