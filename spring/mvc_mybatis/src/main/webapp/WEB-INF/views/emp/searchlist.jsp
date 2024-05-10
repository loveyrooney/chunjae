<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-05-09
  Time: 오후 3:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="i" items="${listWithMap}">
    ${i.employee_id} ${i.first_name} ${i.salary} ${i.department_name} <br>
</c:forEach>
</body>
</html>
