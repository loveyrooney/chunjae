<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-15
  Time: 오후 5:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="board" value="${requestScope.board}"/>
<ul>
  <li>번호 : ${board.bno} | 조회수 : ${board.readno}</li>
  <li>제목 : ${board.btitle}</li>
  <li>내용 : ${board.bcontent}</li>
  <c:choose>
      <c:when test="${empty board.bimg}">
          <li>파일 : 이미지가 없습니다.</li>
      </c:when>
      <c:otherwise>
          <li>파일 : <img src="upload/${board.bimg}" alt="${board.bimg}"></li>
      </c:otherwise>
  </c:choose>
</ul>
<a href="delete.do?id=${board.bno}&img=${board.bimg}">삭제</a>
</body>
</html>
