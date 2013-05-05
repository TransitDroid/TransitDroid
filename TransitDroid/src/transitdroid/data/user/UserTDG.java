package transitdroid.data.user;

import java.net.URISyntaxException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import transitdroid.data.TableDataGateway;
import transitdroid.domain.logic.technical.IdFactory;

/**
 * 
 * @author TransitDroid Team
 * @class UserTDG
 *  Contains the SQL logic and instructions definitions that relate to the User table in the database.
 *
 */
public class UserTDG extends TableDataGateway {
	
	static {
		TABLE = "users";
		CREATE = "CREATE TABLE IF NOT EXISTS "+TABLE+" (" +
			"`id` varchar(36) NOT NULL," +
			"`version` int(11) DEFAULT NULL," +
			"`firstName` varchar(45) DEFAULT NULL," +
			"`lastName` varchar(45) DEFAULT NULL," +
			"`username` varchar(45) DEFAULT NULL," +
			"`password` varbinary(100) DEFAULT NULL," +
			"`salt` varbinary(100) DEFAULT NULL," +
			"PRIMARY KEY (`id`)," +
			" KEY `card_idx` (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8";
		DROP = "DROP TABLE IF EXISTS "+TABLE;
	}
	/**
	 *  get the next ID of User objects in the database. Can be used for generating new ID's
	 *        for in-memory User objects.
	 * @return long
	 * @throws URISyntaxException
	 */
	public static synchronized long getNextId() throws URISyntaxException {
		return IdFactory.getNext(TABLE);
	}
	/**
	 *  create User Table
	 * @return boolean
	 * @throws SQLException
	 */
	public static synchronized boolean createTable() throws SQLException{
		PreparedStatement s = prepareStatement(CREATE);
		return s.execute();
	}
	/**
	 *  drop User Table from database
	 * @return boolean
	 * @throws SQLException
	 */
	public static synchronized boolean dropTable() throws SQLException{
		PreparedStatement s = prepareStatement(DROP);
		return s.execute();
	}
}
