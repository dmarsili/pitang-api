package br.com.danielmarsili.exception;


/**
 * The Class AuthenticationException.
 */
public class AuthenticationException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new authentication exception.
	 *
	 * @param msg the msg
	 */
	public AuthenticationException(String msg) {
		super(msg);
	}

	/**
	 * Instantiates a new authentication exception.
	 *
	 * @param msg the msg
	 * @param cause the cause
	 */
	public AuthenticationException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
