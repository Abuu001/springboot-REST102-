package com.example.demo.Student;

import javassist.NotFoundException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {


    @Mock private StudentRepository studentRepository;
    private StudentService studentServiceTest;

    @BeforeEach
    void setUp() {
      studentServiceTest = new StudentService(studentRepository);
    }


    @Test
    void canGetAllStudents() {
        //when
        studentServiceTest.getStudents();
        //then
        verify(studentRepository).findAll();
    }

    @Test
    void canAddNewStudent() {
        //given
        Student student = new Student(
                "Jamila",
                "jmla@gmail.com",
                LocalDate.of(2000,1,9)
        );

        //when
        studentServiceTest.addNewStudent(student);
        //then
        ArgumentCaptor<Student> studentArgumentCaptor =ArgumentCaptor.forClass(Student.class);
        verify(studentRepository).save(studentArgumentCaptor.capture());

        Student capturedStudent = studentArgumentCaptor.getValue();

        assertThat(capturedStudent).isEqualTo(student);
    }

   /* @Test
     void willThrowWhenEmailIsTaken() {
        //given
        Student student = new Student(
                "Jamila",
                "jmla@gmail.com",
                LocalDate.of(2000,1,9)
        );

        String email2 ="jmla@gmail.com";
        given(studentRepository.findStudentByEmail(student.getEmail()))
                .willReturn(email2);

        //when
        //then
        assertThatThrownBy(()->studentServiceTest.addNewStudent(student))
                                .isInstanceOf(IllegalStateException.class)
                                .hasMessageContaining("Email "+ student.getEmail() +" is taken");

        verify(studentRepository,never()).save(any());
    }
*/
    @Test
    @Disabled
    void deleteStudent() {

    }

    @Test
    @Disabled
    void updateStudent() {
    }
}