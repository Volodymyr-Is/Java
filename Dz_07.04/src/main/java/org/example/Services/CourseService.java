package org.example.Services;

import org.example.DAO.CourseDao;
import org.example.DAO.ICourseDao;
import org.example.Models.Course;

import java.util.List;

public class CourseService {
    private final ICourseDao courseDao = new CourseDao();

    public Course findById(Long id) {
        return courseDao.findById(id);
    }

    public void saveCourse(Course course) {
        courseDao.save(course);
    }

    public void updateCourse(Course course) {
        courseDao.update(course);
    }

    public void deleteCourse(Course course) {
        courseDao.delete(course);
    }

    public List<Course> findAllCourses() {
        return courseDao.findAll();
    }
}