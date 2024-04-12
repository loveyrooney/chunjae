<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-12
  Time: 오후 3:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  String name = "hong gil dong";
  pageContext.setAttribute("name",name);
%>
${name} 님

</body>
</html>
