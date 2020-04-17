package br.com.danielmarsili.dto;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import br.com.danielmarsili.exception.InvalidFieldsException;
import br.com.danielmarsili.exception.MissingFieldsException;
import br.com.danielmarsili.model.Car;
import br.com.danielmarsili.util.Validator;
import lombok.Data;


/**
 * Instantiates a new car DTO.
 */
@Data
public class CarDTO {

	/** The car id. */
	private Long carId;
	
	/** The year. */
	private Integer year;
	
	/** The license plate. */
	private String licensePlate;
	
	/** The model. */
	private String model;
	
	/** The color. */
	private String color;
	
	/**
	 * Convert entity.
	 *
	 * @param car the car
	 * @return the car
	 */
	public static Car convertEntity(CarDTO car) {
		validateMissingFields(car);
		validateInvalidFields(car);
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		return mapper.map(car, Car.class);
	}
	
	/**
	 * Check missing fields list.
	 *
	 * @param cars the cars
	 */
	public static void validateFieldsList(List<CarDTO> cars) {
		for (CarDTO car : cars) {
			validateMissingFields(car);
		}
	}

	/**
	 * Check missing filds.
	 *
	 * @param car the car
	 */
	private static void validateMissingFields(CarDTO car) {
		if (StringUtils.isEmpty(car.getColor()) || StringUtils.isEmpty(car.getLicensePlate())
				|| StringUtils.isEmpty(car.getModel())) {
			throw new MissingFieldsException();
		}
	}

	/**
	 * Check invalid fields list.
	 *
	 * @param cars the cars
	 */
	public static void validateInvalidFieldsList(List<CarDTO> cars) {
		for (CarDTO car : cars) {
			validateInvalidFields(car);
		}
	}

	/**
	 * Check invalid fields.
	 *
	 * @param car the car
	 */
	private static void validateInvalidFields(CarDTO car) {
		if (!Validator.licensePlateIsValid(car.getLicensePlate()) || car.getYear() < 1) {
			throw new InvalidFieldsException();
		}
	}
}
