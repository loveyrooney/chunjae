<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-15
  Time: 오전 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="wrap">
    <c:choose>
        <c:when test="${empty sessionScope.id}">
            <a href="login.do">로그인</a>
            <a href="join.do">회원가입</a>
        </c:when>
        <c:otherwise>
            <a href="logout.do">로그아웃</a>
            <a href="input.do">내정보</a>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
