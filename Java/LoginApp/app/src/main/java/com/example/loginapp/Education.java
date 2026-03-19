package com.example.loginapp;

public class Education {
    private String institution;
    private String duration;
    private String degree;
    private String description;

    public Education(String institution, String duration, String degree, String description) {
        this.institution = institution;
        this.duration = duration;
        this.degree = degree;
        this.description = description;
    }

    public String getInstitution() { return institution; }
    public String getDuration() { return duration; }
    public String getDegree() { return degree; }
    public String getDescription() { return description; }
}
