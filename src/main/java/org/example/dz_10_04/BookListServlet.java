package org.example.dz_10_04;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/book-list")
public class BookListServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        BookDAO bookDAO = new BookDAO();
        String searchQuery = request.getParameter("search");
        var books = (searchQuery != null && !searchQuery.isEmpty())
                ? bookDAO.findBooks(searchQuery)
                : bookDAO.getAllBooks();

        request.setAttribute("books",books);
        request.setAttribute("search", searchQuery);
        request.getRequestDispatcher("/book-list.jsp").forward(request,response);
    }
}