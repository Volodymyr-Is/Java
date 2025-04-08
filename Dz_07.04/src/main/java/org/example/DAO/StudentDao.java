package org.example.DAO;

import org.example.HibernateSessionFactoryUtil;
import org.example.Models.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDao implements IStudentDao {
    @Override
    public Student findById(Long id) {
        return HibernateSessionFactoryUtil.getSession().get(Student.class, id);
    }

    @Override
    public void save(Student student) {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.beginTransaction();
        session.persist(student);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Student student) {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.beginTransaction();
        session.merge(student);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Student student) {
        Session session = HibernateSessionFactoryUtil.getSession();
        session.beginTransaction();
        session.remove(student);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Student> findAll() {
        Session session = HibernateSessionFactoryUtil.getSession();
        List<Student> students = session.createQuery("SELECT DISTINCT s FROM Student s LEFT JOIN FETCH s.courses", Student.class).list();
        session.close();
        return students;
    }
}
