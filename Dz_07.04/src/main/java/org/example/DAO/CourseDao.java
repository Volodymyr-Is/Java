package org.example.DAO;

import org.example.HibernateSessionFactoryUtil;
import org.example.Models.Course;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CourseDao implements ICourseDao {

    @Override
    public Course findById(Long id) {
        return HibernateSessionFactoryUtil.getSession().get(Course.class, id);
    }

    @Override
    public void save(Course course) {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.beginTransaction();
        session.persist(course);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Course course) {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.beginTransaction();
        session.merge(course);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Course course) {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.beginTransaction();
        session.remove(course);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Course> findAll() {
        Session session = HibernateSessionFactoryUtil.getSession();
        List<Course> courses = session.createQuery("SELECT DISTINCT c FROM Course c LEFT JOIN FETCH c.students", Course.class).list();
        session.close();
        return courses;
    }
}