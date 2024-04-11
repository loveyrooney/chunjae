<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-11
  Time: 오후 3:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>myboard - list</title>
</head>
<body>
<a href="list">HOME</a>
<a href="insert">글쓰기</a>
<table>
    <thead>
        <tr>
            <th>No.</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회수</th>
        </tr>
    </thead>
    <tbody>
        <c:if test="${empty boardList}">
            <tr><td>해당 자료가 없습니다.</td></tr>
        </c:if>
        <c:if test="${!(empty boardList)}">
            <c:forEach var="r" items="${boardList}">
                <tr>
                <td>${r.boardno}</td>
                    <td><a href="detail?id=${r.boardno}">${r.title}</a></td>
                <td>${r.writer}</td>
                <td>${r.writedate}</td>
                <td>${r.readno}</td>
                </tr>
            </c:forEach>
        </c:if>
    </tbody>
</table>
</body>
</html>
