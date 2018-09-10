package com.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Student;
import com.springboot.repository.StudentRepository;

@RestController
@RequestMapping("/pivotal")
public class PivotalCloudFoundryController {

	@Autowired
	private StudentRepository repository;

	@GetMapping(value = "{name}")
	public ResponseEntity<Student> fetchStudent(@PathVariable("name") String name) {
		return new ResponseEntity<>(repository.findByName(name), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> insertStudentDetails(@Validated @RequestBody Student student) {
		return new ResponseEntity<>(repository.save(student), HttpStatus.CREATED);
	}
}