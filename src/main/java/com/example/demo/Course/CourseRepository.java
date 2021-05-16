package com.example.demo.Course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,String> {

    public List<Course> findByTopicId(String topicId);

    public List<Course> findByName(String name);

    public List<Course> findByDescription(String description);

}
