<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-15
  Time: 오전 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<form method="post" action="join_result.jsp">
    <ul>
        <li>
            <label for="id">id</label>
            <input type="text" name="id" id="id" required>
        </li>
        <li>
            <label for="pwd">pwd</label>
            <input type="password" name="pwd" id="pwd" required>
        </li>
        <li>
            <label for="name">name</label>
            <input type="text" name="name" id="name">
        </li>
        <li>
            <button type="submit">join</button>
            <button type="reset">reset</button>
        </li>
    </ul>
</form>
</body>
</html>
