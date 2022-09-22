package com.greatlearning.lab5.service;

import java.util.List;

import com.greatlearning.lab5.entity.Student;


public interface StudentService {
	
	public List<Student> findAll();

	public Student findById(int theId);

	public void save(Student student);

	public void deleteById(int theId);


}
