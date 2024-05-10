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
${page.currPage} ${page.prev} ${page.startBlock} ${page.endBlock}
<ul>
    <li>사원번호 사원명 급여 부서명</li>
    <c:forEach var="i" items="${list}">
        <li>${i.employee_id} ${i.first_name} ${i.salary} ${i.department_name}</li>
    </c:forEach>
</ul>
<form method="get" action="emplist?currPage=${page.currPage}">
    <select name="search_ctg">
        <option value="employee_id">사원번호</option>
        <option value="first_name">이름</option>
        <option value="department_name">부서명</option>
    </select>
    <input type="text" name="search_txt"/>
    <button type="submit">검색</button>
</form>
<c:if test="${page.prev}">
    <a href="emplist?currPage=${page.startBlock-1}&search=${search}&search_txt=${search_txt}">이전</a>
</c:if>
<c:forEach var="j" begin="${page.startBlock}" end="${page.endBlock}">
    <c:choose>
        <c:when test="${j==page.currPage}">
            <c:out value="${j}"/>
        </c:when>
        <c:otherwise>
            <a href="emplist?currPage=${j}&search=${search}&search_txt=${search_txt}">${j}</a>
        </c:otherwise>
    </c:choose>
</c:forEach>
<c:if test="${page.next}">
    <a href="emplist?currPage=${page.endBlock+1}&search=${search}&search_txt=${search_txt}">다음</a>
</c:if>
</body>
</html>
