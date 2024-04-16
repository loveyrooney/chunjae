<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-15
  Time: 오후 4:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="list" value="${requestScope.list}"/>
<ul>
    <li>No. 제목 조회수</li>
    <c:choose>
        <c:when test="${empty list || fn:length(list)==0}">
            <li>해당 자료가 없습니다.</li>
        </c:when>
        <c:otherwise>
            <c:forEach var="i" items="${list}">
                <li>${i.bno} <a href="detail.do?id=${i.bno}">${i.btitle}</a> ${i.readno}</li>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</ul>
</body>
</html>
