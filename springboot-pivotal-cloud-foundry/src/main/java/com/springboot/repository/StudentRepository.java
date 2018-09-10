package com.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
	
	Student findByName(String name);

}