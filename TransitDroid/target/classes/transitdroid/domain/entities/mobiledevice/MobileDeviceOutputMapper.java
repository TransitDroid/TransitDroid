package transitdroid.domain.entities.mobiledevice;

import java.sql.SQLException;

import transitdroid.data.LostUpdateException;
import transitdroid.data.mobiledevice.MobileDeviceTOG;
import transitdroid.domain.core.BaseOutputMapper;
import transitdroid.domain.core.exceptions.MapperException;
/**
 * 
 * @author TransitDroid Team
 *  MobileDeviceOutputMapper will act as a gate which outputs data from the domain layer to the data source. 
 *        It outputs data from MobileDevice DomainObjects to the data source MobileDeviceTOG.
 *        
 * MobileDeviceOutputMapper is located in the Domain Layer of the Application. It communicates directly with its
 * corresponding TableOutputGateway i.e MobileDeviceTOG. The MobileDeviceOutputMapper contains insert, update and remove methods. 
 * A user of this class can insert a MobileDevice object, Update a MobileDevice Object, or remove a MobileDevice object. The MobileDeviceOutputMapper's
 * methods delegate the work and functionality to their corresponding static methods in the MobileDeviceTOG. This class insures 
 * separation of concerns and produce cleaner code. This makes sure that SQL statements of the type "insert", "update",
 * and "delete" i.e remove are kept separate in the data source layer.
 */
public class MobileDeviceOutputMapper extends BaseOutputMapper<MobileDevice>{
	/**
	 *  passes a MobileDevice DomainObject to MobileDeviceTOG which inserts it into the database.
	 * @param MobileDevice
	 */
	@Override
	public boolean insert(MobileDevice mobileDevice){
		
		try{
			MobileDeviceTOG.insert(mobileDevice.getId(),mobileDevice.getVersion(),mobileDevice.getMobileDeviceMAC());
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return true;
	}
	/**
	 *  passes a MobileDevice DomainObject to MobileDeviceTOG which updates it in the database.
	 * @param MobileDevice
	 */
	@Override
	public boolean update(MobileDevice mobileDevice) throws MapperException
	{
		try {
			final int count = MobileDeviceTOG.update(mobileDevice.getId(), mobileDevice.getVersion(), mobileDevice.getMobileDeviceMAC());
			throwLostUpdateOnCountOfZero(mobileDevice, count);
			mobileDevice.setVersion(mobileDevice.getVersion() + 1);
			return true;
		} catch (final SQLException e) {
			throw new MapperException(e);
		} catch (LostUpdateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	private static void throwLostUpdateOnCountOfZero(MobileDevice mobileDevice, int count)
			throws LostUpdateException {
		// TODO Auto-generated method stub
		if (count == 0)
			throw new LostUpdateException("MobileDevice: id = " + mobileDevice.getId()
					+ "; version = " + mobileDevice.getVersion() + " not found");
	}
	/**
	 *  passes a MobileDevice DomainObject to MobileDeviceTOG which removes it from the database.
	 * @param MobileDevice
	 * @throws MapperException 
	 * @throws LostUpdateException 
	 */
	@Override
	public boolean remove(MobileDevice mobileDevice) throws MapperException, LostUpdateException {
		// TODO Auto-generated method stub
		try {
			final int count = MobileDeviceTOG.delete(mobileDevice.getId(), mobileDevice.getVersion());
			throwLostUpdateOnCountOfZero(mobileDevice, count);
			return true;
		} catch (final SQLException e) {
			throw new MapperException(e);
		}
	
	}
}
