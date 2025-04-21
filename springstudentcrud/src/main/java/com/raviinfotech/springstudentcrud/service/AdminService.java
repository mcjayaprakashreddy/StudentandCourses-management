package com.raviinfotech.springstudentcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.raviinfotech.springstudentcrud.dao.AdminDao;
import com.raviinfotech.springstudentcrud.dto.Admin;
import com.raviinfotech.springstudentcrud.dto.Course;
import com.raviinfotech.springstudentcrud.dto.Student;
import com.raviinfotech.springstudentcrud.exception.IdNotFound;
import com.raviinfotech.springstudentcrud.util.ResponseStructure;
import com.raviinfotech.springstudentcrud.util.ResponseStructureAdmin;
import com.raviinfotech.springstudentcrud.util.ResponseStructureCourse;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao; 

ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
	
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		structure.setData(adminDao.saveAdmin(admin));
		structure.setMsg("data saved");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Admin>> adminLogin(String adminEmail, String adminPassword) {
	    Admin admin = adminDao.adminLogin(adminEmail,adminPassword);

	    if (admin != null) {
	        if (admin.getAdminPassword().equals(adminPassword)) { 
	            ResponseStructure<Admin> structure = new ResponseStructure<>();
	            structure.setData(admin);
	            structure.setMsg("Login successful");
	            structure.setStatusCode(HttpStatus.OK.value());
	  
	            return new ResponseEntity<>(structure, HttpStatus.OK);
	        } else {
	            throw new IdNotFound("Invalid password"); 
	        }
	    } else {
	        throw new IdNotFound("admin email not present"); 
	    }
	}
}
