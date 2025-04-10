package org.example.dz_10_04;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/create-book")
public class CreateBookServlet extends HttpServlet {


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String title=request.getParameter("title");
        String genre=request.getParameter("genre");
        String author=request.getParameter("author");
        String year=request.getParameter("year");
        int price=Integer.parseInt(request.getParameter("price"));
        Book book =new Book(title, genre, author, year, price);
        BookDAO bookDAO =new BookDAO();
        bookDAO.add(book);
        response.sendRedirect("book-list");
    }


}