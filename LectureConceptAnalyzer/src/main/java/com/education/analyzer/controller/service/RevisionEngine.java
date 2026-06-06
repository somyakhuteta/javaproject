package com.education.analyzer.service;

import com.education.analyzer.model.Topic;

import java.util.List;

public class RevisionEngine {

    public void analyzeTopics(List<Topic> topics) {

        for (Topic topic : topics) {

            int level = topic.getUnderstandingLevel();

            if (level <= 2) {

                topic.setStatus("Missed Concept");

                if (level == 1)
                    topic.setPriority("High");
                else
                    topic.setPriority("Medium");

            }

            else if (level == 3) {

                topic.setStatus("Needs Revision");
                topic.setPriority("Low");

            }

            else {

                topic.setStatus("Clear");
                topic.setPriority("None");

            }

        }

    }

}