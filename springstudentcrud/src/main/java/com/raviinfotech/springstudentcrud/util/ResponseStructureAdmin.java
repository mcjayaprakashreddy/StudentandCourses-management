package com.raviinfotech.springstudentcrud.util;

import java.time.LocalDateTime;
import java.util.List;

import com.raviinfotech.springstudentcrud.dto.Course;

import lombok.Data;
@Data
public class ResponseStructureAdmin<T> {

	private String msg;
	private int statusCode;
	private T data;
	private LocalDateTime dateTime = LocalDateTime.now();
}
