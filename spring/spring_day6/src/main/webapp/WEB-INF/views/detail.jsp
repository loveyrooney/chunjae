<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-05-08
  Time: 오후 5:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/resources/js/detail.js"></script>
</head>
<body>
<c:choose>
    <c:when test="${isNull}">
        <h1>잘못된 접근입니다.</h1>
    </c:when>
    <c:otherwise>
        <ul id="view">
            <li>사원번호 : ${dto.employee_id}</li>
            <li>이름 : ${dto.first_name}</li>
            <li>입사일 : ${dto.hire_date}</li>
            <li>급여 : ${dto.salary}</li>
            <li>부서번호 : ${dto.department_id}</li>
        </ul>
        <a href="/update">수정</a>
        <button type="button" id="del" onclick="delConfirm(${dto.employee_id});">삭제</button>
    </c:otherwise>
</c:choose>
</body>
</html>
