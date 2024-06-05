package com.example.demo.student;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private final StudentRepository studentRepository;

	@Autowired
    public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getStudents(){
		// Return what he found
		return studentRepository.findAll();
	}

    public void addNewStudent(Student student) {
		Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
		if (studentOptional.isPresent()) {
			throw new IllegalStateException("Email taken");
		} else {
			studentRepository.save(student);
		}
		
    }

	public void deleteStudent(Long studentId) {
		boolean exists = studentRepository.existsById(studentId);
		if (!exists) {
			throw new IllegalStateException(
				"student with ID " + studentId + "does not exists"
			);
		}
		studentRepository.deleteById(studentId);
	}
	
}
