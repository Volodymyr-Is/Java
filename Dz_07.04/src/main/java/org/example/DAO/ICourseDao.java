package org.example.DAO;

import org.example.Models.Course;

import java.util.List;

public interface ICourseDao {
    Course findById(Long id);
    void save(Course course);
    void update(Course course);
    void delete(Course course);
    List<Course> findAll();
}