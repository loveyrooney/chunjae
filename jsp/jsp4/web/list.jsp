<%@ page import="com.chunjae.dao.EmpDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.chunjae.dto.EmpDTO" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-04
  Time: 오전 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int pageSize = 10;
    EmpDAO dao = new EmpDAO();
    // Math.ceil 은 double 을 리턴하므로 int 로 형변환
    // (int) Math.ceil(dao.getCount()/pageSize) 이렇게 하는 경우,
    // dao.getCount 도 int, pageSize 도 int 기 때문에 ceil 안의 값이 int 가 되어버린다. 주의.
    int totalPage = (int)Math.ceil(dao.getCount()/(float)pageSize);
    String curr = request.getParameter("curr");
    int currPage=1;
    if(curr !=null){
        currPage=Integer.parseInt(curr);
    }
    int startRow = (currPage-1)*pageSize;
    List<EmpDTO> list = dao.getList(startRow,pageSize);
    int blockSize = 5;
    // (currPage-1)/blockSize + 1 을 하게되면 변수 startBlock 은 block 들의 idx 를 가리키게 되는데,
    // startBlock 은 해당 블록의 첫번째 currPage 를 의미해야 한다. ex) 2번째 블록의 첫 번째 페이지인 6
    int startBlock = (currPage-1)/blockSize*blockSize+1;
    int endBlock = startBlock+blockSize-1;
    if(totalPage<endBlock)
        endBlock = totalPage;
%>
<a href="insert_emp.jsp">추가</a>
<table>
    <thead>
        <tr>
            <th>사원번호</th>
            <th>이름</th>
            <th>성</th>
            <th>급여</th>
            <th>입사일</th>
        </tr>
    </thead>
    <tbody>
        <%
            for(EmpDTO dto:list){ %>
            <tr>
                <td><%=dto.getEmployee_id()%></td>
                <td><%=dto.getFirst_name()%></td>
                <td><%=dto.getLast_name()%></td>
                <td><%=dto.getSalary()%></td>
                <td><%=dto.getHire_date()%></td>
            </tr>
            <% }
        %>
    </tbody>
</table>
<div>
    <% if(startBlock>1) {%>
    <a href="list.jsp?curr=<%=startBlock-1%>">이전</a>
    <% } %>
    <% for(int i=startBlock; i<=endBlock; i++){
        if(i==currPage){ %>
        <strong><%=i%></strong>
        <% } else { %>
        <a href="list.jsp?curr=<%=i%>"><%=i%></a>
        <% }
    } %>
    <% if(endBlock<totalPage) {%>
    <a href="list.jsp?curr=<%=endBlock+1%>">다음</a>
    <% } %>
</div>
<%--<div>--%>
<%--    <% if(currPage>1) { %>--%>
<%--    <a href="list.jsp?curr=<%=currPage-1%>">이전</a>--%>
<%--    <% } %>--%>
<%--    <%=currPage%>--%>
<%--    <% if(currPage<totalPage) { %>--%>
<%--    <a href="list.jsp?curr=<%=currPage+1%>">다음</a>--%>
<%--    <% } %>--%>
<%--</div>--%>
</body>
</html>
