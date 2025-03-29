package org.example;
import java.time.LocalDate;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private int courseId;

    public Student(int id, String firstName, String lastName, LocalDate birthDate, int courseId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.courseId = courseId;
    }

    public Student(String firstName, String lastName, LocalDate birthDate, int courseId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return id + ": " + firstName + " " + lastName + " (" + birthDate + ")";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getCourseId() {
        return courseId;
    }
}
