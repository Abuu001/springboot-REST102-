package com.example.demo.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("alltopics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    @GetMapping(path = "/topic/{topicId}")
    public Topic getTopic(@PathVariable("topicId") String topic){
        return topicService.getTopic(topic);
    }

    @PostMapping("/add/topic")
    public void addTopic(@RequestBody Topic newTopic){
        topicService.addTopic(newTopic);
    }

    @PutMapping("/update/{topicId}")
    public void updateTopic(
                           @PathVariable String topicId,
                           @RequestBody Topic newTopic){
        topicService.updateTopic(topicId,newTopic);
    }

    @DeleteMapping("/delete/{topicId}")
    public void deleteTopic(@PathVariable String topicId){
        topicService.deleteTopic(topicId);
    }
}
