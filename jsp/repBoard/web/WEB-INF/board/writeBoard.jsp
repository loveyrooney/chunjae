<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-18
  Time: 오전 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>repBoard - writeBoard</title>
    <link rel="stylesheet" href="css/writeBoard.css">
</head>
<body>
    <form method="post" action="writeResult.do">
        <ul>
            <li>
                <label for="title">제목</label>
                <input type="text" name="title" id="title">
            </li>
            <li>
                <label for="content">내용</label>
                <textarea rows="3" cols="30" name="content" id="content"></textarea>
            </li>
            <li>
                <button type="submit">등록</button>
                <button type="reset">취소</button>
            </li>
        </ul>
    </form>
</body>
</html>
