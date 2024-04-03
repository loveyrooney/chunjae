<%@ page import="com.chunjae.DTO.BoardDTO" %>
<%@ page import="com.chunjae.DAO.BoardDAO" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-03
  Time: 오후 5:06
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
    int employee_id = Integer.parseInt(request.getParameter("empno"));
    String first_name = request.getParameter("fname");
    String last_name = request.getParameter("lname");
    float salary = Float.parseFloat(request.getParameter("salary"));
    String hire_date = request.getParameter("hiredate");

    BoardDAO dao = new BoardDAO();
    BoardDTO dto = new BoardDTO();
    dto.setEmployee_id(employee_id);
    dto.setFirst_name(first_name);
    dto.setLast_name(last_name);
    dto.setSalary(salary);
    dto.setHire_date(hire_date);
    int result = dao.insertEmp(dto);
%>
<script>
    alert(<%=result%>+"입력 성공");
    location.href = "board.jsp";
</script>
</body>
</html>
