<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-12
  Time: 오후 2:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="boardlist" value="${requestScope.list}"/>
<c:set var="currPage" value="${requestScope.currPage}"/>
<c:set var="startPage" value="${requestScope.startPage}"/>
<c:set var="endPage" value="${requestScope.endPage}"/>
<c:set var="totalPage" value="${requestScope.totalPage}"/>
<c:set var="search" value="${requestScope.search}"/>
<c:set var="input" value="${requestScope.input}"/>
<a href="list">HOME</a>
<a href="insert?curr=${requestScope.currPage}">사원추가</a>
<ul>
    <c:choose>
        <c:when test="${empty boardlist}">
            <li>해당 자료가 없습니다.</li>
        </c:when>
        <c:otherwise>
            <c:forEach var="i" items="${boardlist}">
                <li>
                    <a href="detail?curr=${currPage}&id=${i.getEmployee_id()}">${i.getEmployee_id()}</a>
                        ${i.first_name}
                        ${i.last_name}
                        ${i.salary}
                        ${i.hire_date}
                </li>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</ul>
<form method="get" action="list">
    <select name="search">
        <option value="employee_id">사원번호</option>
        <option value="first_name">이름</option>
        <option value="hire_date">입사일</option>
    </select>
    <input type="text" name="input" required>
    <button type="submit">검색</button>
</form>
<c:if test="${startPage>1}">
    <c:if test="${!(empty search) && !(empty input)}">
        <a href="list?curr=${startPage-1}&search=${search}&input=${input}">이전</a>
    </c:if>
    <c:if test="${empty search && empty input}">
        <a href="list?curr=${startPage-1}">이전</a>
    </c:if>
</c:if>
<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
    <c:choose>
        <c:when test="${currPage==i}">
            ${i}
        </c:when>
        <c:when test="${!(empty search) && !(empty input)}">
            <a href="list?curr=${i}&search=${search}&input=${input}">${i}</a>
        </c:when>
        <c:otherwise>
            <a href="list?curr=${i}">${i}</a>
        </c:otherwise>
    </c:choose>
</c:forEach>
<c:if test="${endPage<totalPage}">
    <c:if test="${!(empty search) && !(empty input)}">
        <a href="list?curr=${endPage+1}&search=${search}&input=${input}">다음</a>
    </c:if>
    <c:if test="${empty search && empty input}">
        <a href="list?curr=${endPage+1}">다음</a>
    </c:if>
</c:if>
</body>
</html>
