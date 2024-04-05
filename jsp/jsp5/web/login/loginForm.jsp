<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-05
  Time: 오후 5:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="login.jsp">
    <label for="id">id</label>
    <input type="text" name="id" id="id" required><br>
    <label for="pwd">pwd</label>
    <input type="password" name="pwd" id="pwd" required><br>
    <button type="submit">로그인</button>
    <button type="reset">리셋</button>
</form>
</body>
</html>
