package org.jsp.springbootemailservice.exception;

public class UserIdNotFound extends RuntimeException{

	private String msg;

	public UserIdNotFound(String msg) {
		super(msg);
	}
	@Override
	public String getMessage() {
		return super.getMessage();
	}
	
	
}
