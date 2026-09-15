package com.resumeanalyzer.controller;

import com.resumeanalyzer.service.JobMatcherService;
import com.resumeanalyzer.service.PdfService;
import com.resumeanalyzer.service.SkillService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet("/analyze")
@MultipartConfig
public class ResumeController extends HttpServlet {

    private final PdfService pdfService = new PdfService();
    private final SkillService skillService = new SkillService();
    private final JobMatcherService jobMatcherService = new JobMatcherService();

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        Part resumePart = request.getPart("resume");

        String jobDescription = request.getParameter("jobDescription");

        byte[] pdfBytes = resumePart.getInputStream().readAllBytes();

        String resumeText = pdfService.extractText(pdfBytes);

        Set<String> resumeSkills =
                skillService.findSkills(resumeText);

        Set<String> jobSkills =
                jobMatcherService.findRequiredSkills(jobDescription);

        Set<String> matchingSkills =
                new HashSet<>(resumeSkills);

        matchingSkills.retainAll(jobSkills);

        Set<String> missingSkills =
                new HashSet<>(jobSkills);

        missingSkills.removeAll(resumeSkills);

        double matchPercentage =
                jobMatcherService.calculateMatchPercentage(
                        resumeSkills,
                        jobSkills
                );

        request.setAttribute("resumeSkills", resumeSkills);
        request.setAttribute("jobSkills", jobSkills);
        request.setAttribute("matchingSkills", matchingSkills);
        request.setAttribute("missingSkills", missingSkills);
        request.setAttribute("matchPercentage",
                String.format("%.2f", matchPercentage));

        request.getRequestDispatcher("result.jsp")
                .forward(request, response);
    }
}
