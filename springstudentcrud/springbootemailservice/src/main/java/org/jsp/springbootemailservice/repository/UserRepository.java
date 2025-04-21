package org.jsp.springbootemailservice.repository;

import org.jsp.springbootemailservice.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("select u from User u where u.emailId=?1")
	public User login(String emailId);
}
