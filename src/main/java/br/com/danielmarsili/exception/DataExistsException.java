package br.com.danielmarsili.exception;

/**
 * The Class DataExistsException.
 */
public class DataExistsException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The code. */
	private final int code;

	/**
	 * Instantiates a new data already found exception.
	 *
	 * @param msg the msg
	 * @param code the code
	 */
	public DataExistsException(String msg, int code) {
		super(msg);
		this.code = code;
	}

	/**
	 * Instantiates a new data already found exception.
	 *
	 * @param msg the msg
	 * @param cause the cause
	 * @param code the code
	 */
	public DataExistsException(String msg, Throwable cause, int code) {
		super(msg, cause);
		this.code = code;
	}
	
	/**
	 * Instantiates a new data already found exception.
	 *
	 * @param errorCode the error code
	 */
	public DataExistsException(Errors errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }
	
	/**
	 * Instantiates a new data already found exception.
	 *
	 * @param msg the msg
	 * @param errorCode the error code
	 */
	public DataExistsException(String msg, Errors errorCode) {
	    super(msg);
	    this.code = errorCode.getCode();
	}
	
	/**
	 * Instantiates a new data already found exception.
	 *
	 * @param msg the msg
	 * @param cause the cause
	 * @param errorCode the error code
	 */
	public DataExistsException(String msg, Throwable cause, Errors errorCode) {
        super(msg, cause);
        this.code = errorCode.getCode();
    }
	
	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public int getCode() {
        return code;
    }

}
