package com.example.demo.Topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring","Spring Framework","Spring Framework Description"),
            new Topic("Java","Java Framework","Java Framework Description"),
            new Topic("Javascript","Javascript Framework","Javascript Framework Description"),
            new Topic("Golang","Golang Framework","Golang Framework Description")
    ));

    public  List<Topic> getAllTopics(){
        return topics;
    }

    public Topic getTopic(String topicId){
        return topics.stream().filter(t -> t.getId().equals(topicId)).findFirst().get();
    }

    public void addTopic(Topic newTopic){
        topics.add(newTopic);
    }

    public void updateTopic(String topicId,Topic newTopic) {
       for(int i=0;i < topics.size(); i++){
           Topic t = topics.get(i);

           if(t.getId().equals(topicId)){
               topics.set(i,newTopic);
               return;
           }
       }
    }

    public void deleteTopic(String topicId){
        topics.removeIf(t -> t.getId().equals(topicId));
    }
}
