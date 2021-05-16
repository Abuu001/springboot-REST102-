package com.example.demo.Course;

import com.example.demo.Topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "stud_topics")  //Creates a table studtopics
public class Course {

    @Id
    private String id;
    private String name;
    @Column(name = "stud_description") //@Column is used to rename a column of a table
    private String description;

    @Autowired
    @ManyToOne
    private Topic topic;

    public Course() {
    }

    public Course(String id, String name, String description,Topic topic) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.topic =topic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
