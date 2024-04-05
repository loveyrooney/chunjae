<%@ page import="dto.StudentDTO" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-05
  Time: 오후 4:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    StudentDTO dto = new StudentDTO("hong",20);
    session.setAttribute("dto",dto);
    session.setMaxInactiveInterval(100); // 세션기간의 인터벌 단위설정
    // 세션의 종료는 2가지가 있다.
    // session.removeAttribute("dto") 는 해당 이름의 세션을 없앤다.
    // session.invalidate() 는 생성된 모든 세션을 종료한다.
%>
<%=session.getAttribute("dto")%><br>
<%
    StudentDTO sessDTO = (StudentDTO) session.getAttribute("dto");
    out.print(sessDTO.getName());
%>

</body>
</html>
