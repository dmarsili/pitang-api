package br.com.danielmarsili.dto;

import org.apache.commons.lang3.StringUtils;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import br.com.danielmarsili.exception.InvalidFieldsException;
import br.com.danielmarsili.exception.MissingFieldsException;
import br.com.danielmarsili.model.Car;
import br.com.danielmarsili.model.User;
import br.com.danielmarsili.util.ApplicationUtils;
import br.com.danielmarsili.util.Validator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


/**
 * Hash code.
 *
 * @return the int
 */
@EqualsAndHashCode(callSuper=false)
public class UserCreateDTO extends UserDTO {

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	@Getter
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	@Setter
	private String password;

	/**
	 * Convert DTO to user.
	 *
	 * @param dto the dto
	 * @return the user
	 */
	public static User convertDTOToUser(UserCreateDTO dto) {
		validateMissingFields(dto);
		validateInvalidFields(dto);
		CarDTO.validateFieldsList(dto.getCars());
		CarDTO.validateInvalidFieldsList(dto.getCars());
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		User user = mapper.map(dto, User.class);
		user.setCars(ApplicationUtils.mapBeans(dto.getCars(), Car.class));
		return user;
	}
	
	/**
	 * Check missing fields.
	 *
	 * @param dto the dto
	 */
	public static void validateMissingFields(UserCreateDTO dto) {
		if (StringUtils.isEmpty(dto.getEmail()) || StringUtils.isEmpty(dto.getFirstName())
				|| StringUtils.isEmpty(dto.getLastName()) || StringUtils.isEmpty(dto.getPassword())
				|| StringUtils.isEmpty(dto.getLogin()) || StringUtils.isEmpty(dto.getPhone())
				|| dto.getBirthday() == null || dto.getCars().isEmpty()) {
			throw new MissingFieldsException();
		}
	}

	/**
	 * Check invalid fields.
	 *
	 * @param dto the dto
	 */
	public static void validateInvalidFields(UserCreateDTO dto) {
		if (!Validator.emailIsValid(dto.getEmail()) || !Validator.phoneIsValid(dto.getPhone())) {
			throw new InvalidFieldsException();
		}
	}
}
