<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-05-09
  Time: 오후 2:27
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
    <c:forEach var="i" items="${emplist}">
        <li>${i.employee_id} ${i.first_name} ${i.salary} ${i.department_name}</li>
    </c:forEach>
</ul>
<form method="get" action="search">
    <select name="search_ctg">
        <option value="employee_id">사원번호</option>
        <option value="first_name">이름</option>
        <option value="department_name">부서명</option>
    </select>
    <input type="text" name="search_txt"/>
    <button type="submit">검색</button>
</form>
</body>
</html>
