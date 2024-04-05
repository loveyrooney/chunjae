<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-05
  Time: 오후 3:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    /* servlet forwarding
        1. sendRedirect : a1 서블릿에서 요청을 받은 뒤 클라이언트를 다시 거쳐 a2에 요청하고 리턴받는 방식 (url 변경)
        2. forward : a1 서블릿에서 요청을 받은 뒤 내부에서 a2 서블릿에 제어권 넘기고 a2 서블릿에서 리턴 (url 변경 안됨)
                     jsp 에서 쓰는 경우와 servlet(dispatcher 활용) 에서 쓰는 경우의 코드 다름
    */

    out.print("jsp page firstContact");

    response.sendRedirect("charged.jsp");

%>
<%--<jsp:forward page="charged.jsp"></jsp:forward>--%>

</body>
</html>
