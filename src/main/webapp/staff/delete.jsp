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
<a href="http://localhost:8080/staff?action=home">HOME</a>
<h2>Do you want to remove staff with ID: ${idDelete} </h2>
<form method="post" action="http://localhost:8080/staff?action=delete">
    <button type="submit">Yes</button>
</form>
<button><a href="http://localhost:8080/staff?action=home">No</a></button>
</body>
</html>
