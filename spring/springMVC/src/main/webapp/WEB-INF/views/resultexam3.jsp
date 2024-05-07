<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-05-07
  Time: 오후 3:33
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
    <li>아이디 : ${mdto.id}</li>
    <li>패스워드 : ${mdto.pwd}</li>
    <li>이름 : ${mdto.name}</li>
    <li>주소 : ${mdto.addr}</li>
    <li>성별 : ${mdto.gender}</li>
    <li>좋아하는 음식 : <c:forEach var="f" items="${mdto.food}">
        ${f},
    </c:forEach> </li>
    <li>하고싶은 말 : ${mdto.comment}</li>
</ul>
</body>
</html>
