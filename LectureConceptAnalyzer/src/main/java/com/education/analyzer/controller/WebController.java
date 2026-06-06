package com.education.analyzer.controller;

import com.education.analyzer.model.Topic;
import com.education.analyzer.service.PDFAnalysisService;
import com.education.analyzer.service.RevisionEngine;
import com.education.analyzer.util.ReportGenerator;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AppController {

    @FXML
    private VBox topicsContainer;

    @FXML
    private TextArea reportArea;

    private List<Topic> topics = new ArrayList<>();

    private PDFAnalysisService pdfService = new PDFAnalysisService();

    @FXML
    public void handleUpload() {

        FileChooser chooser = new FileChooser();

        File file = chooser.showOpenDialog(null);

        if (file != null) {

            topics = pdfService.extractTopics(file);

            showTopics();

        }

    }

    private void showTopics() {

        topicsContainer.getChildren().clear();

        for (Topic topic : topics) {

            Label label = new Label(topic.getTopicName());

            ComboBox<Integer> rating = new ComboBox<>();

            rating.getItems().addAll(1,2,3,4,5);

            rating.setOnAction(e ->
                topic.setUnderstandingLevel(rating.getValue())
            );

            VBox box = new VBox(label, rating);

            topicsContainer.getChildren().add(box);

        }

    }

    @FXML
    public void generateReport() {

        RevisionEngine engine = new RevisionEngine();

        engine.analyzeTopics(topics);

        ReportGenerator generator = new ReportGenerator();

        String report = generator.generateReport(topics);

        reportArea.setText(report);

    }

}