<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-11
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
<c:out value="${pageContext.request.contextPath}"/><br>
<c:redirect url="url2.jsp">
<c:param name="search" value="first_name"/>
<c:param name="input" value="son"/>
</c:redirect>
</body>
</html>
