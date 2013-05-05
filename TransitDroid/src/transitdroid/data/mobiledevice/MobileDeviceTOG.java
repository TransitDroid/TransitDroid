package transitdroid.data.mobiledevice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
/**
 * 
 * @author TransitDroid Team 
 * @class MobileDeviceTOG
 *  Contains the SQL logic to insert,update and remove objects from the database. The MobileDeviceTOG's methods are static
 *        and to be used in the MobileDeviceOutputMapper. Extends MobileDeviceTDG to implement and use the preparedStatements.
 *
 */
public class MobileDeviceTOG extends MobileDeviceTDG{
	
	static 
	{
		INSERT = "INSERT INTO "+TABLE+" (id, version, mobileDeviceMAC) values(?, ?, ?)";
		UPDATE = "UPDATE "+TABLE+" SET version=version+1, mobileDeviceMAC=? WHERE id=? and version=?";
		DELETE = "DELETE FROM "+TABLE+" WHERE id=? AND version=?";
	}
	
	/**
	 *  contains SQL logic to insert MobileDevice objects into the database.
	 * 
	 * @param uuid
	 * @param version
	 * @param phoneMAC
	 * @throws SQLException
	 */
	public static synchronized void insert(UUID uuid, int version, String mobileDeviceMAC) throws SQLException{
		PreparedStatement s = prepareStatement(INSERT);
		s.setString(1, uuid.toString());
		s.setInt(2, version);
		s.setString(3, mobileDeviceMAC);
		s.executeUpdate();
	}
	
	public static synchronized ResultSet findAll() {
		return null;
		
		
	}

	public static synchronized ResultSet find(long id) throws SQLException {
		return null;	
	}

	public static int update(UUID id, int version, String mobileDeviceMAC) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement s = prepareStatement(UPDATE);
		s.setString(2, id.toString());
		s.setInt(3,version);
		s.setString(1, mobileDeviceMAC);
		
		//count is for the update.
		final int count = s.executeUpdate();
		return count;
	}

	public static synchronized int delete(UUID id, int version) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement s = prepareStatement(DELETE);
		s.setString(1,id.toString());
		s.setInt(2,version);
		
		final int count = s.executeUpdate();
		return count;
	}

}
