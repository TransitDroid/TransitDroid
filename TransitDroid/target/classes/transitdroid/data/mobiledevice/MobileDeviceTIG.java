package transitdroid.data.mobiledevice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
/**
 * 
 * @author TransitDroid Team
 * @class MobileDeviceTIG
 *  Contains the SQL logic to find objects from the database. The MobileDeviceTIG's methods are static
 *        and to be used in the MobileDeviceInputMapper. Extends MobileDeviceTDG to implement and use the preparedStatements.
 *
 */
public class MobileDeviceTIG extends MobileDeviceTDG{

	public final static String SELECT_BY_MOBILEDEVICEMAC;
	static {
		SELECT = "SELECT * FROM "+TABLE+" WHERE id= ?";
		SELECT_BY_MOBILEDEVICEMAC ="SELECT * FROM "+TABLE+" WHERE mobileDeviceMAC= ?";
		}
	public static final String SELECT_ALL = "SELECT * FROM "+TABLE;
	/**
	 *  returns back all the MobileDevice Entities in the database
	 * @return ResultSet
	 */
	public static synchronized ResultSet findAll() throws SQLException{
		PreparedStatement s = prepareStatement(SELECT_ALL);
		return s.executeQuery();	
	}
	/**
	 *  returns back a specific MobileDevice from the database with the indicated UUID.
	 * 
	 * @param id
	 * @return ResultSet
	 * @throws SQLException
	 */
	public static synchronized ResultSet find(UUID id) throws SQLException {
		PreparedStatement s = prepareStatement(SELECT);
		s.setString(1, id.toString());
		return s.executeQuery();
	}
	public static synchronized ResultSet find(String mobileDeviceMAC) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement s = prepareStatement(SELECT_BY_MOBILEDEVICEMAC);
		s.setString(1, mobileDeviceMAC);
		return s.executeQuery();
	}
	
}
