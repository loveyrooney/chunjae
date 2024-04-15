<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-12
  Time: 오후 4:58
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
    <c:forEach var="i" items="${requestScope.list}">
        <li>
            ${i.empId}
            ${i.first_name}
        </li>
    </c:forEach>
</ul>
</body>
</html>
