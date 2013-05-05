package transitdroid.domain.entities.card;

import java.sql.SQLException;


import transitdroid.data.LostUpdateException;
import transitdroid.data.card.CardTOG;


import transitdroid.domain.core.BaseOutputMapper;
import transitdroid.domain.core.exceptions.MapperException;

/**
 * 
 * @author TransitDroid Team
 *  CardOutputMapper will act as a gate which outputs data from the domain layer to the data source. 
 *        It outputs data from Card DomainObjects to the data source CardTOG.
 *        
 * CardOutputMapper is located in the Domain Layer of the Application. It communicates directly with its
 * corresponding TableOutputGateway i.e CardTOG. The CardOutputMapper contains insert, update and remove methods. 
 * A user of this class can insert a Card object, Update a Card Object, or remove a Card object. The CardOutputMapper's
 * methods delegate the work and functionality to their corresponding static methods in the CardTOG. This class insures 
 * separation of concerns and produce cleaner code. This makes sure that SQL statements of the type "insert", "update",
 * and "delete" i.e remove are kept separate in the data source layer.
 */
public class CardOutputMapper extends BaseOutputMapper<ICard>{
	
	//TODO: boolean
	/**
	 *  passes a Card DomainObject to CardTOG which inserts it into the database.
	 * @param Card
	 */
	public boolean insert(ICard card){
		try {
			CardTOG.insert(card.getId(), card.getVersion(), card.getMonthlyPass().getId(), card.getNightlyPass().getId(), 
					card.getDailyPass().getId(), card.getSinglePass().getId(), card.getThreeDayPass().getId(), card.getYearlyPass().getId());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	/**
	 *  passes a Card DomainObject to CardTOG which updates it in the database.
	 * @param Card
	 * @throws MapperException 
	 */
	public boolean update(ICard card) throws MapperException{
		try {

			final int count = CardTOG.update(card.getId(), card.getVersion(), card.getMonthlyPass().getId(), card.getNightlyPass().getId(), 
					card.getDailyPass().getId(), card.getSinglePass().getId(), card.getThreeDayPass().getId(), card.getYearlyPass().getId());
			throwLostUpdateOnCountOfZero(card, count);
			card.setVersion(card.getVersion() + 1);
			return true;
		} catch (final SQLException e) {
			throw new MapperException(e);
		} catch (LostUpdateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	private void throwLostUpdateOnCountOfZero(ICard card, int count) throws LostUpdateException {
		// TODO Auto-generated method stub
		if (count == 0)
			throw new LostUpdateException("Card: id = " + card.getId()
					+ "; version = " + card.getVersion() + " not found");
	}
	/**
	 *  passes a Card DomainObject to CardTOG which removes it from the database.
	 * @param Card
	 * @throws LostUpdateException 
	 * @throws MapperException 
	 */
	@Override
	public boolean remove(ICard card) throws LostUpdateException, MapperException {
		// TODO Auto-generated method stub
		try {
			final int count = CardTOG.delete(card.getId(), card.getVersion());
			throwLostUpdateOnCountOfZero(card, count);
			return true;
		} catch (final SQLException e) {
			throw new MapperException(e);
		}
		
	}
}
