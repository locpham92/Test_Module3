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
    <title>ADD</title>
    <link rel="stylesheet" href="staff/home.css">
</head>
<body>
<a href="http://localhost:8080/staff?action=home">HOME</a>
<h1>Add new employee</h1>
<form method="post" action="http://localhost:8080/staff?action=add">
    <h3>Name</h3>
    <input type="text" name="name" placeholder="Enter name">
    <h3>Email</h3>
    <input type="text" name="email" placeholder="Enter email">
    <h3>Address</h3>
    <input type="text" name="address" placeholder="Enter address">
    <h3>Phone Number</h3>
    <input type="text" name="phonenumber" placeholder="Enter phone number">
    <h3>Salary</h3>
    <input type="text" name="salary" placeholder="Enter salary">
    <h3>Department</h3>
    <select name="department">
        <c:forEach var="item" items="${departments}">
        <option value="${item.id}">${item.name}</option>
        </c:forEach>
    </select><br>
    <button type="submit" class="btn">Submit</button>
</form>
</body>
</html>
