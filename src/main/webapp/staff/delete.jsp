<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 4/5/2024
  Time: 7:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><DELETE</title>
    <link rel="stylesheet" href="staff/home.css">
</head>
<body>
<a href="http://localhost:8080/staff?action=home">HOME</a>
<h2>Do you want to remove staff with ID:</h2>
<form method="post" action="http://localhost:8080/staff?action=delete">
    ID: <input type="number" name="id" value="${idDelete}" readonly>
    <button type="submit" class="btn">Yes</button>
    <a class="btn" href="http://localhost:8080/staff?action=home">No</a>
</form>
</body>
</html>
