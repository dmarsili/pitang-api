package br.com.danielmarsili.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.danielmarsili.dto.CarDTO;
import br.com.danielmarsili.model.Car;
import br.com.danielmarsili.service.CarService;
import br.com.danielmarsili.util.ApplicationUtils;
import io.swagger.annotations.Api;


/**
 * The Class CarController.
 */
@RestController
@RequestMapping("cars")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(value = "Car")
public class CarController {

	/** The car service. */
	private CarService carService;

	/**
	 * User service.
	 *
	 * @param carService the car service
	 */
	@Autowired
	public void userService(CarService carService) {
		this.carService = carService;
	}

	/**
	 * Gets the all cars logged user.
	 *
	 * @param authentication the authentication
	 * @return the all cars logged user
	 */
	@GetMapping
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<List<CarDTO>> getAllCarsLoggedUser(Authentication authentication) {
		return ResponseEntity.ok(ApplicationUtils.mapBeans(carService.getAllCarsByUser(authentication.getName()), CarDTO.class));
	}

	/**
	 * Creates the car by logged user.
	 *
	 * @param authentication the authentication
	 * @param userDto the user dto
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<CarDTO> createCarByLoggedUser(Authentication authentication, @RequestBody CarDTO userDto) {
		Car car = CarDTO.convertEntity(userDto);
		return ResponseEntity
				.ok(ApplicationUtils.mapBean(carService.saveCarByUser(authentication.getName(), car), CarDTO.class));
	}

	/**
	 * Gets the car by logged user.
	 *
	 * @param authentication the authentication
	 * @param id the id
	 * @return the car by logged user
	 */
	@GetMapping("/{id}")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<CarDTO> getCarByLoggedUser(Authentication authentication, @PathVariable("id") Integer id) {
		Car car = carService.findByCarIdAndUser(id, authentication.getName());
		return ResponseEntity.ok(ApplicationUtils.mapBean(car, CarDTO.class));
	}

	/**
	 * Delete car by logged user.
	 *
	 * @param authentication the authentication
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCarByLoggedUser(Authentication authentication, @PathVariable("id") int id) {
		carService.deleteCarByIdAndUser(id, authentication.getName());
		return ResponseEntity.noContent().build();
	}

	/**
	 * Update car by logged user.
	 *
	 * @param authentication the authentication
	 * @param id the id
	 * @param carDTO the car DTO
	 * @return the response entity
	 */
	@PutMapping("/{id}")
	public ResponseEntity<CarDTO> updateCarByLoggedUser(Authentication authentication, @PathVariable("id") Integer id,
			@RequestBody CarDTO carDTO) {
		Car car = carService.updateCarByIdAndUser(id, CarDTO.convertEntity(carDTO), authentication.getName());
		return ResponseEntity.ok(ApplicationUtils.mapBean(car, CarDTO.class));
	}


}
