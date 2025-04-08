package org.example.Services;

import org.example.DAO.IStudentDao;
import org.example.DAO.StudentDao;
import org.example.Models.Course;
import org.example.Models.Student;

import java.util.List;

public class StudentService {
    private final IStudentDao studentDao = new StudentDao();

    public Student findById(Long id) {
        return studentDao.findById(id);
    }

    public void saveStudent(Student student) {
        studentDao.save(student);
    }

    public void updateStudent(Student student) {
        studentDao.update(student);
    }

    public void deleteStudent(Student student) {
        studentDao.delete(student);
    }

    public List<Student> findAllStudents() {
        return studentDao.findAll();
    }

    public void enrollStudentInCourse(Student student, Course course) {
        student.enrollInCourse(course);
        studentDao.update(student);
    }
}
