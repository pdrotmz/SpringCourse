package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            	Student Pedro = new Student(
				1L,
				"Pedro",
				"pedrotomaz@gmail.com",
				LocalDate.of(2003, Month.FEBRUARY, 03)
			);

			Student Gabi = new Student(
				2L,
				"Gabi",
				"gabi@gmail.com",
				LocalDate.of(2003, Month.MARCH, 07)
			);

            // Save Student
            repository.saveAll(
                List.of(Pedro, Gabi)
            );
        };
    }
}
