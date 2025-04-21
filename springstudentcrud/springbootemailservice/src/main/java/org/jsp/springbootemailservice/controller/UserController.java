package org.jsp.springbootemailservice.controller;

import org.jsp.springbootemailservice.dto.User;
import org.jsp.springbootemailservice.service.UserService;
import org.jsp.springbootemailservice.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping("/saveuser")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	
	@PostMapping("/loginuser")
	public ResponseEntity<ResponseStructure<User>> login(@RequestBody User user) {
		return service.login(user);
	}
	

}
