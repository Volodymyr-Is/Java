<%--
  Created by IntelliJ IDEA.
  User: ws01
  Date: 4/8/2025
  Time: 7:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Delete Book</title>
</head>
<body>
<p>Title: ${book.title}</p>
<p>Author: ${book.author}</p>
<p>Genre: ${book.genre}</p>
<p>Year: ${book.year}</p>
<p>Price: ${book.price}</p>
<form action="delete-book" method="post">
    <input type="hidden" name="id" value="${book.id}"/>
    <input type="submit" value="Delete"/>
</form>
</body>
</html>
