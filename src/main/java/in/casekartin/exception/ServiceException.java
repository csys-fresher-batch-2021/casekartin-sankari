package in.casekartin.exception;

public class ServiceException extends Exception {

	public ServiceException(String message, NumberException e) {
		super(message,e);
	}

	public ServiceException(String message, Exception e) {
		super(message,e);
	}

}
