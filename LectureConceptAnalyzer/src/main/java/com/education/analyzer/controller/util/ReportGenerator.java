package com.education.analyzer.util;

import com.education.analyzer.model.Topic;

import java.util.List;

public class ReportGenerator {

    public String generateReport(List<Topic> topics) {

        StringBuilder report = new StringBuilder();

        report.append("MISSED CONCEPTS\n\n");

        for (Topic t : topics) {

            if (t.getStatus().equals("Missed Concept")) {

                report.append("- ")
                        .append(t.getTopicName())
                        .append(" (")
                        .append(t.getPriority())
                        .append(" Priority)\n");
            }

        }

        report.append("\nCLEAR CONCEPTS\n\n");

        for (Topic t : topics) {

            if (t.getStatus().equals("Clear")) {

                report.append("- ")
                        .append(t.getTopicName())
                        .append("\n");

            }

        }

        return report.toString();

    }

}