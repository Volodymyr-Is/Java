package org.example;

public class Course {
    private int id;
    private String name;
    private String description;
    private int maxStudents;

    public Course(int id, String name, String description, int maxStudents) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.maxStudents = maxStudents;
    }

    public Course(String name, String description, int maxStudents) {
        this.name = name;
        this.description = description;
        this.maxStudents = maxStudents;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    @Override
    public String toString() {
        return "Курс ID: " + id + ", Назва: " + name + ", Опис: " + description + ", Макс. студентів: " + maxStudents;
    }

}
