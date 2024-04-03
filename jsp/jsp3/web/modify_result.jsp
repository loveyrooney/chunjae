<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.DriverManager" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-03
  Time: 오후 3:29
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
    int employee_id = Integer.parseInt(request.getParameter("employee_id"));
    String first_name = request.getParameter("fname");
    String last_name = request.getParameter("lname");
    float salary = Float.parseFloat(request.getParameter("salary"));
    String hire_date = request.getParameter("hiredate");

    String url = "jdbc:mariadb://localhost:3306/hr";
    String user = "root";
    String pwd = "mariadb";
    Connection conn = null;
    PreparedStatement pstmt = null;
    StringBuilder sql = new StringBuilder();
    sql.append(" update tb_sample        ");
    sql.append(" set first_name = ?      ");
    sql.append("     ,last_name = ?      ");
    sql.append("     ,salary = ?         ");
    sql.append("     ,hire_date = ?      ");
    sql.append(" where employee_id = ?   ");

    try{
        Class.forName("org.mariadb.jdbc.Driver");
        conn = DriverManager.getConnection(url,user,pwd);
        pstmt = conn.prepareStatement(sql.toString());
        pstmt.setString(1,first_name);
        pstmt.setString(2,last_name);
        pstmt.setFloat(3,salary);
        pstmt.setString(4,hire_date);
        pstmt.setInt(5,employee_id);
        pstmt.executeUpdate();
    }catch (Exception e){
        System.out.println(e);
    } finally {
        if(pstmt != null) try{pstmt.close();} catch(Exception e){}
        if(conn != null) try{conn.close();} catch(Exception e){}
    }
    response.sendRedirect("dbtest.jsp");
%>
</body>
</html>
