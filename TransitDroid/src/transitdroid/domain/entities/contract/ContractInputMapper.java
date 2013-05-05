package transitdroid.domain.entities.contract;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import transitdroid.data.contract.ContractTIG;
import transitdroid.domain.core.BaseInputMapper;
import transitdroid.domain.entities.card.CardProxy;
import transitdroid.domain.entities.mobiledevice.MobileDeviceProxy;
import transitdroid.domain.entities.user.UserProxy;


/**
 * 
 * @author TransitDroid Team
 *  ContractInputMapper will act as a gate which inputs data from the data source layer. It inputs
 *        data to the instances of Contract DomainObjects.
 *        
 * ContractInputMapper is located in the Domain Layer of the Application. It communicates directly with its
 * corresponding TableInputGateway i.e ContractTIG. The ContractInputMapper contains find and map methods. A user
 * of this class can find if an object exists in the database or in-memory by simply passing the desired 
 * UUID of that object. The ContractInputMapper will try to find it in the ContractIdentityMap (if it is in-memory), 
 * else it will delegate finding it in the database to ContractTIG. This class insures separation of concerns
 * and produce cleaner code. This makes sure that SQL statements of the type "find" are kept separate
 * in the data source layer.
 *
 */
public class ContractInputMapper extends BaseInputMapper<Contract>{
	/**
	 *  find and return a Contract Object. Search in the ContractIdentityMap and return the Contract object. 
	 * If not found in the ContractIdentityMap, pass the UUID of the object to ContractTIG and return the Contract
	 * from the database. 
	 * @return Contract
	 * @throws SQLException 
	 */
	@Override

	public Contract find(UUID id) throws SQLException{
		ResultSet set = ContractTIG.find(id);
		if (set.next())
			return map(set);
		else return null;

		
		
	}

	@Override
	protected Contract map(ResultSet set) throws SQLException {
		Contract contract = null;
		if ((contract = ContractIdentityMap.getUniqueInstance().get(UUID.fromString(set.getString(1)))) != null){
			return contract;
		}
		List<byte[]> keys = new ArrayList<byte[]>();
		keys.add(set.getBytes(6));
		keys.add(set.getBytes(7));
		keys.add(set.getBytes(8));
		keys.add(set.getBytes(9));
		contract = ContractFactory.createClean(UUID.fromString(set.getString(1)), keys, 
				new MobileDeviceProxy(UUID.fromString(set.getString(3))),
				new CardProxy(UUID.fromString(set.getString(4))), 
				new UserProxy(UUID.fromString(set.getString(5))), 
				set.getBytes(10));
		return contract;
	}
	/**
	 *  find and return a Contract Object. Search in the ContractIdentityMap and return the Contract object. 
	 * If not found in the ContractIdentityMap, pass the phoneID of the Contract's IMobileDevice inner object to ContractTIG 
	 * and return the Contract from the database. 
	 * @return Contract
	 * @throws SQLException 
	 */
	//TODO: implement method
	public Contract findByMobileDevice(String mobileDeviceMac) throws SQLException {
		ResultSet set = ContractTIG.findByMobileDevice(mobileDeviceMac);
		if (set.next())
			return map(set);
		else return null;
	}

}
