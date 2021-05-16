package com.example.demo.Hello.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/topics")
public class CourseController {

    @Autowired
    private TopicService topicService;

    @GetMapping("alltopics")
    public List<Course> getAllTopics(){
        return topicService.getAllTopics();
    }

    @GetMapping(path = "/topic/{topicId}")
    public Optional<Course> getTopic(@PathVariable("topicId") String topic){
        return topicService.getTopic(topic);
    }

    @PostMapping("/add/topic")
    public void addTopic(@RequestBody Course newTopic){
        topicService.addTopic(newTopic);
    }

    @PutMapping("/update/{topicId}")
    public void updateTopic(
                           @PathVariable String topicId,
                           @RequestBody Course newTopic){
        topicService.updateTopic(topicId,newTopic);
    }

    @DeleteMapping("/delete/{topicId}")
    public void deleteTopic(@PathVariable String topicId){
        topicService.deleteTopic(topicId);
    }
}
