package transitdroid.data.pass.single;

import java.net.URISyntaxException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import transitdroid.data.TableDataGateway;
import transitdroid.domain.logic.technical.IdFactory;




public class SinglePassTDG extends TableDataGateway {
	
	
	static
	{
		TABLE = "singlepass";
		DROP = "DROP TABLE IF EXISTS "+TABLE;
		CREATE = "CREATE TABLE IF NOT EXISTS "+TABLE+" (" +
				"`id` bigint(20) NOT NULL," +
				"`version` int(11) DEFAULT NULL," +
				"PRIMARY KEY (`id`)," +
				" KEY `card_idx` (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8";
	}
	
	public static long getNextId() throws URISyntaxException {
		return IdFactory.getNext(TABLE);
	}
	
	public static boolean createTable() throws SQLException{
		PreparedStatement s = prepareStatement(CREATE);
		return s.execute();
	}

	public static boolean dropTable() throws SQLException{
		PreparedStatement s = prepareStatement(DROP);
		return s.execute();
	}
	
	

}
