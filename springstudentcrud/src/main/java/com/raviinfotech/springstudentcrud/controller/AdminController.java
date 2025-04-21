package com.raviinfotech.springstudentcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.raviinfotech.springstudentcrud.dto.Admin;
import com.raviinfotech.springstudentcrud.dto.Course;
import com.raviinfotech.springstudentcrud.dto.Student;
import com.raviinfotech.springstudentcrud.service.AdminService;
import com.raviinfotech.springstudentcrud.util.ResponseStructure;
import com.raviinfotech.springstudentcrud.util.ResponseStructureAdmin;
import com.raviinfotech.springstudentcrud.util.ResponseStructureCourse;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/saveAdmin")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}
	
	@PostMapping("/adminLogin")
	public ResponseEntity<ResponseStructure<Admin>> adminLogin(@RequestBody Admin loginRequest) {
	    return adminService.adminLogin(loginRequest.getAdminEmail(), loginRequest.getAdminPassword());
	}

}
