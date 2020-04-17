package br.com.danielmarsili.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.danielmarsili.exception.DataExistsException;
import br.com.danielmarsili.exception.DataNotFoundException;
import br.com.danielmarsili.exception.Errors;
import br.com.danielmarsili.model.Car;
import br.com.danielmarsili.model.User;
import br.com.danielmarsili.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private CarService carService;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, CarService carService) {
		this.userRepository = userRepository;
		this.carService = carService;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User saveUser(User user) {
		validateUser(user);
		validateLicensePlate(user);
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setCreateAt(new Date());
		return userRepository.save(user);
	}

	private void validateUser(User user) {
		if (userRepository.findByLogin(user.getLogin()) != null) {
			throw new DataExistsException(Errors.USER_ALREADY_FOUND);
		}
		if (userRepository.findByEmail(user.getEmail()) != null) {
			throw new DataExistsException(Errors.EMAIL_ALREADY_FOUND);
		}
	}

	private void validateLicensePlate(User user) {
		for (Car car : user.getCars()) {
			if (carService.findByLicensePlate(car.getLicensePlate()) != null) {
				throw new DataExistsException(Errors.LICENSE_PLATE_ALREADY_FOUND);
			} else {
				car.setUser(user);
			}
		}
	}

	@Override
	public User findByLogin(String login) {
		return userRepository.findByLogin(login);
	}

	@Override
	public User findUserById(Integer id) {
		return userRepository.findById(id).orElseThrow(() -> new DataNotFoundException(Errors.USER_NOT_FOUND));
	}

	@Override
	public User updateUser(Integer id, User newUser) {
		User user = userRepository.findById(id).orElseThrow(() -> new DataNotFoundException(Errors.USER_NOT_FOUND));
		user.setFirstName(newUser.getFirstName());
		user.setLastName(newUser.getLastName());
		user.setEmail(newUser.getEmail());
		user.setBirthday(newUser.getBirthday());
		user.setLogin(newUser.getLogin());
		user.setPassword(newUser.getPassword());
		user.setPhone(newUser.getPhone());
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}

	@Override
	public void saveLastLogin(String login) {
		User user = userRepository.findByLogin(login);
		user.setLastLogin(new Date());
		userRepository.saveAndFlush(user);
	}

}
