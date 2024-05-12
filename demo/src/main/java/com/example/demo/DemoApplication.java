package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController // Spring recognize that DemoApplication is a RestController
public class DemoApplication {


	// Basically this is the main file of project
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("") // url for the function in browser, empty means default as an index
	public List<String> hello(){
		return List.of("Hello", "World");
	}

}
