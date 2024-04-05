<%@ page import="com.chunjae.dao.EmpDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.chunjae.dto.EmpDTO" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-04
  Time: 오후 2:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    // 검색 값 받아오기
    String col = request.getParameter("search");
    String input = request.getParameter("input");
    if(col == null)
        col = "";
    if(input == null)
        input = "";
    //System.out.println("jsp: "+col+","+input);
    // select 결과를 pageSize 만큼 보여주기
    int currPage = 1;
    String curr = request.getParameter("curr");
    if(curr != null)
        currPage = Integer.parseInt(curr);
    int pageSize = 10;
    int startRow = (currPage-1)*pageSize;
    // db 데이터 불러오기
    EmpDAO dao = EmpDAO.getInstance();
    List<EmpDTO> empList = dao.getList(startRow, pageSize, col, input);
    System.out.println("list size: "+empList.size());
    // 마지막 페이지는 empList count 에 따라 달라진다.
    int endPage = (int)Math.ceil(dao.getCount(col,input)/(float)pageSize);
    //System.out.println(currPage+","+endPage);
//    if(!"".equals(col) && !"".equals(input)) {
//        if("employee_id".equals(input)){
//        } else if("first_name".equals(input)) {
//        } else {
//        }
//    }

    // page 목록을 pagePointSize 만큼 만들기
    int pagePointSize = 3;
    //int startPagePoint = ((currPage-1)/pagePointSize)*pagePointSize+1;
    int N = ((currPage-1)/pagePointSize)+1;  // n = currPage 를 3으로 나눈 몫 + 1
    int startPagePoint = pagePointSize*N-2;  // An = 3n-2
    int endPagePoint = startPagePoint+pagePointSize-1;
    if (endPagePoint > endPage)
        endPagePoint = endPage;
%>
<a href="dbcp.jsp">HOME</a>
<a href="insert_dbcp.jsp">사원추가</a>
<h4>사원번호  이름  성  급여  입사일</h4>
<ul>
    <% for(EmpDTO dto: empList) { %>
    <li>
        <%=dto.getEmployee_id()%>
        <%=dto.getFirst_name()%>
        <%=dto.getLast_name()%>
        <%=dto.getSalary()%>
        <%=dto.getHire_date()%>
    </li>
    <% } %>
</ul>
<%-- 검색 결과를 get방식으로 받았기 때문에 검색 결과의 페이지들에도 파라미터를 모두 전달해 주어야 한다. --%>
<% if(!"".equals(col) && !"".equals(input)) {
     if(startPagePoint>1) { %>
        <a href="dbcp.jsp?search=<%=col%>&input=<%=input%>&curr=<%=startPagePoint-1%>">이전</a>
    <% }
     for(int i=startPagePoint; i<=endPagePoint; i++){
        if(i==currPage) { %>
            <%=i%>
        <% } else { %>
            <a href="dbcp.jsp?search=<%=col%>&input=<%=input%>&curr=<%=i%>"><%=i%></a>
        <% }
    }
    if(endPagePoint<endPage) { %>
    <a href="dbcp.jsp?search=<%=col%>&input=<%=input%>&curr=<%=endPagePoint+1%>">다음</a>
    <% } %>
<% } else {
    if(startPagePoint>1) { %>
        <a href="dbcp.jsp?curr=<%=startPagePoint-1%>">이전</a>
    <% }
        for(int i=startPagePoint; i<=endPagePoint; i++){
            if(i==currPage) { %>
                <%=i%>
            <% } else { %>
                <a href="dbcp.jsp?curr=<%=i%>"><%=i%></a>
            <% }
        }
    if(endPagePoint<endPage) { %>
    <a href="dbcp.jsp?curr=<%=endPagePoint+1%>">다음</a>
<% }
} %>
<form method="get" action="dbcp.jsp">
    <select name="search">
        <option value="first_name">이름</option>
        <option value="employee_id">사원번호</option>
        <option value="hire_date">입사일</option>
        <option value="hire_year">입사연도</option>
    </select>
    <input type="text" name="input" placeholder="입사일은 yyyy-mm-dd 로 입력하세요">
    <button type="submit">검색</button>
</form>
</body>
</html>
