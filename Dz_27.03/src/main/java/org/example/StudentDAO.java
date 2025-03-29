package org.example;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public void addStudent(Student student) throws SQLException, IOException {
        String sql = "INSERT INTO Student (first_name, last_name, birth_date, course_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectorDB.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setDate(3, Date.valueOf(student.getBirthDate()));
            preparedStatement.setInt(4, student.getCourseId());
            preparedStatement.executeUpdate();
        }
    }

    public List<Student> getStudentsByCourse(int courseId) throws SQLException, IOException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Student WHERE course_id = ?";
        try (Connection conn = ConnectorDB.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, courseId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getDate("birth_date").toLocalDate(),
                        rs.getInt("course_id")
                ));
            }
        }
        return students;
    }

    public void removeStudentFromCourse(int studentId) throws SQLException, IOException {
        String sql = "UPDATE Student SET course_id = NULL WHERE id = ?";
        try (Connection conn = ConnectorDB.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, studentId);
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Студента успішно видалено з курсу.");
            } else {
                System.out.println("Студента з таким ID не знайдено.");
            }
        }
    }

    public List<Course> getCoursesByStudent(int studentId) throws SQLException, IOException {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT c.id, c.name, c.description, c.max_students FROM Course c " +
                "JOIN Student s ON c.id = s.course_id WHERE s.id = ?";
        try (Connection conn = ConnectorDB.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, studentId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                courses.add(new Course(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("max_students")
                ));
            }
        }
        return courses;
    }
}

