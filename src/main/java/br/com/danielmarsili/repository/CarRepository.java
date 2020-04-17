package br.com.danielmarsili.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.danielmarsili.model.Car;
import br.com.danielmarsili.model.User;


/**
 * The Interface CarRepository.
 */
public interface CarRepository extends JpaRepository<Car, Integer>{
	
	/**
	 * Find by license plate.
	 *
	 * @param licensePlate the license plate
	 * @return the car
	 */
	public Car findByLicensePlate(String licensePlate);
	
	/**
	 * Find by user.
	 *
	 * @param user the user
	 * @return the list
	 */
	public List<Car> findByUser(User user);
	
	/**
	 * Find by car id and user.
	 *
	 * @param id the id
	 * @param user the user
	 * @return the car
	 */
	public Car findByCarIdAndUser(Integer id, User user);
	
}
