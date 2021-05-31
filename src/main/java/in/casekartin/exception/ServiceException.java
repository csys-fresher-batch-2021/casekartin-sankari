package in.casekartin.exception;

public class ServiceException extends Exception {

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, ValidationException e) {
		super(message,e);
	}

}
