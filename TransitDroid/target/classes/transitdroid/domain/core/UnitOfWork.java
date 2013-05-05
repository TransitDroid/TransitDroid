package transitdroid.domain.core;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import transitdroid.data.DbRegistry;
import transitdroid.data.LostUpdateException;
import transitdroid.domain.core.exceptions.CommitUnitOfWorkException;
import transitdroid.domain.core.exceptions.MapperException;

/**
 * 
 * @author TransitDroid Team
 * @class UnitOfWork
 *  Contains a list of objects and their OutputMappers. Maintains and Coordinates the writing
 *        out of changes and resolves concurrency problems.
 *        
 *        If data is changed in-memory, it needs to be persisted to the data source for other requests
 *        to see it. If not done systematically, keeping track of what is changed is difficult as a 
 *        system becomes larger. Alternatively, writing out changes frequently can be slow and 
 *        impractical; there may be many changes, and an actual transaction opened in a data source 
 *        may need to persist across multiple requests [Fowler 2003, p.184].
 * @param <O>
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class UnitOfWork <O extends IDomainObject>{

	public static enum ExecutionEnvironment {Testing, Prodocution};
	public static ExecutionEnvironment executionEnvironment = ExecutionEnvironment.Prodocution;
	private static UnitOfWork<?> instance = null;
	List<KeyValuePair<O, BaseOutputMapper<O>>> regDirty = new ArrayList<KeyValuePair<O, BaseOutputMapper<O>>>();
	private List<KeyValuePair<O, BaseOutputMapper<O>>> registeredDirty = new ArrayList<KeyValuePair<O, BaseOutputMapper<O>>>();
	List<KeyValuePair<O, BaseOutputMapper<O>>> registeredNew = new ArrayList<KeyValuePair<O, BaseOutputMapper<O>>>();
	List<KeyValuePair<O, BaseOutputMapper<O>>> registeredRemoved = new ArrayList<KeyValuePair<O, BaseOutputMapper<O>>>();
	/**
	 *  Empty Constructor	
	 */
	private UnitOfWork(){};
	
	/**
	 *  returns the existing in-memory UOW, if it doesn't exist then create a new
	 *        instance and return it.
	 * @return UnitOfWork<?>
	 */
	public static UnitOfWork getInstance(){
		if ( instance == null)
		{
			instance = new UnitOfWork();
		}
		return instance;
	}
	/**
	 *  Iterates through the DomainObjects that are registeredDirty, registeredNew, and registeredRemoved
	 *        and commit the changes to the database. After the changes have been done, the registeredDirty,registeredNew
	 *        registeredRemoved maps are cleaned.This method reduces the number of times the application has to access the database.
	 * @throws MapperException 
	 * @throws LostUpdateException 
	 * @throws CommitUnitOfWorkException 
	 * @throws SQLException 
	 */
	public void commit() throws LostUpdateException, MapperException, CommitUnitOfWorkException, SQLException{
		if (executionEnvironment == ExecutionEnvironment.Testing){
			registeredNew.clear();
			registeredDirty.clear();
			registeredRemoved.clear();
			return;
		}
		boolean result = true; 
		Iterator<KeyValuePair<O, BaseOutputMapper<O>>> keysIterator = registeredNew.iterator();
		while(keysIterator.hasNext()){
			KeyValuePair<O, BaseOutputMapper<O>> object = keysIterator.next();
			result = object.getValue().insert(object.getKey());
		}
		registeredNew.clear();
		if (!result) throw new CommitUnitOfWorkException();
		keysIterator = registeredDirty.iterator();
		while(keysIterator.hasNext()){
			KeyValuePair<O, BaseOutputMapper<O>> object = keysIterator.next();
			object.getValue().update(object.getKey());
		}
		registeredDirty.clear();
		
		keysIterator = registeredRemoved.iterator();
		while(keysIterator.hasNext()){
			KeyValuePair<O, BaseOutputMapper<O>> object = keysIterator.next();
			object.getValue().remove(object.getKey());
		}
		registeredRemoved.clear();
		DbRegistry.commit();
	}
	/**
	 *  Adds a DomainObject and its specific OutputMapper to the registeredDirty map.
	 *        DomainObjects that are registered dirty are objects that have been changed from
	 *        what was originally loaded from the database.
	 * @param object any object that extends DomainObject
	 */
	public void RegisterDirty(O object){
		BaseOutputMapper<O> mapper = (BaseOutputMapper<O>) MapperRepository.getOutputMapper(object.getClass());
		registeredDirty.add(new KeyValuePair<O, BaseOutputMapper<O>>(object, mapper));
	}
	/**
	 *  Adds a DomainObject and its specific OutputMapper to the registerNew map.
	 *        DomainObjects that are registered new are objects that doesn't exist in the
	 *        database yet.
	 * @param object any object that extends DomainObject.
	 */
	public void RegisterNew(O object){
		BaseOutputMapper<O> mapper = (BaseOutputMapper<O>) MapperRepository.getOutputMapper(object.getClass());
		registeredNew.add(new KeyValuePair<O, BaseOutputMapper<O>>(object, mapper));
	}
	/**
	 *  Adds a DomainObject ands its specific OutputMapper to the registeredRemoved map.
	 *        DomainObjects that are registered removed are to be removed form the database.
	 * @param object any object that extends DomainObject.
	 */
	public void RegisterRemoved(O object){
		BaseOutputMapper<O> mapper = (BaseOutputMapper<O>) MapperRepository.getOutputMapper(object.getClass());
		registeredRemoved.add(new KeyValuePair<O, BaseOutputMapper<O>>(object, mapper));
	}
}
