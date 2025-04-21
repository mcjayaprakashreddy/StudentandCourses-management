package com.raviinfotech.springstudentcrud.service;

import java.io.IOException;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.raviinfotech.springstudentcrud.dao.StudentDao;
import com.raviinfotech.springstudentcrud.dto.Course;
import com.raviinfotech.springstudentcrud.dto.Student;
import com.raviinfotech.springstudentcrud.exception.IdNotFound;
import com.raviinfotech.springstudentcrud.util.EmailUtil;
import com.raviinfotech.springstudentcrud.util.ResponseStructure;

@Service
public class StudentService {
	@Autowired
	private StudentDao dao;
	@Autowired
	private EmailUtil emailUtil;
	
	ResponseStructure<Student> structure = new ResponseStructure<Student>();
	
	public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student) {
		structure.setData(dao.saveStudent(student));
		structure.setMsg("data saved");
		structure.setStatusCode(HttpStatus.CREATED.value());
		emailUtil.sendEmailAccountConfirmation(student.getEmail());
		return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Student>> findStudentByid(int id) {
		Student studentdb=dao.findStudentById(id);
		if(studentdb != null) {
			structure.setData(studentdb);
			structure.setMsg("student id found");
			structure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.FOUND);
		}else {
			throw new IdNotFound("Student id not present");
		}
	}
	
	public ResponseEntity<ResponseStructure<Student>> 
	uploadImage(int id,MultipartFile file) throws IOException {
		Student studentdb=dao.findStudentById(id);
		if(studentdb != null) {
			studentdb.setId(id);
			studentdb.setImg(file.getBytes());
			structure.setData(dao.updateStudent(studentdb));
			structure.setMsg("Image Uploaded");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.ACCEPTED);
		}else {
			throw new IdNotFound("Student Id Not found");
		}
	}
	public ResponseEntity<byte[]> fetchImage(int id) {
		Student studentdb=dao.findStudentById(id);
		if(studentdb != null) {
			byte[] img=studentdb.getImg();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_PNG);
//			headers.setContentType(MediaType.IMAGE_JPEG);
			return new ResponseEntity<byte[]>(img,headers,HttpStatus.FOUND);
		}else {
			throw new IdNotFound("Student Id Not found");
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Student>> addCourseToStudent(int sid,int cid) {
		Student studentDb=dao.addCourseToStudent(sid, cid);
		if(studentDb != null) {
			structure.setData(studentDb);
			structure.setMsg("Course Added");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.ACCEPTED);
		}else {
			throw new IdNotFound("Student Id Not found");
		}
	}
	
	
	public ResponseEntity<ResponseStructure<List<Course>>> fetchCoursesFromStudent(int id){
		Student studentdb=dao.findStudentById(id);
		if(studentdb!=null) {
			ResponseStructure<List<Course>> structure=new ResponseStructure<>();
			List<Course> courses=studentdb.getCourse();
			structure.setData(courses);
			structure.setMsg("courses found");
			structure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Course>>>(structure,HttpStatus.FOUND);		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<Student>> deleteCourseFromStudent(int sid,int cid){
		Student studentdb=dao.findStudentById(sid);
		if(studentdb!=null) {
			List<Course> listCourses=studentdb.getCourse();
			for (Course course : listCourses) {
				if(course.getCid()==cid) {
					listCourses.remove(course);
					studentdb.setCourse(listCourses);
					
					structure.setData(dao.saveStudent(studentdb));
					structure.setMsg("course removed");
					structure.setStatusCode(HttpStatus.OK.value());
					return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.OK);
					
				}
			}
		}
		 throw new IdNotFound("not found");
	}
	
	
	public ResponseEntity<ResponseStructure<Student>> studentLogin(String email, String password) {
	    Student studentdb = dao.studentLogin(email);
	    
	    if (studentdb != null) {
	        if (studentdb.getPassword().equals(password)) { // Check if password matches
	            ResponseStructure<Student> structure = new ResponseStructure<>();
	            structure.setData(studentdb);
	            structure.setMsg("Login successful");
	            structure.setStatusCode(HttpStatus.OK.value());
	            
	            return new ResponseEntity<>(structure, HttpStatus.OK);
	        } else {
	            throw new IdNotFound("Invalid password"); // Throw error if password is incorrect
	        }
	    } else {
	        throw new IdNotFound("Student email not present"); // Throw error if email is not found
	    }
	}

	public ResponseEntity<ResponseStructure<Student>> deleteStudentById(int id) {
		Student studentdb=dao.findStudentById(id);
		if(studentdb!=null) {
			dao.deleteStudentById(studentdb);
			ResponseStructure<Student> structure =new ResponseStructure<Student>();
			structure.setData(studentdb);
			structure.setMsg("deleted Student record successfully");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.OK);	
		}else {
			   throw new com.raviinfotech.springstudentcrud.exception.StudentIdNotFound("Student id is not found");
		}
 }

	public ResponseEntity<ResponseStructure<Student>> updateStudent(Student student) {
		Student studentDb=dao.findStudentById(student.getId());
		if(studentDb!=null) {
			ResponseStructure<Student> structure =new ResponseStructure<Student>();
			structure.setData(dao.saveStudent(student));
			
			structure.setMsg("updated Student record successfully");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.ACCEPTED);
		}else {
			throw new com.raviinfotech.springstudentcrud.exception.StudentIdNotFound("Student Id Not Present");		
			}
	}
	

}
