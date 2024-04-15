<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-15
  Time: 오전 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<form method="post" action="login_result.do">
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
            <button type="submit">login</button>
        </li>
    </ul>
</form>
</body>
</html>
