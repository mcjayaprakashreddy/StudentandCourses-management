package com.raviinfotech.springstudentcrud.util;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;
@Data
public class ResponseStructureCourse <T> {
	
	private String msg;
	private int statusCode;
	private List<T> data;
	private LocalDateTime dateTime = LocalDateTime.now();

}
