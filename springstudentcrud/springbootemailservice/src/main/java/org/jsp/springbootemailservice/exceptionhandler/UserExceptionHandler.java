package org.jsp.springbootemailservice.exceptionhandler;

import org.jsp.springbootemailservice.exception.EmailNotFound;
import org.jsp.springbootemailservice.exception.PasswordInvalid;
import org.jsp.springbootemailservice.exception.UserIdNotFound;
import org.jsp.springbootemailservice.util.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {
	ResponseStructure<String> structure = new ResponseStructure<String>();
	
	@ExceptionHandler(UserIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> idNotFound(UserIdNotFound userIdNotFound) {
		
		structure.setData(userIdNotFound.getMessage());
		structure.setMsg("user id not present");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(EmailNotFound.class)
	public ResponseEntity<ResponseStructure<String>> emailIdNotFound(EmailNotFound emailNotFound) {
		structure.setData(emailNotFound.getMessage());
		structure.setMsg("loging failed");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PasswordInvalid.class)
	public ResponseEntity<ResponseStructure<String>> passwordInvalid(PasswordInvalid passwordInvalid) {
		structure.setData(passwordInvalid.getMessage());
		structure.setMsg("loging failed");
		structure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_ACCEPTABLE);
	}
	
	
	
	
	
	
	

	
}
