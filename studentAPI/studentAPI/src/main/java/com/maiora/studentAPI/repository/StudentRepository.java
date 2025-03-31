package com.maiora.studentAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maiora.studentAPI.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long>{
	
	public List<StudentEntity> findByAgeBetween(int minAge, int maxAge);


	public List<StudentEntity> findBybirthDay(int i);

	
}
