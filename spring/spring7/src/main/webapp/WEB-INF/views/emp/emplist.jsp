<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-05-10
  Time: 오후 2:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/list">HOME</a>
<ul>
    <li>사원번호 이름 입사일 부서번호</li>
    <c:forEach var="i" items="${list}">
        <li><a href="/detail/${i.employee_id}">${i.employee_id}</a> ${i.first_name} ${i.hire_date} ${i.department_id}</li>
    </c:forEach>
</ul>
<form method="get" action="/list/${page.currPage}">
    <select name="search">
        <option value="employee_id">사원번호</option>
        <option value="first_name">이름</option>
        <option value="hire_date">입사일</option>
        <option value="department_id">부서번호</option>
    </select>
    <input type="text" name="searchTxt">
    <button type="submit">검색</button>
</form>
<c:if test="${page.prev}">
    <a href="/list/${page.startBlock-1}?search=${search}&searchTxt=${searchTxt}">이전</a>
</c:if>
<c:forEach var="j" begin="${page.startBlock}" end="${page.endBlock}">
    <c:choose>
        <c:when test="${j==page.currPage}">
            ${j}
        </c:when>
        <c:otherwise>
            <a href="/list/${j}?search=${search}&searchTxt=${searchTxt}">${j}</a>
        </c:otherwise>
    </c:choose>
</c:forEach>
<c:if test="${page.next}">
    <a href="/list/${page.endBlock+1}?search=${search}&searchTxt=${searchTxt}">다음</a>
</c:if>
</body>
</html>
