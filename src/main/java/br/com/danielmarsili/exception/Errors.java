package br.com.danielmarsili.exception;


/**
 * The Enum Errors.
 */
public enum Errors {
    
    /** The invalid login. */
    INVALID_LOGIN(1, "Invalid login or password"),
    
    /** The invalid token. */
    INVALID_TOKEN(2, "Unauthorized - invalid session"),
    
    /** The invalid fields. */
    INVALID_FIELDS(3, "Invalid fields."),
    
    /** The missing fields. */
    MISSING_FIELDS(4, "Missing fields."),
    
    /** The user already found. */
    USER_ALREADY_FOUND(5, "Login already exists."),
    
    /** The email already found. */
    EMAIL_ALREADY_FOUND(6, "Email already exists."),
    
    /** The license plate already found. */
    LICENSE_PLATE_ALREADY_FOUND(7, "License plate already exists."),
    
    /** The user not found. */
    USER_NOT_FOUND(8, "User not found."),
    
    /** The car not found. */
    CAR_NOT_FOUND(9, "Car not found for user."),
	
	/** The error upload image. */
	ERROR_UPLOAD_IMAGE(10 , "Error save image"),
	
	/** The error upload convert image. */
	ERROR_UPLOAD_CONVERT_IMAGE(10 , "Error convert image");
    
    
    /** The code. */
    private int code;
    
    /** The message. */
    private String message;
    
    /**
     * Instantiates a new error code.
     *
     * @param code the code
     * @param message the message
     */
    private Errors(int code, String message) {
        this.code = code;
        this.message = message;
    }
    
    /**
     * Gets the code.
     *
     * @return the code
     */
    public int getCode() {
        return code;
    }
    
    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

}
