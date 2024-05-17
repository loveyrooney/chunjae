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
<h3>only for login user - service2</h3>
<button type="button" name="logout">logout</button>
<p>파일 이름 : ${filename}</p>
<p>실제 파일 : <a href="/download/${fname}">${fname}</a></p>
<p>파일 이름 : ${uploadpath}</p>
</body>
</html>
