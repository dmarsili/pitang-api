package br.com.danielmarsili.exception;


/**
 * The Class DataNotFoundException.
 */
public class DataNotFoundException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The code. */
	private final int code;

	/**
	 * Instantiates a new data not found exception.
	 *
	 * @param msg the msg
	 */
	public DataNotFoundException(String msg, int code) {
		super(msg);
		this.code = code;
	}

	/**
	 * Instantiates a new data not found exception.
	 *
	 * @param msg the msg
	 * @param cause the cause
	 */
	public DataNotFoundException(String msg, Throwable cause, int code) {
		super(msg, cause);
		this.code = code;
	}
	
	/**
	 * Instantiates a new data not found exception.
	 *
	 * @param errorCode the error code
	 */
	public DataNotFoundException(Errors errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }
	
	/**
	 * Instantiates a new data not found exception.
	 *
	 * @param msg the msg
	 * @param errorCode the error code
	 */
	public DataNotFoundException(String msg, Errors errorCode) {
	    super(msg);
	    this.code = errorCode.getCode();
	}
	
	/**
	 * Instantiates a new data not found exception.
	 *
	 * @param msg the msg
	 * @param cause the cause
	 * @param errorCode the error code
	 */
	public DataNotFoundException(String msg, Throwable cause, Errors errorCode) {
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
