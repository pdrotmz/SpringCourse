  /**
     * 
     * This class will have all
     * of the resources for our 
     * API
     * 
     */

package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Spring will recognize this file as a RestController
@RestController
// when we type this after localhost:8080, we will be in the page of data student
@RequestMapping(path = "api/v1/student")
public class StudentController {
  
    // new instance created
    private final StudentService studentService;

    // creating constructor
    @Autowired // Basically StudenService will inject on studentService
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping // url for the function in browser, empty means default as an index
	public List<Student> getStudents(){
        return studentService.getStudents();
	}

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
                        studentService.updateStudent(studentId, name, email);
                              }
}
