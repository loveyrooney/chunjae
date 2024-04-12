<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-12
  Time: 오전 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="list">HOME</a>
<form method="post" action="update">
  <input type="text" name="boardno" value="${requestScope.board.boardno}" hidden>
  <label for="title">제목</label>
  <input type="text" name="title" id="title" value="${board.title}"required>
  <label for="writer">작성자</label>
  <input type="text" name="writer" id="writer" value="${board.writer}" readonly>
  <textarea name="content" rows="5" cols="50">${board.content}</textarea><br>
  <button type="submit">수정</button>
</form>
</body>
</html>
