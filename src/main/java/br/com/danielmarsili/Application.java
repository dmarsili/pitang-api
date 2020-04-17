package br.com.danielmarsili;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * The Class Application.
 */
@SpringBootApplication
@ComponentScan(basePackages = "br.com.danielmarsili.controller, br.com.danielmarsili.service, br.com.danielmarsili.security")
@EnableJpaRepositories("br.com.danielmarsili.repository")
@EntityScan("br.com.danielmarsili.model")   
@EnableSwagger2
public class Application {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
}
