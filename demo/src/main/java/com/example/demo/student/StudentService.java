package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    	public List<Student> getStudents(){
		return List.of(
			// Creating a new instance of Student
			new Student(
				1L,
				"Pedro",
				"pedrotomaz@gmail.com",
				LocalDate.of(2003, Month.FEBRUARY, 03),
				21
			)
		);
	}
}
