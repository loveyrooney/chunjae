<%--
  Created by IntelliJ IDEA.
  User: FULL8-011
  Date: 2024-05-16
  Time: 오전 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="../resources/js/detaildept.js"></script>
</head>
<body>
<a href="/list">HOME</a>
<ul>
    <li id="deptid">${dto.department_id}</li>
    <li>${dto.department_name}</li>
</ul>
<form>
    <input type="text" name="first_name" placeholder="이름">
    <input type="text" name="salary" placeholder="급여">
    <button type="button" id="add">부서원 추가</button>
</form>
<ul id="emplist">
    <li>사원번호 이름 입사일 급여 부서번호</li>
</ul>
<script>
    init(${dto.department_id});
</script>
</body>
</html>
