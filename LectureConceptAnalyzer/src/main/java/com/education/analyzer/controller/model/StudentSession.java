package com.education.analyzer.model;

import java.util.ArrayList;
import java.util.List;

public class StudentSession {

    private List<Topic> topics;

    public StudentSession() {
        topics = new ArrayList<>();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public List<Topic> getTopics() {
        return topics;
    }

}