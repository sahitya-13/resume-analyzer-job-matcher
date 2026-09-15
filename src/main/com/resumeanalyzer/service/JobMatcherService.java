package com.resumeanalyzer.service;

import java.util.HashSet;
import java.util.Set;

public class JobMatcherService {

    public Set<String> findRequiredSkills(String jobDescription) {

        Set<String> requiredSkills = new HashSet<>();

        if (jobDescription == null) {
            return requiredSkills;
        }

        String text = jobDescription.toLowerCase();

        String[] skills = {
                "Java",
                "Python",
                "C",
                "C++",
                "SQL",
                "HTML",
                "CSS",
                "JavaScript",
                "Spring",
                "Spring Boot",
                "Hibernate",
                "MySQL",
                "MongoDB",
                "AWS",
                "Git",
                "GitHub",
                "Docker",
                "React",
                "Angular",
                "Data Structures",
                "Algorithms"
        };

        for (String skill : skills) {
            if (text.contains(skill.toLowerCase())) {
                requiredSkills.add(skill);
            }
        }

        return requiredSkills;
    }

    public double calculateMatchPercentage(Set<String> resumeSkills,
                                            Set<String> jobSkills) {

        if (jobSkills == null || jobSkills.isEmpty()) {
            return 0.0;
        }

        Set<String> matchingSkills = new HashSet<>(resumeSkills);
        matchingSkills.retainAll(jobSkills);

        return (matchingSkills.size() * 100.0) / jobSkills.size();
    }
}
