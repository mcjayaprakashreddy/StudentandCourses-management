package com.raviinfotech.springstudentcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.raviinfotech.springstudentcrud.dto.Course;
import com.raviinfotech.springstudentcrud.exception.CourseIdNotFound;
import com.raviinfotech.springstudentcrud.service.CourseService;
import com.raviinfotech.springstudentcrud.util.ResponseStructure;
import com.raviinfotech.springstudentcrud.util.ResponseStructureCourse;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class CourseController {
	@Autowired
	private CourseService service;
	
	@PostMapping("/saveCourse")
	public ResponseEntity<ResponseStructureCourse<List<Course>>> saveCourse(@RequestBody List<Course> course) {
		return service.saveCourse(course);
	}
	
	@GetMapping("/fetchAllCourses")
	public ResponseEntity<ResponseStructure<List<Course>>> fetchAllCourses() throws CourseIdNotFound {
	    return service.findAllCourses();
	}
	

}
