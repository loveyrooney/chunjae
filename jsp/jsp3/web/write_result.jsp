<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-03
  Time: 오후 12:58
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

    String url = "jdbc:mariadb://localhost:3306/hr";
    String user = "root";
    String pwd = "mariadb";
    Connection conn = null;
    PreparedStatement pstmt = null;
    StringBuilder sql = new StringBuilder();
    sql.append(" insert into tb_sample ( employee_id    ");
    sql.append("                         ,first_name    ");
    sql.append("                         ,last_name     ");
    sql.append("                         ,salary        ");
    sql.append("                         ,hire_date     ");
    sql.append("                         )              ");
    sql.append(" values (?,?,?,?,?)                     ");
    int result=0;
    try{
        Class.forName("org.mariadb.jdbc.Driver");
        conn = DriverManager.getConnection(url,user,pwd);
        pstmt = conn.prepareStatement(sql.toString());
        pstmt.setInt(1,employee_id);
        pstmt.setString(2,first_name);
        pstmt.setString(3,last_name);
        pstmt.setFloat(4,salary);
        pstmt.setString(5,hire_date); // 입력받지 않고 시스템에서 처리하는 경우 setDate
        result = pstmt.executeUpdate();
    } catch(Exception e){
        System.out.println(e);
    } finally {
        if(pstmt != null) try{pstmt.close();} catch(Exception e){}
        if(conn != null) try{conn.close();} catch(Exception e){}
    }
  %>
<script>
    alert(<%=result%>+"입력 성공");
    location.href = "dbtest.jsp";
</script>
</body>
</html>
