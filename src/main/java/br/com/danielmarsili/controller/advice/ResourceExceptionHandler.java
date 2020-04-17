package br.com.danielmarsili.controller.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.danielmarsili.exception.DataExistsException;
import br.com.danielmarsili.exception.DataNotFoundException;
import br.com.danielmarsili.exception.Errors;
import br.com.danielmarsili.exception.InvalidFieldsException;
import br.com.danielmarsili.exception.MissingFieldsException;


/**
 * The Class ResourceExceptionHandler.
 */
@ControllerAdvice
public class ResourceExceptionHandler {

    /**
     * Data already found.
     *
     * @param e the e
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler(DataExistsException.class)
    public ResponseEntity<StandardError> dataAlreadyFound(DataExistsException e, HttpServletRequest request) {
        StandardError err = new StandardError(e.getCode(), e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
    }
    
    /**
     * Data not found.
     *
     * @param e the e
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<StandardError> dataNotFound(DataNotFoundException e, HttpServletRequest request) {
        StandardError err = new StandardError(e.getCode(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
    
    /**
     * Invalid fields.
     *
     * @param e the e
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler(InvalidFieldsException.class)
    public ResponseEntity<StandardError> invalidFields(InvalidFieldsException e, HttpServletRequest request) {
        StandardError err = new StandardError(e.getCode(), e.getMessage());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
    }
    
    /**
     * Missing field.
     *
     * @param e the e
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler(MissingFieldsException.class)
    public ResponseEntity<StandardError> missingField(MissingFieldsException e, HttpServletRequest request) {
        StandardError err = new StandardError(e.getCode(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
    
    /**
     * Unauthorized.
     *
     * @param e the e
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<StandardError> unauthorized(BadCredentialsException e, HttpServletRequest request) {
        StandardError err = new StandardError(Errors.INVALID_LOGIN.getCode(), Errors.INVALID_LOGIN.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
    }
}
