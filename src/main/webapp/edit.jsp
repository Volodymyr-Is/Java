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
    <title>Edit Book</title>
</head>
<body>
  <form action="edit-book" method="post">
      <input type="hidden" name="id" value="${book.id}"/>
      <div>
          <label for="title">Title</label>
          <input name="title" id="title" value="${book.title}"/>
      </div>
      <div>
          <label for="author">Author</label>
          <input name="author" id="author" value="${book.author}"/>
      </div>
      <div>
          <label for="genre">Genre</label>
          <input name="genre" id="genre" value="${book.genre}"/>
      </div>
      <div>
          <label for="year">Year</label>
          <input name="year" id="year" value="${book.year}"/>
      </div>
      <div>
          <label for="price">Price</label>
          <input type="number" name="price" id="price" value="${book.price}"/>
      </div>
      <input type="submit" value="Update">
  </form>
</body>
</html>
