package transitdroid.domain.core.exceptions;
/**
 * 
 * @author TransitDroid Team
 * @class ProxyException
 *  This class extends RuntimeException and it throws an exception if there
 *        was a problem identifying or loading a Proxy.
 *
 */
public class ProxyException extends RuntimeException {

	private static final long serialVersionUID = -2348917598377768230L;
		Throwable innerException;
	public ProxyException(Throwable e) {
		innerException = e;
	}

}
