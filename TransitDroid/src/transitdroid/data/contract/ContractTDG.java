package transitdroid.data.contract;

import java.net.URISyntaxException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import transitdroid.data.TableDataGateway;
import transitdroid.domain.logic.technical.IdFactory;

public class ContractTDG extends TableDataGateway{
	
	protected static final String TABLE = "contracts";
	private static final String DROP = "DROP TABLE IF EXISTS "+TABLE;

	public static long getNextId() throws URISyntaxException {
		return IdFactory.getNext(TABLE);
	}
	
	public static boolean dropTable() throws SQLException{
		PreparedStatement s = prepareStatement(DROP);
		return s.execute();
	}
	

}
