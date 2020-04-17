package br.com.danielmarsili.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * Instantiates a new login response DTO.
 *
 * @param jwttoken the jwttoken
 */
@AllArgsConstructor
public class LoginResponseDTO  {

	/**
	 * Gets the jwttoken.
	 *
	 * @return the jwttoken
	 */
	@Getter
	private String jwttoken;

}
