<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-11
  Time: 오후 5:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>myboard - detail</title>
    <link rel="stylesheet" href="css/detail.css">
</head>
<body>
<a href="list">HOME</a>
<ul>
  <li>No. ${requestScope.board.boardno} | 작성자 ${board.writer} | 작성일 ${board.writedate} | ${board.readno}</li>
  <li>${board.title}</li>
  <li>${board.content}</li>
</ul>
<a href="mod?id=${board.boardno}">수정</a>
<a href="del?id=${board.boardno}">삭제</a>
</body>
</html>
