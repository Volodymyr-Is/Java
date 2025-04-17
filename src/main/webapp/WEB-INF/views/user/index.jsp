<%--
  Created by IntelliJ IDEA.
  User: ws01
  Date: 4/15/2025
  Time: 7:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" action="user/confirm" modelAttribute="user">
    <div>
        <form:label path="username">Username: </form:label>
        <form:input path="username"/>
    </div><br>
    <div>
        <form:label path="password">Password: </form:label>
        <form:input path="password"/>
    </div><br>
    <div>
        <form:label path="city">City of employment: </form:label>
        <form:input path="city"/>
    </div><br>
    <div>
        <form:label path="webServer">Web Server: </form:label>
        <form:select path="webServer" items="${serverList}" />
    </div><br>
    <div>
        <form:label path="role">Please specify your role: </form:label>
        <form:radiobuttons path="role" items="${roleList}" />
    </div><br>
    <div>
        <form:label path="services">Single Sign-on to the following: </form:label>
        <form:checkboxes path="services"  items="${signList}"/>
    </div><br><br>

    <input type="submit" value="Login"/>

</form:form>
</body>
</html>
