package com.example.fumblevore_gaming.mastercasproject;

public class Task {
    private String name;
    private String description;
    private String subject;
    private String priority;
    private String date;


    public Task(String name, String subject, String description, String priority, String date) {
        this.name = name;
        this.description = description;
        this.subject = subject;
        this.priority = priority;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSubject() {
        return subject;
    }

    public String getPriority() {
        return priority;
    }

    public String getDate() {
        return date;
    }
}
