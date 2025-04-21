package com.raviinfotech.springstudentcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raviinfotech.springstudentcrud.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
