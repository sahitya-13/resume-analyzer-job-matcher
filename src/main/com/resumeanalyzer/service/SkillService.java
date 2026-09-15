package com.resumeanalyzer.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SkillService {

    private final Set<String> skills = new HashSet<>(Arrays.asList(
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
    ));

    public Set<String> findSkills(String resumeText) {

        Set<String> foundSkills = new HashSet<>();

        if (resumeText == null) {
            return foundSkills;
        }

        String text = resumeText.toLowerCase();

        for (String skill : skills) {
            if (text.contains(skill.toLowerCase())) {
                foundSkills.add(skill);
            }
        }

        return foundSkills;
    }
}
