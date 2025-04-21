package org.jsp.springbootemailservice.exception;

public class EmailNotFound extends RuntimeException{

	private  String msg;

	public EmailNotFound(String msg) {
	//	super(msg);
		this.msg=msg;
		
	}
	@Override
	public String getMessage() {
	//	return super.getMessage();
		return msg;
	}
	
	
}
