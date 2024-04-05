<%@ page import="dto.StudentDTO" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-05
  Time: 오후 4:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    out.println("this is page2");
    //StudentDTO pageconDTO = (StudentDTO) pageContext.getAttribute("dto");
    StudentDTO reqDTO = (StudentDTO) request.getAttribute("dto");
    out.print(reqDTO);
%>
</body>
</html>
