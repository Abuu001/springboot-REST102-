package com.example.demo.Student;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

/*spring.jpa.properties.hibernate.dialect=org.hibernate.PostgreSQLDialect*/

@Entity //make this class interact with our db
@Table(name = "Student") //you can set the name of ur table by @Table("stud")
@Data
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private  Long id;
    private String name;
    private String email;
    private LocalDate dob;

    @Transient // means that there is no need to create column  for this field to be in our db .we can calc it from dob
    private Integer age;

    public Student() {
    }

    public Student(Long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }


}
