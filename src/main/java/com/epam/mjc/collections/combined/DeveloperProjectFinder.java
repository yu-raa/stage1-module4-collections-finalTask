package com.epam.mjc.collections.combined;

import java.util.*;
import java.util.stream.Collectors;

public class DeveloperProjectFinder {
    public List<String> findDeveloperProject(Map<String, Set<String>> projects, String developer) {
        List<String> projectsOfDev = new LinkedList<>();
        for (Map.Entry<String, Set<String>> project : projects.entrySet()) {
            if (project.getValue().contains(developer)) {
                projectsOfDev.add(project.getKey());
            }
        }

        return projectsOfDev.stream().sorted(new ProjectComparator()).collect(Collectors.toList());
    }
}

class ProjectComparator implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return str2.length() - str1.length();
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str2.charAt(i) - str1.charAt(i);
            }
        }

        return 0;
    }
}
