package br.com.danielmarsili.service;

import java.util.List;

import br.com.danielmarsili.model.Car;

public interface CarService {

	public List<Car> getAllCarsByUser(String login);

	public Car saveCarByUser(String login, Car car);

	public Car updateCarByIdAndUser(Integer id, Car car, String login);

	public Car findByLicensePlate(String licensePlate);

	public Car findByCarIdAndUser(Integer id, String login);

	public void deleteCarByIdAndUser(Integer id, String login);

}
