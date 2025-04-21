package com.raviinfotech.springstudentcrud.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.raviinfotech.springstudentcrud.dto.Course;
import com.raviinfotech.springstudentcrud.dto.Student;
import com.raviinfotech.springstudentcrud.service.StudentService;
import com.raviinfotech.springstudentcrud.util.ResponseStructure;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
//@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService service;
	
	@PostMapping("/savestudent")
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student) {
		return service.saveStudent(student);
	}
	@GetMapping("/findstudent/{id}")
	public ResponseEntity<ResponseStructure<Student>> findStudentByid(@PathVariable int id) {
		return service.findStudentByid(id);
	}
	@PutMapping("/uploadimage/{id}")
	public ResponseEntity<ResponseStructure<Student>> 
	uploadImage(@PathVariable int id,@RequestParam("file") MultipartFile file) throws IOException {
		return service.uploadImage(id, file);
	}
	@GetMapping("/fetchimg/{id}")
	public ResponseEntity<byte[]> fethImg(@PathVariable int id) {
		return service.fetchImage(id);
	}
	@PutMapping("/addcourse/{sid}/{cid}")
	public ResponseEntity<ResponseStructure<Student>> addCourseToStudent(@PathVariable int sid,@PathVariable int cid) {
		return service.addCourseToStudent(sid, cid);
	}
	@GetMapping("/fetchcourses/{sid}")
	public ResponseEntity<ResponseStructure<List<Course>>> fetchCoursesFromStudent(@PathVariable int sid) {
		return service.fetchCoursesFromStudent(sid);
	}
	@DeleteMapping("/deletcourse/{sid}/{cid}")
	public ResponseEntity<ResponseStructure<Student>> deleteCourseFromStudent(@PathVariable int sid,@PathVariable int cid){
		return service.deleteCourseFromStudent(sid, cid);
	}
	
	@PostMapping("/login")
	public ResponseEntity<ResponseStructure<Student>> studentLogin(@RequestBody Student loginRequest) {
	    return service.studentLogin(loginRequest.getEmail(), loginRequest.getPassword());
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(@PathVariable int id) {
	  return service.deleteStudentById(id);
	}
	
	@PutMapping("/updateStudent")
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestBody Student student) {
		return service.updateStudent(student);
	}




	
	
}
