package org.example.DAO;

import org.example.Models.Student;

import java.util.List;

public interface IStudentDao {
    Student findById(Long id);
    void save(Student student);
    void update(Student student);
    void delete(Student student);
    List<Student> findAll();
}
