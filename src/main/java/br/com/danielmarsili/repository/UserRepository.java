package br.com.danielmarsili.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.danielmarsili.model.User;


/**
 * The Interface UserRepository.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	/**
	 * Find by email.
	 *
	 * @param email the email
	 * @return the user
	 */
	public User findByEmail(String email);

	/**
	 * Find by login.
	 *
	 * @param login the login
	 * @return the user
	 */
	public User findByLogin(String login);

}
