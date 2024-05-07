<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-05-07
  Time: 오후 3:12
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
    <li>아이디 : ${examDTO.id}</li>
    <li>패스워드 : ${examDTO.pwd}</li>
    <li>이름 : ${examDTO.name}</li>
    <li>주소 : ${examDTO.addr}</li>
    <li>성별 : ${examDTO.gender}</li>
    <li>좋아하는 음식 : <c:forEach var="f" items="${examDTO.food}">
        ${f},
    </c:forEach> </li>
    <li>하고싶은 말 : ${examDTO.comment}</li>
</ul>
</body>
</html>
