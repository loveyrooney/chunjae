<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-05-07
  Time: 오후 2:41
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
    <li>아이디 : ${id}</li>
    <li>패스워드 : ${pwd}</li>
    <li>이름 : ${name}</li>
    <li>주소 : ${addr}</li>
    <li>성별 : ${gender}</li>
    <li>좋아하는 음식 : <c:forEach var="f" items="${food}">
      ${f},
    </c:forEach> </li>
    <li>하고싶은 말 : ${comment}</li>
  </ul>
</body>
</html>
