<%--
  Created by IntelliJ IDEA.
  User: ws01
  Date: 4/8/2025
  Time: 6:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="create.jsp">Add New Book</a>

<form method="get" action="book-list">
    <input type="text" name="search" placeholder="Search by title or author"
           value="${search != null ? search : ''}" />
    <button type="submit">Search</button>
</form>

<table border="2">
    <tr>
        <td>ID</td>
        <td>Title</td>
        <td>Author</td>
        <td>Genre</td>
        <td>Year</td>
        <td>Price</td>
        <td>Actions</td>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.genre}</td>
            <td>${book.year}</td>
            <td>${book.price}</td>
            <td>
                <a href="edit-book?id=${book.id}">Edit</a>
                <a href="delete-book?id=${book.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
