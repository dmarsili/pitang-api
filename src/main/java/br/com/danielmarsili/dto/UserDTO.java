package br.com.danielmarsili.dto;

import java.util.Date;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import br.com.danielmarsili.model.Car;
import br.com.danielmarsili.model.User;
import br.com.danielmarsili.util.ApplicationUtils;
import lombok.Data;


/**
 * Instantiates a new user DTO.
 */
@Data
public class UserDTO {

	/** The user id. */
	private Long userId;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The email. */
	private String email;
	
	/** The birthday. */
	private Date birthday;
	
	/** The login. */
	private String login;
	
	/** The phone. */
	private String phone;
	
	/** The cars. */
	private List<CarDTO> cars;

	/**
	 * Convert entity.
	 *
	 * @param dto the dto
	 * @return the user
	 */
	public static User convertEntity(UserDTO dto) {
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		User user = mapper.map(dto, User.class);
		user.setCars(ApplicationUtils.mapBeans(dto.getCars(), Car.class));
		return user;
	}
}
