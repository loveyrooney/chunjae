<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-05-07
  Time: 오후 1:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="/result4">
        <ul>
            <li>
                <label for="name">이름</label>
                <input type="text" name="name" id="name"/>
            </li>
            <li>
                <label for="age">나이</label>
                <input type="text" name="age" id="age">
            </li>
            <li>
                <label for="addr">주소</label>
                <input type="text" name="addr" id="addr">
            </li>
            <li>
                <button type="submit">전송</button>
                <button type="reset">취소</button>
            </li>
        </ul>
    </form>
</body>
</html>
