package transitdroid.data.card;

import java.net.URISyntaxException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import transitdroid.data.TableDataGateway;
import transitdroid.domain.logic.technical.IdFactory;

/**
 * 
 * @author TransitDroid Team
 * @class CardTDG
 *  Contains the SQL logic and instructions definitions that relate to the Card table in the database.
 *
 */
public class CardTDG extends TableDataGateway{
	protected static final String TABLE = "cards";
	private static final String DROP = "DROP TABLE IF EXISTS "+TABLE;

	private static final String CREATE = "CREATE TABLE IF NOT EXISTS "+TABLE+" (" +
			"`id` bigint(20) NOT NULL," +
			"`version` int(11) DEFAULT NULL," +
			"`monthlyPassId` bigInt(20) DEFAULT NULL," +
			"`nightlyPassId` bigInt(20) DEFAULT NULL," +
			"`dailyPassId` bigInt(20) DEFAULT NULL," +
			"`threeDayPassId` bigInt(20) DEFAULT NULL," +
			"`singlePassId` bigint(20) DEFAULT NULL," +
			"`yearlyPassId` bigInt(20) DEFAULT NULL," +
			"PRIMARY KEY (`id`)," +
			" KEY `card_idx` (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8";

	/**
	 *  get the next ID of card objects in the database. Can be used for generating new ID's
	 *        for in-memory Card objects.
	 * @return long
	 * @throws URISyntaxException
	 */
	public static long getNextId() throws URISyntaxException {
		return IdFactory.getNext(TABLE);
	}
	/**
	 *  create Card Table
	 * @return boolean
	 * @throws SQLException
	 */
	public static boolean createTable() throws SQLException{
		PreparedStatement s = prepareStatement(CREATE);
		return s.execute();
	}
	/**
	 *  drop Card Table from database
	 * @return boolean
	 * @throws SQLException
	 */
	public static boolean dropTable() throws SQLException{
		PreparedStatement s = prepareStatement(DROP);
		return s.execute();
	}
	
	
}
