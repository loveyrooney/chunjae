<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.DriverManager" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-03
  Time: 오후 2:30
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
    int boardno = Integer.parseInt(request.getParameter("boardno"));

    String url = "jdbc:mariadb://localhost:3306/hr";
    String user = "root";
    String pwd = "mariadb";
    Connection conn = null;
    PreparedStatement pstmt = null;
    int result = 0;
    StringBuilder sql = new StringBuilder();
    sql.append(" delete from tb_sample        ");
    sql.append("        where employee_id = ? ");
    try{
        Class.forName("org.mariadb.jdbc.Driver");
        conn = DriverManager.getConnection(url,user,pwd);
        pstmt = conn.prepareStatement(sql.toString());
        pstmt.setInt(1,boardno);
        result = pstmt.executeUpdate();
    }catch (Exception e){
        System.out.println(e);
    } finally {
        if(pstmt != null) try{pstmt.close();} catch(Exception e){}
        if(conn != null) try{conn.close();} catch(Exception e){}
    }
%>
<script>
    alert(<%=result%>+"삭제 성공");
    location.href = "dbtest.jsp";
</script>
</body>
</html>
