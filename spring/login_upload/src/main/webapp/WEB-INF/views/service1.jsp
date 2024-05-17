<%--
  Created by IntelliJ IDEA.
  User: FULL8-011
  Date: 2024-05-17
  Time: 오전 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/resources/js/logout.js"></script>
</head>
<body>
<h3>only for login user - service1</h3>
<button type="button" name="logout">logout</button>
<hr>
<form method="post" action="/form_result" enctype="multipart/form-data">
    <input type="text" name="fileName" placeholder="file name"><br>
    <input type="file" name="file1" placeholder="file1"><br>
    <button type="submit">전송</button>
</form>
</body>
</html>
