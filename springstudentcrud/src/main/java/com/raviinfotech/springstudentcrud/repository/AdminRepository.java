package com.raviinfotech.springstudentcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.raviinfotech.springstudentcrud.dto.Admin;
import com.raviinfotech.springstudentcrud.dto.Student;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	@Query("select u from Admin u where u.adminEmail=?1 and u.adminPassword=?2")
	Admin login(String adminEmail, String adminPassword);

	

}
