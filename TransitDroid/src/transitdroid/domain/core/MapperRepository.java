package transitdroid.domain.core;

import java.util.HashMap;
import java.util.Map;

import transitdroid.domain.core.exceptions.MapperRepositoryException;
/**
 * 
 * @author TransitDroid Team
 * @class MapperRepository
 *  This class is developed to help keep track and manage InputMappers and OutputMappers. Instead of creating an InputMapper and an OutputMapper
 *        for each DomainObject, this Object provides a Map linking DomainObjects from the same category to their InputMapper and OutputMapper.
 * 
 */
public class MapperRepository {
	private static Map<Class<?>, BaseInputMapper<?>> inputMappers = new HashMap<Class<?>, BaseInputMapper<?>>();
	private static Map<Class<?>, BaseOutputMapper<?>> outputMapppers = new HashMap<Class<?>, BaseOutputMapper<?>>();		
	/**
	 *  This method checks if a specific DomainObject's Input Mapper already exists in-memory inside the MapperRepository inputMappers Map. If yes 
	 * 		  then simply load that input Mapper and add the DomainObject to it's list and return the Mapper. If not, then create a new instance of that
	 *        specific DomainObject Input Mapper and add it to the inputMappers Map in MapperRepository, and return the Mapper.
	 * @param objectClass Receives an object of the Type Class (Mother of all classes in java).<?> Here indicates that the Class type is determined
	 *                    Dynamically on runtime.
	 * @return BaseInputMapper<?>
	 */
	public static BaseInputMapper<?> getInputMapper(Class<?> objectClass){
		BaseInputMapper<?> mapper = inputMappers.get(objectClass);
		if (mapper == null){
			try {
				mapper = (BaseInputMapper<?>) Class.forName(objectClass.getName()+"InputMapper").newInstance();
			} catch (InstantiationException  e) {
				throw new MapperRepositoryException(e);
			} catch (IllegalAccessException e) {
				throw new MapperRepositoryException(e);
			} catch (ClassNotFoundException e) {
				throw new MapperRepositoryException(e);
			}
			inputMappers.put(objectClass, mapper);
		}
		return mapper;		
	}
	/**
	 *  This method checks if a specific DomainObject's Output Mapper already exists in-memory inside the MapperRepository outputMappers Map. If yes 
	 * 		  then simply load that output Mapper and add the DomainObject to it's list and return the Mapper. If not, then create a new instance of that
	 *        specific DomainObject output Mapper and add it to the outputMappers Map in MapperRepository, and return the Mapper.
	 * @param objectClass Receives an object of the Type Class (Mother of all classes in java).<?> Here indicates that the Class type is determined
	 *                    Dynamically on runtime.
	 * @return BaseOutputMapper<?>
	 */
	public static BaseOutputMapper<?> getOutputMapper(Class<?> objectClass) {
		BaseOutputMapper<?> mapper = outputMapppers.get(objectClass);
		if (mapper == null){
			try {
				mapper = (BaseOutputMapper<?>) Class.forName(objectClass.getName().replace("Proxy", "")+"OutputMapper").newInstance();
			} catch (InstantiationException e) {
				throw new MapperRepositoryException(e);
			} catch (IllegalAccessException e) {
				throw new MapperRepositoryException(e);
			} catch (ClassNotFoundException e) {
				throw new MapperRepositoryException(e);
			}
			outputMapppers.put(objectClass, mapper);
		}
		return mapper;	
	}
}
