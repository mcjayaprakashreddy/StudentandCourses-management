package com.raviinfotech.springstudentcrud.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.raviinfotech.springstudentcrud.dto.Admin;
import com.raviinfotech.springstudentcrud.dto.Course;
import com.raviinfotech.springstudentcrud.dto.Student;
import com.raviinfotech.springstudentcrud.repository.AdminRepository;
import com.raviinfotech.springstudentcrud.repository.CourseRepository;

@Repository
public class AdminDao {
	@Autowired
	private AdminRepository adminRepository;
	
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	
	public Admin adminLogin(String adminEmail, String adminPassword) {
		return adminRepository.login(adminEmail,adminPassword);
	}

	

}
