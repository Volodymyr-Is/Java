package org.example.dz_10_04;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/edit-book")
public class EditBookServlet extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id= Integer.parseInt(request.getParameter("id"));
        BookDAO bookDAO =new BookDAO();
        Book book = bookDAO.getById(id);
        if(book !=null)
        {
            request.setAttribute("book", book);
            getServletContext().getRequestDispatcher("/edit.jsp").forward(request,response);
        }
        else
        {
            response.sendRedirect("book-list");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        String title=req.getParameter("title");
        String genre=req.getParameter("genre");
        String author=req.getParameter("author");
        String year=req.getParameter("year");
        int price=Integer.parseInt(req.getParameter("price"));

        Book book =new Book(id,title,genre,author, year, price);
        BookDAO bookDAO =new BookDAO();
        bookDAO.update(book);
        resp.sendRedirect("book-list");
    }
}