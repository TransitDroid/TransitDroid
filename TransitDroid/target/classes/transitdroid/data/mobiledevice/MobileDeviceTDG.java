package transitdroid.data.mobiledevice;

import java.net.URISyntaxException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import transitdroid.data.TableDataGateway;
import transitdroid.domain.logic.technical.IdFactory;
/**
 * 
 * @author TransitDroid Team
 * @class MobileDeviceTDG
 *  Contains the SQL logic and instructions definitions that relate to the MobileDevice table in the database.
 *
 */
public class MobileDeviceTDG extends TableDataGateway{

	protected static final String TABLE = "mobiledevice";
	private static final String DROP = "DROP TABLE IF EXISTS "+TABLE;

	private static final String CREATE = "CREATE TABLE IF NOT EXISTS "+TABLE+" (" +
			"`id` bigint(20) NOT NULL," +
			"`version` int(11) DEFAULT NULL," +
			"`mobileDeviceMAC` varchar(45) DEFAULT NULL,"+
			"PRIMARY KEY (`id`)," +
			" KEY `card_idx` (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8";
	//IF THERE IS ANYPROBLEM IN THIS CLASS IT IS MOST LIKELY THE PREVIOUS LINE
	/**
	 *  get the next ID of MobileDevice objects in the database. Can be used for generating new ID's
	 *        for in-memory MobileDevice objects.
	 * @return long
	 * @throws URISyntaxException
	 */
	public static long getNextId() throws URISyntaxException {
		return IdFactory.getNext(TABLE);
	}
	/**
	 *  create MobileDevice Table
	 * @return boolean
	 * @throws SQLException
	 */
	public static boolean createTable() throws SQLException{
		PreparedStatement s = prepareStatement(CREATE);
		return s.execute();
	}
	/**
	 *  drop MobileDevice Table from database
	 * @return boolean
	 * @throws SQLException
	 */
	public static boolean dropTable() throws SQLException{
		PreparedStatement s = prepareStatement(DROP);
		return s.execute();
	}
	
}
