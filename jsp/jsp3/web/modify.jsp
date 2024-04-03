<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-03
  Time: 오후 2:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<main>
<%
    request.setCharacterEncoding("utf-8");
    int boardno = Integer.parseInt(request.getParameter("boardno"));

    String url = "jdbc:mariadb://localhost:3306/hr";
    String user = "root";
    String pwd = "mariadb";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    StringBuilder sql = new StringBuilder();
    sql.append(" select employee_id      ");
    sql.append("        ,first_name      ");
    sql.append("        ,last_name       ");
    sql.append("        ,salary          ");
    sql.append("        ,hire_date       ");
    sql.append(" from tb_sample          ");
    sql.append(" where employee_id = ?   ");
    try{
        Class.forName("org.mariadb.jdbc.Driver");
        conn = DriverManager.getConnection(url,user,pwd);
        pstmt = conn.prepareStatement(sql.toString());
        pstmt.setInt(1,boardno);
        rs = pstmt.executeQuery();
        while(rs.next()){ %>
            <form method="post" action="modify_result.jsp">
                사원번호 <input type="text" name="employee_id" name="employee_id"
                            value="<%=boardno%>" readonly><br>
                이름 <input type="text" name="fname" value="<%=rs.getString("first_name")%>" required><br>
                성 <input type="text" name="lname" value="<%=rs.getString("last_name")%>" required><br>
                급여 <input type="text" name="salary" value="<%=rs.getFloat("salary")%>" required><br>
                입사일 <input type="date" name="hiredate" value="<%=rs.getString("hire_date")%>" required><br>
                <button type="submit">modify</button>
                <button type="reset">reset</button>
            </form>
        <% }
    }catch (Exception e){
        System.out.println(e);
    } finally {
        if(rs != null) try{rs.close();} catch(Exception e){}
        if(pstmt != null) try{pstmt.close();} catch(Exception e){}
        if(conn != null) try{conn.close();} catch(Exception e){}
    }
%>
</main>
</body>
</html>
