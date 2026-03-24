package com.example.tasky;

public class Task {
    private String id;
    private String title;
    private String priority;
    private boolean isCompleted;

    public Task(String id, String title, String priority, boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.isCompleted = isCompleted;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getPriority() { return priority; }
    public boolean isCompleted() { return isCompleted; }
    public void setCompleted(boolean completed) { isCompleted = completed; }
}