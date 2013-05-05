package transitdroid.domain.core.exceptions;
/**
 * 
 * @author TransitDroid Team
 * @class MapperRepositoryException
 *  This class extends RuntimeException
 *
 */
public class MapperRepositoryException extends RuntimeException{

	private static final long serialVersionUID = -2348917598377768230L;
	Throwable innerException;
	
	public MapperRepositoryException(Throwable inner){
		innerException = inner;
	}
}
