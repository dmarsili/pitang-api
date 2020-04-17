package br.com.danielmarsili.service;

import java.util.List;

import br.com.danielmarsili.model.User;

public interface UserService {

	public List<User> getAllUsers();

	public User saveUser(User user);

	public User findUserById(Integer id);

	public User updateUser(Integer id, User user);

	public void deleteUser(Integer id);

	public User findByLogin(String login);

	public void saveLastLogin(String login);

}
