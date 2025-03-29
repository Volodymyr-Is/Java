package org.example;

import org.example.ConnectorDB;
import org.example.Course;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseDAO {
    public void addCourse(Course course) throws SQLException, IOException {
        String sql = "INSERT INTO Course (name, description, max_students) VALUES (?, ?, ?)";
        try (Connection conn = ConnectorDB.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, course.getName());
            preparedStatement.setString(2, course.getDescription());
            preparedStatement.setInt(3, course.getMaxStudents());
            preparedStatement.executeUpdate();
        }
    }

    public Course getCourseById(int id) throws SQLException, IOException {
        String sql = "SELECT * FROM Course WHERE id = ?";
        try (Connection conn = ConnectorDB.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new Course(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("max_students")
                );
            }
        }
        return null;
    }
}