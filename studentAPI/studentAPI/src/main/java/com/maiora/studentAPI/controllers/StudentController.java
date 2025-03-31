package com.maiora.studentAPI.controllers;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maiora.studentAPI.entity.StudentEntity;
import com.maiora.studentAPI.repository.StudentRepository;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping
	public List<StudentEntity> getStudents() {
		return studentRepository.findAll();
	}
	
	@PostMapping
	public String createStudent(@RequestBody StudentEntity student) {
		try {
			LocalDate birthdate = LocalDate.of(student.getBirthYear(), student.getBirthMonth(), student.getBirthDay());
			LocalDate today = LocalDate.now();
			student.setAge(Period.between(birthdate, today).getYears());
			System.out.println(student.getId()+" "+student.getName()+" "+student.getAge());
			studentRepository.save(student);
		} catch (Exception e) {
			return "Enter the valid birth date!";
		}
		return null;
	}
	
	@GetMapping("/young")
	public ResponseEntity<List<StudentEntity>> getStudentsByAge() {
		List<StudentEntity> students = studentRepository.findByAgeBetween(18, 25);
		return ResponseEntity.ok(students);
	}
	
}
