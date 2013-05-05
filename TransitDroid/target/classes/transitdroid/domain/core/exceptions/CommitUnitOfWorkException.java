package transitdroid.domain.core.exceptions;

/**
 * 
 * @author TransitDroid Team
 * @class CommitUnitOfWorkException
 *  This class extends RuntimeException and throws an exception if there was 
 *        an error committing to the database through the UOW.
 *
 */
public class CommitUnitOfWorkException extends Exception {

	private static final long serialVersionUID = 615978497674630437L;
	private Exception innerException;
	private String message = "";
	
	public CommitUnitOfWorkException(Exception e){
		innerException = e;
	}
	public CommitUnitOfWorkException(){}
	
	public CommitUnitOfWorkException(String msg){
		this.message = msg;
	}
	public String getMessage(){
		if (innerException != null){
		return "CommitUnitOfWorkException: An error occured in the Unit of Work - " +
	super.getMessage() + " : " +innerException.getMessage() + " : " + this.message;
		}
		else {
			return "CommitUnitOfWorkException: An error occured in the Unit of Work : " +  this.message +
					" : " +	super.getMessage() ;
		}
	}
	
	public void appendMessage(String msg){
		this.message += msg;
	}
}
