<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-11
  Time: 오전 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int result=0;
    for(int i=0; i<=10; i++){
        result += i;
    }
    request.setAttribute("result",result);
    RequestDispatcher disp = request.getRequestDispatcher("page2.jsp");
    disp.forward(request,response);
%>
</body>
</html>
