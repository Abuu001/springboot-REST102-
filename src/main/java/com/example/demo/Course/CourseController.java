package com.example.demo.Course;

import com.example.demo.Topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/topics")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable("topicId") String id){

        return courseService.getAllCourses(id);
    }

    @GetMapping(path = "/{topicId}/courses/{courseId}")
    public Optional<Course> getCourse(@PathVariable("courseId") String topic){

        return courseService.getCourse(topic);
    }

    @PostMapping("/add/{topicId}/courses")
    public void addCourse(@PathVariable("topicId") String topicId,
                          @RequestBody Course course){
        course.setTopic(new Topic(topicId,"",""));
        courseService.addCourse(course);
    }

    @PutMapping("/update/{topicId}/courses/{id}")
    public void updateCourse(
                           @PathVariable("id") String id,
                           @PathVariable String topicId,
                           @RequestBody Course course){
        course.setTopic(new Topic(topicId,"",""));
        courseService.updateCourse(course);
    }

    @DeleteMapping("/delete/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String topicId){

        courseService.deleteCourse(topicId);
    }
}
