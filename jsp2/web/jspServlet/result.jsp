<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-02
  Time: 오후 4:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <%
     request.setCharacterEncoding("utf-8");
     String id = request.getParameter("id");
     String pwd = request.getParameter("pwd");
     String name = request.getParameter("name");
     String gender = request.getParameter("gender");
     String[] favdept = request.getParameterValues("favdept");
     StringBuilder result = new StringBuilder("");
     for(String i:favdept){
         result.append(i);
         result.append(", ");
     }
     String address = request.getParameter("address");
     String comment = request.getParameter("comment");
 %>
  id : <%=id%><br>
  pwd : <%=pwd%><br>
  name : <%=name%><br>
  gender : <%=gender%><br>
  jspServlet.result : <%=result%><br>
  address : <%=address%><br>
  comment : <%=comment%><br>

</body>
</html>
