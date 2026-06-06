package com.education.analyzer.service;

import com.education.analyzer.model.Topic;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PDFAnalysisService {

    public List<Topic> extractTopics(File pdfFile) {

        List<Topic> topics = new ArrayList<>();

        try {

            PDDocument document = PDDocument.load(pdfFile);

            PDFTextStripper stripper = new PDFTextStripper();

            String text = stripper.getText(document);

            document.close();

            String[] lines = text.split("\\r?\\n");

            boolean foundIndex = false;

            for (String line : lines) {

                line = line.trim();

                if (line.toLowerCase().contains("topics covered")) {
                    foundIndex = true;
                    continue;
                }

                if (foundIndex) {

                    if (line.isEmpty())
                        break;

                    Topic topic = new Topic(line);
                    topics.add(topic);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return topics;
    }

}