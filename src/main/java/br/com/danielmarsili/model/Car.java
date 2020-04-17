package br.com.danielmarsili.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Instantiates a new car.
 */
@NoArgsConstructor

/**
 * Instantiates a new car.
 *
 * @param carId the car id
 * @param year the year
 * @param licensePlate the license plate
 * @param model the model
 * @param color the color
 * @param user the user
 * @param photoDirectory the photo directory
 */
@AllArgsConstructor

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Data
@Entity
public class Car implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The car id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer carId;
	
	/** The year. */
	private Integer year;
	
	/** The license plate. */
	private String licensePlate;
	
	/** The model. */
	private String model;
	
	/** The color. */
	private String color;

	/** The user. */
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;

}
