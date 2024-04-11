<%@ page import="java.util.ArrayList" %>
<%@ page import="t.MemberDTO" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-11
  Time: 오후 1:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% request.setCharacterEncoding("utf-8");%>
이름 : ${param.name}<br>
국어 : ${param.kor}<br>
영어 : ${param.eng}<br>
수학 : ${param.math}<br>
<%-- el param은 타입에 상관이 없는가? --%>
<c:set var="sum" value="${param.kor+param.eng+param.math}"/>
총점 : ${sum}<br>
<c:set var="avg" value="${sum/3}"/>
평균 : ${avg}<br>
성취도 (if) :
<c:if test="${avg>=60}">
    <c:out value="합격"/>
</c:if><br>
성취도 (choose) :
<c:choose>
    <c:when test="${avg>=90}">
        <c:out value="A"/>
    </c:when>
    <c:when test="${avg>=80}">
        <c:out value="B"/>
    </c:when>
    <c:when test="${avg>=70}">
        <c:out value="C"/>
    </c:when>
    <c:when test="${avg>=60}">
        <c:out value="D"/>
    </c:when>
    <c:otherwise>
        <c:out value="F"/>
    </c:otherwise>
</c:choose>
<hr>
<%
    ArrayList<MemberDTO> scores = new ArrayList<>();
    scores.add(new MemberDTO("hong",90,80,78));
    scores.add(new MemberDTO("kim",50,100,60));
    scores.add(new MemberDTO("lee",66,58,73));
    scores.add(new MemberDTO("park",55,65,40));
    scores.add(new MemberDTO("dahn",30,100,89));
    pageContext.setAttribute("scores",scores);
%>
이름 국어 영어 수학 총점 평균<br>
<c:forEach var="m" items="${scores}">
    <c:if test="${m.avg>=60}">
        <c:out value="${m.name} ${m.kor} ${m.eng} ${m.math} ${m.sum} ${m.avg}"/><br>
    </c:if>
</c:forEach>
</body>
</html>
