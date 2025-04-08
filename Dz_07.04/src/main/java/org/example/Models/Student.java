package org.example.Models;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<>();

    public Student() {}

    public Student(String name) {
        this.name = name;
    }

    public void enrollInCourse(Course course) {
        courses.add(course);
        course.getStudents().add(this);
    }

    public String getName() {
        return name;
    }

    public Set<Course> getCourses() {
        return courses;
    }
}

