package com.resumeanalyzer.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/analyze")
public class ResumeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.getWriter().println("Resume Analyzer is running!");
    }

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        response.getWriter().println("<h1>Resume Analyzer</h1>");
        response.getWriter().println("<p>Resume analysis started.</p>");
    }
}
