package com.example.demo.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public  List<Course> getAllCourses(String topicId){

        List<Course> courses =new ArrayList<>();
        courseRepository.findByTopicId(topicId)
                .forEach(courses::add);

         return  courses;
    }

    public Optional<Course> getCourse(String topicId){

        return courseRepository.findById(topicId);
    }

    public void addCourse(Course course){

        courseRepository.save(course);
    }

    public void updateCourse(Course newTopic) {

        courseRepository.save(newTopic);
    }

    public void deleteCourse(String topicId){

        courseRepository.deleteById(topicId);
    }
}
