package org.jsp.springbootemailservice.service;

import org.jsp.springbootemailservice.dao.UserDao;
import org.jsp.springbootemailservice.dto.User;
import org.jsp.springbootemailservice.exception.EmailNotFound;
import org.jsp.springbootemailservice.exception.PasswordInvalid;
import org.jsp.springbootemailservice.exception.UserIdNotFound;
import org.jsp.springbootemailservice.util.EmailUtil;
import org.jsp.springbootemailservice.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDao dao;
	@Autowired
	private EmailUtil emailUtil;
	
	ResponseStructure<User> structure = new ResponseStructure<User>();
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		structure.setData(dao.saveUser(user));
		structure.setMsg("data saved");
		structure.setStatusCode(HttpStatus.CREATED.value());
		emailUtil.sendEmail(user.getEmailId());
		return new ResponseEntity<ResponseStructure<User>>
		(structure,HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<ResponseStructure<User>> login(User user) {
		User userDb=dao.login(user.getEmailId());
		if(userDb != null) {
			if(userDb.getPassword().equals(user.getPassword())) {
				structure.setData(userDb);
				structure.setMsg("Loging success");
				structure.setStatusCode(HttpStatus.ACCEPTED.value());
				emailUtil.sendEmailForLogin(user.getEmailId());
				return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.ACCEPTED);
			}else {
				throw new PasswordInvalid("Incorrect Password");
			}
		}else {
			throw new EmailNotFound("invalid EmailId");
		}
	}

}
