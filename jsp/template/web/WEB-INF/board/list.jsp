<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-15
  Time: 오전 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <ul>
        <c:set var="list" value="${requestScope.list}"/>
        <c:choose>
            <c:when test="${empty list}">
                <li>해당 자료가 없습니다.</li>
            </c:when>
            <c:otherwise>
                <c:forEach var="i" items="${list}">
                    <li>${i.empId}, ${i.first_name}</li>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </ul>
</body>
</html>
