package transitdroid.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author TransitDroid Team
 *  Classes that extend this can connect to the database using credentials setup in the resources.properties file. 
 */
public abstract class TableDataGateway {

	protected ResultSet resultSet;
	public static String TABLE;
	protected static String DROP;
	protected static String CREATE;
	protected static String INSERT;
	protected static String UPDATE;
	protected static String SELECT;
	protected static String DELETE;
	/**
	 *  Creates a prepared statement.
	 * 
	 * @param sql String representation of the SQL query.
	 * @throws SQLException
	 */
	protected static PreparedStatement prepareStatement(String sql) throws SQLException{
		return DbRegistry.prepareStatement(sql);
	}

	/**
	 *  Closes the database connection
	 * @throws SQLException
	 */
	@SuppressWarnings("static-access")
	protected static void close() throws SQLException{
		DbRegistry.getInstance().close();
	}
}
