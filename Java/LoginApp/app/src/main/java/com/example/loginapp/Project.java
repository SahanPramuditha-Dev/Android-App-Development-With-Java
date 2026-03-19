package com.example.loginapp;

public class Project {
    private String title;
    private String description;
    private String tech;
    private String githubUrl;

    public Project(String title, String description, String tech, String githubUrl) {
        this.title = title;
        this.description = description;
        this.tech = tech;
        this.githubUrl = githubUrl;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getTech() { return tech; }
    public String getGithubUrl() { return githubUrl; }
}
