<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-03
  Time: 오후 4:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="insert_result.jsp">
    사원번호 <input type="text" name="empno" required><br>
    이름 <input type="text" name="fname" required><br>
    성 <input type="text" name="lname" required><br>
    급여 <input type="text" name="salary" required><br>
    입사일 <input type="date" name="hiredate" required><br>
    <button type="submit">submit</button>
    <button type="reset">reset</button>
</form>
</body>
</html>
