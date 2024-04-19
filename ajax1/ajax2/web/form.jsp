<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-17
  Time: 오전 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<%--    <script defer src="js/form.js"></script>--%>
<%--    <script defer src="js/form_fetch.js"></script>--%>
    <script defer src="js/form_json.js"></script>
</head>
<body>
<form method="post" name="form">
    <label for="name">이름</label>
    <input type="text" name="name" id="name">
    <label for="age">나이</label>
    <input type="text" name="age" id="age"><br>
    <button type="button" id="btn">전송</button>
</form>
<div id="result"></div>
<ol id="result2"></ol>
</body>
</html>
