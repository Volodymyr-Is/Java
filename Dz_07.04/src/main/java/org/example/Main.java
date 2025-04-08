package org.example;

import org.example.Models.Course;
import org.example.Models.Student;
import org.example.Services.CourseService;
import org.example.Services.StudentService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();


//        Course math = new Course("Math", 5);
//        Course programming = new Course("Programming", 6);
//        courseService.saveCourse(math);
//        courseService.saveCourse(programming);
//
//        Course mathFromDb = courseService.findById(math.getId());
//        Course programmingFromDb = courseService.findById(programming.getId());
//
//        Student bob = new Student("Bob");
//        Student john = new Student("John");
//        studentService.saveStudent(bob);
//        studentService.saveStudent(john);
//
//        studentService.enrollStudentInCourse(bob, mathFromDb);
//        studentService.enrollStudentInCourse(bob, programmingFromDb);
//        studentService.enrollStudentInCourse(john, mathFromDb);


        List<Student> allStudents = studentService.findAllStudents();
        System.out.println("Student List:");
        for (Student student : allStudents) {
            System.out.println(student.getName() + ":");
            for (Course c : student.getCourses()) {
                System.out.println("- " + c.getTitle() + " (" + c.getCredits() + " credits)");
            }
        }

//        List<Course> allCourses = courseService.findAllCourses();
//        System.out.println("\nCourse List:");
//        for (Course course : allCourses) {
//            System.out.println(course.getTitle() + ":");
//            for (Student s : course.getStudents()) {
//                System.out.println("- " + s.getName());
//            }
//        }
    }
}