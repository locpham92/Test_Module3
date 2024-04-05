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
</head>
<body>
<a href="http://localhost:8080/staff?action=home">Add</a>
<h1>Add new employee</h1>
<form method="post" action="http://localhost:8080/products?action=add">
    Name
    <input type="text" name="name" placeholder="Enter name">
    Email
    <input type="text" name="email" placeholder="Enter email">
    Phone Number
    <input type="text" name="phonenumber" placeholder="Enter phone number">
    Salary
    <input type="text" name="salary" placeholder="Enter salary">
    Department
    <select name="department" placeholder="Open this select menu">
        <option value="RnD"></option>
        <option value="Sale"></option>
        <option value="Technical"></option>
        <option value="HR"></option>
    </select>
    <button type="submit">Submit</button>
</form>
</form>
</body>
</html>
