<%@ page import="java.util.List" %>
<%@ page import="com.chunjae.dto.EmpDTO" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-09
  Time: 오전 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>board - list.jsp</title>
</head>
<body>
<%
    List<EmpDTO> list = (List<EmpDTO>) request.getAttribute("list");
    int currPage = (int) request.getAttribute("currPage");
    int totalPage = (int) request.getAttribute("totalPage");
    int startPage = (int) request.getAttribute("startPage");
    int endPage = (int) request.getAttribute("endPage");
    String search = (String) request.getAttribute("search");
    String input = (String) request.getAttribute("input");
%>
<a href="list">HOME</a>
<ul>
    <% for(EmpDTO dto:list) { %>
    <li>
        <a href="detail?curr=<%=currPage%>&id=<%=dto.getEmployee_id()%>"><%=dto.getEmployee_id()%></a>
        <%=dto.getFirst_name()%>
        <%=dto.getLast_name()%>
        <%=dto.getSalary()%>
        <%=dto.getHire_date()%>
    </li>
    <% } %>
</ul>
<form method="get" action="list">
    <select name="search">
        <option value="empployee_id">사원번호</option>
        <option value="first_name">이름</option>
        <option value="hire_date">입사일</option>
    </select>
    <input type="text" name="input" required>
    <button type="submit">검색</button>
</form>
<%-- 검색 파라미터가 있는 경우와 없는 경우에 url을 다르게 꾸며주는게 좋을 것 같아서 ... --%>
<% if(startPage>1) { %>
    <% if(!"".equals(search) && !"".equals(input)){%>
    <a href="list?curr=<%=startPage-1%>&search=<%=search%>&input=<%=input%>">이전</a>
    <% } %>
    <a href="list?curr=<%=startPage-1%>">이전</a>
<% } %>
<% for(int i=startPage; i<=endPage; i++){%>
   <% if(i==currPage){%>
        <%=i%>
    <%} else {%>
        <% if(!"".equals(search) && !"".equals(input)){%>
            <a href="list?curr=<%=i%>&search=<%=search%>&input=<%=input%>"><%=i%></a>
        <%} else { %>
            <a href="list?curr=<%=i%>"><%=i%></a>
        <% } %>
    <% } %>
<% } %>
<% if(endPage<totalPage) { %>
    <% if(!"".equals(search) && !"".equals(input)){%>
    <a href="list?curr=<%=endPage+1%>&search=<%=search%>&input=<%=input%>">다음</a>
    <% } %>
    <a href="list?curr=<%=endPage+1%>">다음</a>
<% } %>
</body>
</html>
