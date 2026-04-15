//Yonatan Rubin
//M21105076

/**
 * needed an exception class for if the code does not consist of only . or -
 */
public class InvalidCodeException extends RuntimeException {
	public InvalidCodeException(String message) {
		super(message);
	}
}