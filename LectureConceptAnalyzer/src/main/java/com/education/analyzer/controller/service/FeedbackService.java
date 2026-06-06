package com.education.analyzer.service;

import com.education.analyzer.model.Topic;

public class FeedbackService {

    public void applyFeedback(Topic topic, int rating) {

        topic.setUnderstandingLevel(rating);

    }

}