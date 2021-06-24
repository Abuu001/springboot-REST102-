package com.example.demo.Student;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepositoryTest;

    @AfterEach
    void tearDown() {
        log.info("Deleting All Entries");
        studentRepositoryTest.deleteAll();
    }

    @Test
    void itShouldFindStudentByEmail() {
        //given
        String email = "jmla@gmail.com";
        Student student = new Student(
                "Jamila",
                "jmla@gmail.com",
                LocalDate.of(2000,1,9)
        );

        studentRepositoryTest.save(student);
        //when
        Optional<Student> expected = studentRepositoryTest.findStudentByEmail(email);

        //then
        assertThat(expected).isPresent();
    }

    @Test
    void itShouldCheckIfStudentEmailDoesNotExist() {
        //given
        String email = "jmla@gmail.com";

        //when
        Optional<Student> expected = studentRepositoryTest.findStudentByEmail(email);

        //then
        assertThat(expected).isEmpty();
    }
}