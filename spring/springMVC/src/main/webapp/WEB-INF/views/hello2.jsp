<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-05-07
  Time: 오후 1:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>this is hello2</h1>
<% //resquest.setAttribute 는 requestScope.지정이름 으로 받아야 하지만, model은 지정이름으로 바로 받으면 된다. %>
<p>${name}, ${age}</p>
</body>
</html>
