<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-02
  Time: 오후 5:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="write.jsp">글쓰기</a>
<ul>
    <%
        //db 정보
        String url = "jdbc:mariadb://localhost:3306/hr";
        String user = "root";
        String pwd = "mariadb";
        // db connection 에 필요한 것들
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        // sql query : 유지보수를 위해 컬럼단위로 다음 줄에 쓴다.
        StringBuilder sql = new StringBuilder();
        sql.append(" select employee_id      ");
        sql.append("        ,first_name      ");
        sql.append("        ,last_name       ");
        sql.append("        ,salary          ");
        sql.append("        ,hire_date       ");
        sql.append(" from tb_sample          ");
        //sql.append(" where first_name = ?    ");

        try {
            // String 으로 클래스를 가져올 수 있다. 아래는 database driver 의 class 경로
            Class.forName("org.mariadb.jdbc.Driver");
            // DriverManager 에 위 클래스에 해당하는 커넥션 객체를 가져온다
            conn = DriverManager.getConnection(url, user, pwd);
            // prepareStatement 는 쿼리에 변수나 값을 넣는 경우 쿼리문 내에는 ?로 쓰고, ?의 순서마다 추가 가능
            pstmt = conn.prepareStatement(sql.toString());
            //pstmt.setString(1,"Steven"); // 쿼리문의 첫 번째 ?에 "Steven"이란 값을 넣는다.
            /* PreparedStatement 클래스
               executeUpdate : DML(insert, update, delete)의 row 개수 리턴,
                               DDL(create, alter, drop)은 0을 리턴한다.
               executeQuery : select 결과 집합으로 ResultSet 을 리턴한다. */
            rs = pstmt.executeQuery();
            while(rs.next()){ %>
            <li><a href="detail.jsp?boardno=<%=rs.getInt("employee_id")%>"><%=rs.getInt("employee_id")%></a>
                <%=rs.getString("first_name")%>
                <%=rs.getString("last_name")%>
                <%=rs.getFloat("salary")%>
                <%=rs.getDate("hire_date")%>
            </li>
          <%  }
        } catch(Exception e){
            System.out.println(e);
        } finally {
            if(rs != null) try{rs.close();} catch(Exception e){}
            if(pstmt != null) try{pstmt.close();} catch(Exception e){}
            if(conn != null) try{conn.close();} catch(Exception e){}
        }
    %>
</ul>
</body>
</html>
