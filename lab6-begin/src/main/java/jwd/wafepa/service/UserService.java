package jwd.wafepa.service;

import java.util.List;

import jwd.wafepa.model.User;

public interface UserService {

	User findOne(Long id);
	List<User> findAll();
	User save(User user);
	void remove(Long id) throws IllegalArgumentException;
}
