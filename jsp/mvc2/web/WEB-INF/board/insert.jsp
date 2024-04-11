<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-09
  Time: 오후 5:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int currPage = (int) request.getAttribute("curr");
%>
<form method="post" action="insert_result">
    <input type="text" name="curr" value="<%=currPage%>" hidden><br>
    <label for="id">사원번호</label>
    <input type="text" name="employee_id" id="id" required><br>
    <label for="f">이름</label>
    <input type="text" name="first_name" id="f"><br>
    <label for="l">성</label>
    <input type="text" name="last_name" id="l" required><br>
    <label for="sal">급여</label>
    <input type="text" name="salary" id="sal" required><br>
    <label for="date">입사일</label>
    <input type="text" name="hire_date" id="date" required><br>
    <button type="submit">등록</button>
    <button type="reset">취소</button>
</form>
</body>
</html>
