<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-08
  Time: 오후 1:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="write_result">
    <label for="employee_id">사원번호</label>
    <input type="text" name="employee_id" id="employee_id" required><br>
    <label for="first_name">이름</label>
    <input type="text" name="first_name" id="first_name"><br>
    <label for="last_name">성</label>
    <input type="text" name="last_name" id="last_name" required><br>
    <label for="salary">급여</label>
    <input type="text" name="salary" id="salary" required><br>
    <label for="hire_date">입사일</label>
    <input type="date" name="hire_date" id="hire_date" required><br>
    <button type="submit">등록</button>
    <button type="reset">취소</button>
</form>
</body>
</html>
