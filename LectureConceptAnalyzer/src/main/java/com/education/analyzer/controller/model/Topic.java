package com.education.analyzer.model;

public class Topic {

    private String topicName;
    private int understandingLevel;
    private String status;
    private String priority;

    public Topic(String topicName) {
        this.topicName = topicName;
        this.understandingLevel = 0;
        this.status = "Not Evaluated";
        this.priority = "None";
    }

    public String getTopicName() {
        return topicName;
    }

    public int getUnderstandingLevel() {
        return understandingLevel;
    }

    public void setUnderstandingLevel(int understandingLevel) {
        this.understandingLevel = understandingLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

}