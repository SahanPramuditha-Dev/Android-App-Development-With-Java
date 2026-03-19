package com.example.loginapp;

public class Experience {
    private String role;
    private String company;
    private String duration;
    private String responsibilities;

    public Experience(String role, String company, String duration, String responsibilities) {
        this.role = role;
        this.company = company;
        this.duration = duration;
        this.responsibilities = responsibilities;
    }

    public String getRole() { return role; }
    public String getCompany() { return company; }
    public String getDuration() { return duration; }
    public String getResponsibilities() { return responsibilities; }
}
