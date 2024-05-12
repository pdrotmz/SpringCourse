  /**
     * 
     * This class will have all
     * of the resources for our 
     * API
     * 
     */

package com.example.demo.student;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Spring will recognize this file as a RestController
@RestController
// when we type this after localhost:8080, we will be in the page of data student
@RequestMapping(path = "api/v1/student")
public class StudentController {
  
    // new instance created
    private final StudentService studentService;

    // creating constructor
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("") // url for the function in browser, empty means default as an index
	public List<Student> getStudents(){
        return studentService.getStudents();
	}

}
