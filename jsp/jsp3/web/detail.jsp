<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-03
  Time: 오후 2:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <%
        request.setCharacterEncoding("utf-8");
        int boardno = Integer.parseInt(request.getParameter("boardno"));

        String url = "jdbc:mariadb://localhost:3306/hr";
        String user = "root";
        String pwd = "mariadb";
        Connection conn = null;
        PreparedStatement pstmt = null;

        StringBuilder sql = new StringBuilder();
        sql.append(" select employee_id      ");
        sql.append("        ,first_name      ");
        sql.append("        ,last_name       ");
        sql.append("        ,salary          ");
        sql.append("        ,hire_date       ");
        sql.append(" from tb_sample          ");
        sql.append(" where employee_id = ?   ");
        ResultSet rs = null;

        try{
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pwd);
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setInt(1,boardno);
            rs = pstmt.executeQuery();
            while(rs.next()){ %>
                <li>
                    <%=rs.getInt("employee_id")%>
                    <%=rs.getString("first_name")%>
                    <%=rs.getString("last_name")%>
                    <%=rs.getFloat("salary")%>
                    <%=rs.getString("hire_date")%>
                </li>
            <% }
        }catch (Exception e){
            System.out.println(e);
        } finally {
            if(rs != null) try{rs.close();} catch(Exception e){}
            if(pstmt != null) try{pstmt.close();} catch(Exception e){}
            if(conn != null) try{conn.close();} catch(Exception e){}
        }
    %>
</ul>
<a href="modify.jsp?boardno=<%=boardno%>">수정</a>
<a href="delete.jsp?boardno=<%=boardno%>">삭제</a>
</body>
</html>
