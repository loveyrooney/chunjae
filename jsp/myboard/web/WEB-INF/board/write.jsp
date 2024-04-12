<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-12
  Time: 오전 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/write.css">
</head>
<body>
<a href="list">HOME</a>
<form method="post" action="insert">
    <label for="title">제목</label>
    <input type="text" name="title" id="title" required>
    <label for="writer">작성자</label>
    <input type="text" name="writer" id="writer" required>
    <textarea name="content" rows="5" cols="50"></textarea><br>
    <button type="submit">등록</button>
</form>
</body>
</html>
