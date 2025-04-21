package com.raviinfotech.springstudentcrud.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.raviinfotech.springstudentcrud.dao.CourseDao;
import com.raviinfotech.springstudentcrud.dao.StudentDao;
import com.raviinfotech.springstudentcrud.dto.Course;
import com.raviinfotech.springstudentcrud.dto.Student;
import com.raviinfotech.springstudentcrud.exception.CourseIdNotFound;
import com.raviinfotech.springstudentcrud.exception.IdNotFound;
import com.raviinfotech.springstudentcrud.repository.CourseRepository;
import com.raviinfotech.springstudentcrud.util.ResponseStructure;
import com.raviinfotech.springstudentcrud.util.ResponseStructureCourse;

@Service
public class CourseService {
    @Autowired
    private CourseDao dao;
    
    @Autowired
	private CourseRepository courseRepository;

    private ResponseStructureCourse<List<Course>> structure = new ResponseStructureCourse<>();

    public ResponseEntity<ResponseStructureCourse<List<Course>>> saveCourse(List<Course> course) {
        List<Course> list = dao.saveCourse(course);
        structure.setData(list);
        structure.setMsg("Course saved successfully");
        structure.setStatusCode(HttpStatus.CREATED.value());
        return new ResponseEntity<>(structure, HttpStatus.CREATED);
    }
    
    public ResponseEntity<ResponseStructure<List<Course>>> findAllCourses() throws CourseIdNotFound {
    	ResponseStructure<List<Course>> structure = new ResponseStructure<>();
	    List<Course> courses = courseRepository.findAll();
	    
	    if (courses!=null) {
	        structure.setData(courses);
	        structure.setMsg("All courses fetched successfully");
	        structure.setStatusCode(HttpStatus.OK.value());
	        return new ResponseEntity<>(structure, HttpStatus.OK);
	    } else {
	        throw new CourseIdNotFound("No courses found");
	    }
	}
}
