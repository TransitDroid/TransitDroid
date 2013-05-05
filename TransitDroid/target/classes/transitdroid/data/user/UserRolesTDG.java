package transitdroid.data.user;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import transitdroid.data.TableDataGateway;

/**
 * 
 * @author TransitDroid Team
 * @class UserRolesTDG
 *  Contains the SQL logic and instructions definitions that relate to the UserRoles table in the database.
 *
 */
public class UserRolesTDG extends TableDataGateway{

	private static final String TABLE = "usersroles";
	private static final String CREATE = "CREATE TABLE IF NOT EXISTS "+TABLE+" (" +
			"`id` varchar(36) NOT NULL," +
			"`userId` bigint(20) DEFAULT NULL," +
			"`roleId` bigint(20) DEFAULT NULL," +
			"PRIMARY KEY (`id`))" +
			"ENGINE=InnoDB DEFAULT CHARSET=utf8;";
	private static final String DROP = "DROP TABLE IF EXISTS "+TABLE;
	/**
	 *  create UserRole Table
	 * @return boolean
	 * @throws SQLException
	 */
	public synchronized static boolean createTable() throws SQLException{
		PreparedStatement s = prepareStatement(CREATE);
		return s.execute();
	}
	/**
	 *  drop UserRole Table from database
	 * @return boolean
	 * @throws SQLException
	 */
	public synchronized static boolean dropTable() throws SQLException {
		PreparedStatement s = prepareStatement(DROP);
		return s.execute();
	}
	
	
}
