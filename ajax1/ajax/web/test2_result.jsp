<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-16
  Time: 오후 3:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <fmt:requestEncoding value="utf-8"/>
    이름 : <c:out value="${param.name}"/><br>
    나이 : <c:out value="${param.age}"/>
</body>
</html>
