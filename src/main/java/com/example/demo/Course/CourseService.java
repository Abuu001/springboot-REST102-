package com.example.demo.Hello.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService{

    @Autowired
    private TopicRepository topicRepository;

    private List<Course> topics = new ArrayList<>(Arrays.asList(
            new Course("spring","Spring Framework","Spring Framework Description"),
            new Course("Java","Java Framework","Java Framework Description"),
            new Course("Javascript","Javascript Framework","Javascript Framework Description"),
            new Course("Golang","Golang Framework","Golang Framework Description")
    ));

    public  List<Course> getAllTopics(){
      //  return topics;
        List<Course> topics =new ArrayList<>();
         topicRepository.findAll()
                .forEach(topics::add);

         return  topics;
    }

    public Optional<Course> getTopic(String topicId){
       // return topics.stream().filter(t -> t.getId().equals(topicId)).findFirst().get();
        return topicRepository.findById(topicId);
    }

    public void addTopic(Course newTopic){
      //  topics.add(newTopic);

        topicRepository.save(newTopic);
    }

    public void updateTopic(String topicId, Course newTopic) {
    /*
       for(int i=0;i < topics.size(); i++){
           Topic t = topics.get(i);

           if(t.getId().equals(topicId)){
               topics.set(i,newTopic);
               return;
           }
       }
    */

      topicRepository.save(newTopic);
    }

    public void deleteTopic(String topicId){
       // topics.removeIf(t -> t.getId().equals(topicId));
        topicRepository.deleteById(topicId);
    }
}
