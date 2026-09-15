# Resume Analyzer and Job Matcher

## Project Description

Resume Analyzer and Job Matcher is a Java-based web application that analyzes a resume and compares the skills in the resume with the skills required for a job.

## Technologies Used

* Java
* Servlets
* JSP
* HTML
* Apache Tomcat
* Apache Maven
* Apache PDFBox
* Git and GitHub

## Features

* Upload a resume in PDF format
* Extract text from the resume
* Identify skills from the resume
* Enter a job description
* Identify required job skills
* Find matching skills
* Find missing skills
* Calculate job match percentage

## Project Structure

```text
resume-analyzer-job-matcher/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/resumeanalyzer/
│       │       ├── ResumeAnalyzerApplication.java
│       │       ├── controller/
│       │       │   └── ResumeController.java
│       │       └── service/
│       │           ├── ResumeService.java
│       │           ├── SkillService.java
│       │           ├── JobMatcherService.java
│       │           └── PdfService.java
│       └── webapp/
│           ├── index.html
│           └── result.jsp
├── pom.xml
├── .gitignore
└── README.md
```

## How It Works

1. User uploads a PDF resume.
2. The application extracts text from the PDF.
3. Resume skills are identified.
4. User enters a job description.
5. Required job skills are identified.
6. Resume skills and job skills are compared.
7. Matching and missing skills are displayed.
8. The job match percentage is calculated.

## Purpose

This project helps job seekers understand how well their resume matches a particular job description and identify skills that may need improvement.
