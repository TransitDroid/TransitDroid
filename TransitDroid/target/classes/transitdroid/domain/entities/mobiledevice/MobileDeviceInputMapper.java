package transitdroid.domain.entities.mobiledevice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


import transitdroid.data.mobiledevice.MobileDeviceTIG;
import transitdroid.domain.core.BaseInputMapper;
/**
 * 
 * @author TransitDroid Team
 *  MobileDeviceInputMapper will act as a gate which inputs data from the data source layer. It inputs
 *        data to the instances of MobileDevice DomainObjects.
 *        
 * MobileDeviceInputMapper is located in the Domain Layer of the Application. It communicates directly with its
 * corresponding TableInputGateway i.e MobileDeviceTIG. The MobileDeviceInputMapper contains find and map methods. A user
 * of this class can find if an object exists in the database or in-memory by simply passing the desired 
 * UUID of that object. The MobileDeviceInputMapper will try to find it in the MobileDeviceIdentityMap (if it is in-memory), 
 * else it will delegate finding it in the database to MobileDeviceTIG. This class insures separation of concerns
 * and produce cleaner code. This makes sure that SQL statements of the type "find" are kept separate
 * in the data source layer.
 *
 */
public class MobileDeviceInputMapper extends BaseInputMapper<MobileDevice>{

	/**
	 *  find and return a MobileDevice Object. Search in the MobileDeviceIdentityMap and return the MobileDevice object. 
	 * If not found in the MobileDeviceIdentityMap, pass the UUID of the object to MobileDeviceTIG and return the MobileDevice
	 * from the database. 
	 * @return MobileDevice
	 */
	public MobileDevice find(UUID id){
		ResultSet set = null;
		MobileDevice mobileDevice= null;
		if ((mobileDevice = MobileDeviceIdentityMap.getUniqueInstance().get(id)) != null){
			return mobileDevice;
		}
		try{
			set = MobileDeviceTIG.find(id);
			
			if (set.next())
				mobileDevice = map(set);
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return mobileDevice;
	}
	public MobileDevice find(String mobileDeviceMAC) throws SQLException {
		ResultSet set = null;
		MobileDevice MobileD = null;
			set = MobileDeviceTIG.find(mobileDeviceMAC);
			if (set.next()){
				MobileD = map(set);
			}
		return MobileD;
	}
	/**
	 *  In this method after retrieving a new MobileDevice object from the MobileDeviceTIG (database) it creates
	 *        a new in-memory MobileDevice object and adds it to the MobileDeviceFactory's create clean and then adds it
	 *        to the MobileDeviceIdentityMap. If the MobileDevice already exists in the PhoneIdentity just load it.
	 * @return MobileDevice
	 */
	protected MobileDevice map(ResultSet set) throws SQLException{
		MobileDevice mobileDevice = null;
		if ((mobileDevice = MobileDeviceIdentityMap.getUniqueInstance().get(UUID.fromString(set.getString(1)))) != null){
			return mobileDevice;
		}
		mobileDevice= MobileDeviceFactory.createClean(UUID.fromString(set.getString(1)), set.getInt(2), set.getString(3)  );	
		MobileDeviceIdentityMap.getUniqueInstance().put(mobileDevice);
		return mobileDevice;
	}
	
}
