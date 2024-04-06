<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 4/5/2024
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="home.css">
</head>
<body>
<a href="http://localhost:8080/staff?action=add">Add</a>
<div class="search">
    <div class="searchbox">
        <input type="text" name="search" placeholder="Search...">
    </div>
    <button type="button" class="btn">Search</button>
</div>
<table border="1">
    <tr>
        <td>#</td>
        <td>Name</td>
        <td>Email</td>
        <td>Adress</td>
        <td>PhoneNumber</td>
        <td>Salary</td>
        <td>Department</td>
        <td colspan="2">Action</td>
    </tr>
    <c:forEach var="item" items="${staffList}">
    <tr>
        <td>${item.id}</td>
        <td>${item.name}</td>
        <td>${item.email}</td>
        <td>${item.address}</td>
        <td>${item.phoneNumber}</td>
        <td>${item.salary}</td>
        <td>${item.department.name}</td>
        <td><button class="btn"><a href="http://localhost:8080/staff?action=edit&idEdit=${item.id}">Edit</a></button></td>
        <td><button class="btn"><a href="http://localhost:8080/staff?action=delete&idDelete=${item.id}">Delete</a></button></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
