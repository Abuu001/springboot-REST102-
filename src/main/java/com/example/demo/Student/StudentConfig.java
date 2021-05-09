package com.example.demo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student kenneth =new Student(
                    "Kenneth",
                    "ken@gmail.com",
                     LocalDate.of(2000, Month.JANUARY,5)

            );

            Student fauziah =new Student(
                    "Fauziah",
                    "fauz@gmail.com",
                     LocalDate.of(1997, Month.JULY,11)
            );

            repository.saveAll(
                    List.of(kenneth,fauziah)
            );

        };
    }
}
