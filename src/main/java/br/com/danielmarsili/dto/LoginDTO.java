package br.com.danielmarsili.dto;

import lombok.Data;


/**
 * Instantiates a new login DTO.
 */
@Data
public class LoginDTO {
	
	/** The login. */
	private String login;
	
	/** The password. */
	private String password;
	
}
