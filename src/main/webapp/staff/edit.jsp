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
    <title>EDIT</title>
</head>
<body>
<a href="http://localhost:8080/products?action=home">HOME</a>
<h1>Edit: ${idEdit}</h1>
<form method="post" action="http://localhost:8080/products?action=add">
    <input type="text" name="name" value="${staffEdit.name}">
    <input type="text" name="email" value="${staffEdit.email}">
    <input type="text" name="phonenumber" value="${staffEdit.phonenumber}">
    <input type="text" name="salary" value="${staffEdit.salary}">
    <select name="department" value="${staffEdit.department}">
        <option value="RnD"></option>
        <option value="Sale"></option>
        <option value="Technical"></option>
        <option value="HR"></option>
    </select>
    <button type="submit">Submit</button>
</form>
</body>
</html>
