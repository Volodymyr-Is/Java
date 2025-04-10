<%--
  Created by IntelliJ IDEA.
  User: ws01
  Date: 4/8/2025
  Time: 6:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Book</title>
</head>
<body>
<form action="create-book" method="post">
    <div>
        <label for="title">Title</label>
        <input name="title" id="title" required/>
    </div>
    <div>
        <label for="author">Author</label>
        <input name="author" id="author" required/>
    </div>
    <div>
        <label for="genre">Genre</label>
        <input name="genre" id="genre" required/>
    </div>
    <div>
        <label for="year">Year</label>
        <input name="year" id="year" required/>
    </div>
    <div>
        <label for="price">Price</label>
        <input type="number" name="price" id="price" required/>
    </div>
    <input type="submit" value="Create"/>

</form>
</body>
</html>
