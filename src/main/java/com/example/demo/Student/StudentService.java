package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
     return  studentRepository.findAll();
    }

    public void addNewStudent(Student newStudent) {

        //to find whether email exists
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(newStudent.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("Email taken");
        }

        studentRepository.save(newStudent);
        System.out.println(newStudent);
    }

    public void deleteStudent(Long studentId) {

        boolean exists = studentRepository.existsById(studentId);

        if(!exists){
            throw new IllegalStateException("student with id "+studentId + " does not exists");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student =studentRepository.findById(studentId)
                .orElseThrow(()-> new IllegalStateException("student with id "+studentId + " does not exists"));
//        !Object.equals(student.getName(),name)
        if(name !=null && name.length() >0 && student.getName()!= name ){
            student.setName(name);
        }


        if(email !=null && email.length() >0 && student.getEmail()!= email ){
            student.setEmail(email);
        }

        Optional<Student> studentOptional=studentRepository
                .findStudentByEmail(email);

        if(studentOptional.isPresent()){
            throw new IllegalStateException("Email is taken") ;
        }

        student.setEmail(email);
    }
}
