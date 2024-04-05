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
</head>
<body>
<a href="http://localhost:8080/products?action=home">HOME</a>
<h1>Do you want to delete staff information with id: </h1>
Product Id: <input type="number" name="id" placeholder="ID" value="${idDelete}" readonly>
<button><a href="http://localhost:8080/products?action=delete">Yes</a></button>
<button><a href="http://localhost:8080/products?action=home">No</a></button>
</body>
</html>
