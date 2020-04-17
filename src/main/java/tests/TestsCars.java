package tests;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.danielmarsili.Application;
import br.com.danielmarsili.controller.CarController;
import br.com.danielmarsili.dto.CarDTO;
import br.com.danielmarsili.dto.UserCreateDTO;
import br.com.danielmarsili.dto.UserDTO;

@SpringBootTest(classes = Application.class)
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class TestsCars {

	@Autowired
	private CarController carController;

	@Test
	public void testCreateCar() {
		//		try {
		//			
		//			assertTrue(carController.createUser(userCreate) != null);
		//		}catch (EmptyResultDataAccessException e) {
		//			assertTrue(e != null); 
		//		}catch (DataNotFoundException e) {
		//			assertTrue(e != null); 
		//		}catch (Exception e) {
		//			assertFalse(e != null); 
		//		}
	}

	@Test
	public void testUpdateUser() {
		//try {
		//			
		//			assertTrue(carController.createUser(userCreate) != null);
		//		}catch (EmptyResultDataAccessException e) {
		//			assertTrue(e != null); 
		//		}catch (DataNotFoundException e) {
		//			assertTrue(e != null); 
		//		}catch (Exception e) {
		//			assertFalse(e != null); 
		//		}
	}

	@Test
	public void testDelete() {
		//try {
		//			
		//			assertTrue(carController.createUser(userCreate) != null);
		//		}catch (EmptyResultDataAccessException e) {
		//			assertTrue(e != null); 
		//		}catch (DataNotFoundException e) {
		//			assertTrue(e != null); 
		//		}catch (Exception e) {
		//			assertFalse(e != null); 
		//		}
	}

	@Test
	public void testGetAllUser() {
		//try {
		//			
		//			assertTrue(carController.createUser(userCreate) != null);
		//		}catch (EmptyResultDataAccessException e) {
		//			assertTrue(e != null); 
		//		}catch (DataNotFoundException e) {
		//			assertTrue(e != null); 
		//		}catch (Exception e) {
		//			assertFalse(e != null); 
		//		}
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
