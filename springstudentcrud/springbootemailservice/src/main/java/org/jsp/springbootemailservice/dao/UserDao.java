package org.jsp.springbootemailservice.dao;

import org.jsp.springbootemailservice.dto.User;
import org.jsp.springbootemailservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private UserRepository repository;
	
	public User saveUser(User user) {
		return repository.save(user);
	}
	
	public User login(String emailId) {
		return repository.login(emailId);
	}

}
