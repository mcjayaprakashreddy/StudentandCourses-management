package org.jsp.springbootemailservice.exception;

public class PasswordInvalid extends RuntimeException {

	private  String msg;

	 public PasswordInvalid(String msg) {
		super(msg);
	}
		
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
