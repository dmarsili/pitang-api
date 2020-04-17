package br.com.danielmarsili.dto;

import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


/**
 * Hash code.
 *
 * @return the int
 */
@EqualsAndHashCode(callSuper=false)
public class UserMeDTO extends UserDTO {

	/**
	 * Gets the creates the at.
	 *
	 * @return the creates the at
	 */
	@Getter
	
	/**
	 * Sets the creates the at.
	 *
	 * @param createAt the new creates the at
	 */
	@Setter
	private Date createAt;
	
	/**
	 * Gets the last login.
	 *
	 * @return the last login
	 */
	@Getter
	
	/**
	 * Sets the last login.
	 *
	 * @param lastLogin the new last login
	 */
	@Setter
	private Date lastLogin;

}
