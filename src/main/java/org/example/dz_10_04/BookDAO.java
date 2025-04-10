package org.example.dz_10_04;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BookDAO {
    //select * from books
    public List<Book> getAllBooks()
    {
        Session session=HibernateUtil.getSession();
      var books=  session.createQuery("from Book", Book.class).list();
      session.close();
      return  books;
    }
    //select * from books where id=?
    public Book getById(int id)
    {
        Session session=HibernateUtil.getSession();
       var p= session.get(Book.class,id);
       session.close();
       return p;
    }
    //insert into...
    public void add(Book book)
    {
        Transaction transaction=null;
        try(Session session=HibernateUtil.getSession())
        {
            session.beginTransaction();
            session.save(book);
            transaction.commit();
        }
        catch (Exception ex)
        {
            if(transaction!=null)
                transaction.rollback();
        }
    }
    public void update(Book book)
    {
        Transaction transaction=null;
        try(Session session=HibernateUtil.getSession())
        {
            transaction=   session.beginTransaction();
            session.update(book);
            transaction.commit();
        }
        catch (Exception ex)
        {
            if(transaction!=null)
                transaction.rollback();
        }
    }
    public void delete(int id)
    {
        Transaction transaction=null;
        try(Session session=HibernateUtil.getSession())
        {
           Book book =session.get(Book.class,id);
            if(book !=null)
            {
                transaction= session.beginTransaction();
                session.delete(book);
                transaction.commit();
            }

        }
        catch (Exception ex)
        {
            if(transaction!=null)
                transaction.rollback();
        }
    }

    public List<Book> findBooks(String searchQuery){
        Session session = HibernateUtil.getSession();
        List<Book> books = session.createQuery("from Book where title like '"+searchQuery+"' or author like '"+searchQuery+"'").list();

        session.close();
        return books;
    }
}
