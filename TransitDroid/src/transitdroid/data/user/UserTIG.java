package transitdroid.data.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * 
 * @author TransitDroid Team
 * @class UserTIG
 *  Contains the SQL logic to find objects from the database. The UserTIG's methods are static
 *        and to be used in the UserInputMapper. Extends UserTDG to implement and use the preparedStatements.
 *
 */
public class UserTIG extends UserTDG {

	static 
	{
		SELECT = "SELECT * FROM "+TABLE+" WHERE id = ?";
	}
	public static final String SELECT_BY_USERNAME = "SELECT * FROM "+TABLE+" WHERE username = ?";
	public static final String SELECT_ALL = "SELECT * FROM "+TABLE;

	/**
	 *  returns back all the User Entities in the database
	 * @return ResultSet
	 */
	public static synchronized ResultSet findAll() throws SQLException {
		PreparedStatement s = prepareStatement(SELECT_ALL);
		return s.executeQuery();		
	}
	/**
	 *  returns back a specific User from the database with the indicated UUID.
	 * 
	 * @param id
	 * @return ResultSet
	 * @throws SQLException
	 */
	public static synchronized ResultSet find(UUID uuid) throws SQLException {
		PreparedStatement s = prepareStatement(SELECT);
		s.setString(1, uuid.toString());
		return s.executeQuery();
	}
	/**
	 *  returns back a specific User from the database with the indicated username.
	 * 
	 * @param String
	 * @return ResultSet
	 * @throws SQLException
	 */
	public static synchronized ResultSet find(String username) throws SQLException {
		PreparedStatement s = prepareStatement(SELECT_BY_USERNAME);
		s.setString(1, username);
		return s.executeQuery();
	}
	
	public static synchronized int getVersion(String id) throws SQLException
	{
		PreparedStatement s = prepareStatement("Select version from "+TABLE + "where id = ?");
		s.setString(1, id);
		return s.executeQuery().getInt(1);
	}
}
