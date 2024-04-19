<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-18
  Time: 오전 10:14
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
<c:set var="boardList" value="${requestScope.boardList}"/>
<a href="writeboard.do">글쓰기</a>
    <table>
        <thead>
            <tr><th>No.</th><th>제목</th></tr>
        </thead>
        <tbody>
            <c:choose>
                <c:when test="${empty boardList || fn:length(boardList)<1}">
                    <tr><td colspan="2">해당 자료가 없습니다.</td></tr>
                </c:when>
                <c:otherwise>
                    <c:forEach var="i" items="${boardList}">
                        <tr>
                            <td>${i.boardno}</td>
                            <td><a href="detail.do?bno=${i.boardno}">${i.boardtitle}</a></td>
                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </tbody>
    </table>
</body>
</html>
