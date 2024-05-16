<%--
  Created by IntelliJ IDEA.
  User: FULL8-011
  Date: 2024-05-16
  Time: 오전 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="resources/css/deptlist.css">
</head>
<body>
<ul>
    <li>부서번호 부서명</li>
    <c:forEach var="dto" items="${list}">
        <li>${dto.department_id} <a href="/detaildept/${dto.department_id}">${dto.department_name}</a></li>
    </c:forEach>
</ul>
</body>
</html>
