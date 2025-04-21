package com.raviinfotech.springstudentcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.raviinfotech.springstudentcrud.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	@Query("select u from Student u where u.email=?1")
	Student login(String email);
}
