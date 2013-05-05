package transitdroid.domain.entities.contract;

import java.sql.SQLException;

import transitdroid.data.LostUpdateException;
import transitdroid.data.contract.ContractTOG;
import transitdroid.domain.core.BaseOutputMapper;
import transitdroid.domain.core.exceptions.MapperException;

/**
 * 
 * @author TransitDroid Team
 *  ContractOutputMapper will act as a gate which outputs data from the domain layer to the data source. 
 *        It outputs data from Contract DomainObjects to the data source ContractTOG.
 *        
 * ContractOutputMapper is located in the Domain Layer of the Application. It communicates directly with its
 * corresponding TableOutputGateway i.e ContractTOG. The ContractOutputMapper contains insert, update and remove methods. 
 * A user of this class can insert a Contract object, Update a Contract Object, or remove a Contract object. The ContractOutputMapper's
 * methods delegate the work and functionality to their corresponding static methods in the ContractTOG. This class insures 
 * separation of concerns and produce cleaner code. This makes sure that SQL statements of the type "insert", "update",
 * and "delete" i.e remove are kept separate in the data source layer.
 */
public class ContractOutputMapper extends BaseOutputMapper<Contract>{
	/**
	 *  passes a Contract DomainObject to ContractTOG which inserts it into the database.
	 * @param Contract
	 */
	@Override
	public boolean insert(Contract contract) {
		// TODO Auto-generated method stub
		try {
			
			ContractTOG.insert(contract.getId(), contract.getVersion(), 
					contract.getMobileDevice().getId(), contract.getCard().getId(), 
					contract.getUser().getId(),contract.getKeys(),contract.getSalt());
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return true;
	}

	/**
	 *  passes a Contact DomainObject to ContractTOG which updates it in the database.
	 * @param Contract
	 * @throws MapperException 
	 */
	@Override
	public boolean update(Contract contract) throws MapperException {
		// TODO Auto-generated method stub
		try {
			final int count = ContractTOG.update(contract.getId(), contract.getVersion(), 
					contract.getMobileDevice().getId(), contract.getCard().getId(), 
					contract.getUser().getId(),contract.getKeys(),contract.getSalt());
			throwLostUpdateOnCountOfZero(contract, count);
			contract.setVersion(contract.getVersion() + 1);
			return true;
		} catch (final SQLException e) {
			throw new MapperException(e);
		} catch (LostUpdateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	private void throwLostUpdateOnCountOfZero(Contract contract, int count) throws LostUpdateException {
		// TODO Auto-generated method stub
		if (count == 0)
			throw new LostUpdateException("Contract: id = " + contract.getId()
					+ "; version = " + contract.getVersion() + " not found");
	}

	/**
	 *  passes a Contract DomainObject to ContractTOG which removes it from the database.
	 * @param Contract
	 * @throws LostUpdateException 
	 * @throws MapperException 
	 */
	@Override
	public boolean remove(Contract contract) throws LostUpdateException, MapperException {
		// TODO Auto-generated method stub
		try {
			final int count = ContractTOG.delete(contract.getId(), contract.getVersion());
			throwLostUpdateOnCountOfZero(contract, count);
			return true;
		} catch (final SQLException e) {
			throw new MapperException(e);
		}
	}

}
