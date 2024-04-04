<%@ page import="com.chunjae.DAO.BoardDAO" %>
<%@ page import="com.chunjae.DTO.BoardDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-03
  Time: 오후 4:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="insert.jsp">글쓰기</a>
<ul>
<%
    BoardDAO dao = new BoardDAO();
    List<BoardDTO> list = dao.getList();
    for(BoardDTO dto:list){ %>
        <li>
            <%=dto.getEmployee_id()%>
            <%=dto.getFirst_name()%>
            <%=dto.getLast_name()%>
            <%=dto.getSalary()%>
            <%=dto.getHire_date()%>
        </li>
    <% }
%>
</ul>
</body>
</html>
