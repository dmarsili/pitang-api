package br.com.danielmarsili.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.danielmarsili.dto.UserCreateDTO;
import br.com.danielmarsili.dto.UserDTO;
import br.com.danielmarsili.model.User;
import br.com.danielmarsili.service.UserService;
import br.com.danielmarsili.util.ApplicationUtils;
import io.swagger.annotations.Api;


/**
 * The Class UserController.
 */
@RestController
@RequestMapping("users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(value = "User")
public class UserController {

	/** The user service. */
	private UserService userService;

	/**
	 * User service.
	 *
	 * @param userService the user service
	 */
	@Autowired
	public void userService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
	@GetMapping
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		return ResponseEntity.ok(ApplicationUtils.mapBeans(userService.getAllUsers(), UserDTO.class));
	}

	/**
	 * Creates the user.
	 *
	 * @param userDTO the user DTO
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<UserDTO> createUser(@RequestBody UserCreateDTO userDTO) {
		User user = UserCreateDTO.convertDTOToUser(userDTO);
		return ResponseEntity.ok(ApplicationUtils.mapBean(userService.saveUser(user), UserDTO.class));
	}

	/**
	 * Gets the user.
	 *
	 * @param id the id
	 * @return the user
	 */
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable("id") Integer id) {
		User user = userService.findUserById(id);
		return ResponseEntity.ok(ApplicationUtils.mapBean(user, UserDTO.class));
	}

	/**
	 * Delete user.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}

	/**
	 * Save user.
	 *
	 * @param id the id
	 * @param userDto the user dto
	 * @return the response entity
	 */
	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> saveUser(@PathVariable("id") Integer id, @RequestBody UserDTO userDto) {
		User user = userService.updateUser(id, UserDTO.convertEntity(userDto));
		return ResponseEntity.ok(ApplicationUtils.mapBean(user, UserDTO.class));

	}

}
