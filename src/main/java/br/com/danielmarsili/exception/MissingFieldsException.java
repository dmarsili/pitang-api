package br.com.danielmarsili.exception;


/**
 * The Class MissingFieldsException.
 */
public class MissingFieldsException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The code. */
	private final int code;
	
	/**
	 * Instantiates a new missing fields exception.
	 */
	public MissingFieldsException() {
	    this(Errors.MISSING_FIELDS);
	}

	/**
	 * Instantiates a new missing fields exception.
	 *
	 * @param msg the msg
	 */
	public MissingFieldsException(String msg, int code) {
		super(msg);
		this.code = code;
	}

	/**
	 * Instantiates a new missing fields exception.
	 *
	 * @param msg the msg
	 * @param cause the cause
	 */
	public MissingFieldsException(String msg, Throwable cause, int code) {
		super(msg, cause);
		this.code = code;
	}
	
	/**
	 * Instantiates a new missing fields exception.
	 *
	 * @param errorCode the error code
	 */
	public MissingFieldsException(Errors errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }
	
	/**
	 * Instantiates a new missing fields exception.
	 *
	 * @param msg the msg
	 * @param errorCode the error code
	 */
	public MissingFieldsException(String msg, Errors errorCode) {
	    super(msg);
	    this.code = errorCode.getCode();
	}
	
	/**
	 * Instantiates a new missing fields exception.
	 *
	 * @param msg the msg
	 * @param cause the cause
	 * @param errorCode the error code
	 */
	public MissingFieldsException(String msg, Throwable cause, Errors errorCode) {
        super(msg, cause);
        this.code = errorCode.getCode();
    }
	
	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public Integer getCode() {
        return code;
    }

}
