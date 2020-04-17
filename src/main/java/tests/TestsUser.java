package tests;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.danielmarsili.Application;
import br.com.danielmarsili.controller.UserController;
import br.com.danielmarsili.dto.CarDTO;
import br.com.danielmarsili.dto.UserCreateDTO;
import br.com.danielmarsili.dto.UserDTO;
import br.com.danielmarsili.exception.DataNotFoundException;

@SpringBootTest(classes = Application.class)
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class TestsUser {

	@Autowired
	private UserController userController;

	@Test
	public void testCreateUser() {
		try {
			UserDTO user = getUser();
			List<CarDTO> cars = new ArrayList<>();
			cars.add(getCar());
			user.setCars(cars);
			UserCreateDTO userCreate = getUserCreate(user);
			assertTrue(userController.createUser(userCreate) != null);
		}catch (EmptyResultDataAccessException e) {
			assertTrue(e != null); 
		}catch (DataNotFoundException e) {
			assertTrue(e != null); 
		}catch (Exception e) {
			assertFalse(e != null); 
		}
	}

	@Test
	public void testUpdateUser() {
		try {
			UserDTO user = getUser();
			List<CarDTO> cars = new ArrayList<>();
			cars.add(getCar());
			user.setCars(cars);
			assertTrue(userController.saveUser(user.getUserId().intValue(), user) != null);
		}catch (EmptyResultDataAccessException e) {
			assertTrue(e != null); 
		}catch (DataNotFoundException e) {
			assertTrue(e != null); 
		}catch (Exception e) {
			assertFalse(e != null);
		}
	}

	@Test
	public void testDelete() {
		try {
			UserDTO user = getUser();
			assertTrue(userController.deleteUser(user.getUserId().intValue()) != null);
		}catch (EmptyResultDataAccessException e) {
			assertTrue(e != null); 
		}catch (DataNotFoundException e) {
			assertTrue(e != null); 
		}catch (Exception e) {
			assertFalse(e != null);
		}
	}

	@Test
	public void testGetAllUser() {
		try {
			assertTrue(userController.getAllUsers() != null);
		}catch (EmptyResultDataAccessException e) {
			assertTrue(e != null); 
		}catch (DataNotFoundException e) {
			assertTrue(e != null); 
		}catch (Exception e) {
			assertFalse(e != null);
		}
	}

	private CarDTO getCar() {
		CarDTO car = new CarDTO();
		car.setCarId(1L);
		car.setColor("BRANCA");
		car.setYear(2020);
		car.setModel("Mercedez McLaren");
		car.setLicensePlate("ABC-1234");
		return car;

	}

	private UserDTO getUser() {
		UserDTO userDto = new UserDTO();
		userDto.setUserId(1L);
		userDto.setFirstName("Hello");
		userDto.setLastName("World");
		userDto.setBirthday(new Date());
		userDto.setEmail("hello@world.com");
		userDto.setLogin("hello.world");
		userDto.setPhone("1199999999");
		return userDto;
	}

	private UserCreateDTO getUserCreate(UserDTO user) {
		UserCreateDTO userCreateDto = new UserCreateDTO();
		userCreateDto.setUserId(user.getUserId());
		userCreateDto.setFirstName(user.getFirstName());
		userCreateDto.setLastName(user.getLastName());
		userCreateDto.setBirthday(user.getBirthday());
		userCreateDto.setEmail(user.getEmail());
		userCreateDto.setLogin(user.getLogin());
		userCreateDto.setPhone(user.getPhone());
		userCreateDto.setCars(user.getCars());
		userCreateDto.setPassword("123456");
		return userCreateDto;
	}

}
