package com.resumeanalyzer.service;

public class ResumeService {

    public String analyzeResume(String resumeText) {

        if (resumeText == null || resumeText.trim().isEmpty()) {
            return "No resume text provided.";
        }

        return "Resume received successfully.";
    }
}
