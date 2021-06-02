package com.example.demo;

import com.example.demo.Teacher.Teacher;
import com.example.demo.Teacher.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springboot102Application {

	public static void main(String[] args) {

		SpringApplication.run(Springboot102Application.class, args);
	} 

	/*@Bean
	CommandLineRunner commandLineRunne(TeacherRepository teacherRepo){
		return args -> {
			Teacher t1= new Teacher(
					"Maria",
					"Leah",
					"maria@teachers.edu",
					33
			);

			teacherRepo.save(t1);
		};
	}*/
}
