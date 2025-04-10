package org.example.dz_10_04;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/delete-book")
public class DeleteBookServlet extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
         int id= Integer.parseInt(request.getParameter("id"));
         BookDAO bookDAO =new BookDAO();
         Book book = bookDAO.getById(id);
         if(book !=null)
         {
             request.setAttribute("book", book);
             getServletContext().getRequestDispatcher("/delete.jsp").forward(request,response);
         }
         else
         {
             response.sendRedirect("book-list");
         }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        BookDAO bookDAO =new BookDAO();
        bookDAO.delete(id);
        resp.sendRedirect("book-list");
    }
}