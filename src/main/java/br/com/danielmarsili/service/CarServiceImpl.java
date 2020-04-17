package br.com.danielmarsili.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.danielmarsili.exception.DataExistsException;
import br.com.danielmarsili.exception.DataNotFoundException;
import br.com.danielmarsili.exception.Errors;
import br.com.danielmarsili.model.Car;
import br.com.danielmarsili.model.User;
import br.com.danielmarsili.repository.CarRepository;
import br.com.danielmarsili.repository.UserRepository;

@Service
@Transactional
public class CarServiceImpl implements CarService {

	private CarRepository carRepository;
	private UserRepository userRepository;

	@Autowired
	public CarServiceImpl(CarRepository carRepository, UserRepository userRepository) {
		this.carRepository = carRepository;
		this.userRepository = userRepository;
	}

	@Override
	public List<Car> getAllCarsByUser(String login) {
		User user = findUserByLogin(login);
		return carRepository.findByUser(user);
	}

	@Override
	public Car saveCarByUser(String login, Car car) {
		User user = findUserByLogin(login);
		checkExistLicensePlate(car);
		car.setUser(user);
		return carRepository.save(car);
	}

	@Override
	public Car findByCarIdAndUser(Integer id, String login) {
		User user = findUserByLogin(login);
		return findCarByIdAndUser(id, user);
	}

	@Override
	public Car updateCarByIdAndUser(Integer id, Car newCar, String login) {
		User user = findUserByLogin(login);
		Car car = findCarByIdAndUser(id, user);
		car.setLicensePlate(newCar.getLicensePlate());
		car.setColor(newCar.getColor());
		car.setYear(car.getYear());
		car.setModel(newCar.getModel());
		return carRepository.save(car);
	}

	@Override
	public void deleteCarByIdAndUser(Integer id, String login) {
		User user = findUserByLogin(login);
		user.getCars().removeIf(c -> c.getCarId().equals(id));
		Car car = findCarByIdAndUser(id, user);
		carRepository.delete(car);
	}

	@Override
	public Car findByLicensePlate(String licensePlate) {
		return carRepository.findByLicensePlate(licensePlate);
	}

	private void checkExistLicensePlate(Car car) {
		if (findByLicensePlate(car.getLicensePlate()) != null) {
			throw new DataExistsException(Errors.LICENSE_PLATE_ALREADY_FOUND);
		}
	}

	private User findUserByLogin(String login) {
		User user = userRepository.findByLogin(login);
		if (user == null) {
			throw new DataNotFoundException(Errors.USER_NOT_FOUND);
		}
		return user;
	}

	private Car findCarByIdAndUser(Integer id, User user) {
		Car car = carRepository.findByCarIdAndUser(id, user);
		if (car == null) {
			throw new DataNotFoundException(Errors.CAR_NOT_FOUND);
		}
		return car;
	}
}
