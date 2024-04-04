package com.chunjae.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chunjae.DTO.BoardDTO;

public class BoardDAO {

    // db connection / disconnection 은 여기서만 하면 되므로 private
    private Connection getConnection(){
        String url = "jdbc:mariadb://localhost:3306/hr";
        String user = "root";
        String pwd = "mariadb";
        Connection conn = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    private void disconn(ResultSet rs, PreparedStatement pstmt, Connection conn){
        if(rs != null) try{rs.close();} catch(Exception e){}
        disconn(pstmt,conn);
    }
    private void disconn(PreparedStatement pstmt, Connection conn){
        if(pstmt != null) try{pstmt.close();} catch(Exception e){}
        if(conn != null) try{conn.close();} catch(Exception e){}
    }
    // 만들 때는 ArrayList 였지만 리턴을 List로 하는 이유는 다른 list 계열의 클래스도 문제 없이 사용할 수 있도록
    public List<BoardDTO> getList(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        StringBuilder sql = new StringBuilder();
        sql.append(" select employee_id      ");
        sql.append("        ,first_name      ");
        sql.append("        ,last_name       ");
        sql.append("        ,salary          ");
        sql.append("        ,hire_date       ");
        sql.append(" from tb_sample          ");
        ResultSet rs = null;
        // select 쿼리 ResultSet 을 얻어올 때마다 그것을 전달할 ArrayList 를 만든다.
        ArrayList<BoardDTO> arr = new ArrayList<>();
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            while(rs.next()){
                // rs.next() 가 하나의 row 이면서 ArrayList 의 BoardDTO 타입 자료가 된다.
                BoardDTO dto = new BoardDTO();
                dto.setEmployee_id(rs.getInt("employee_id"));
                dto.setFirst_name(rs.getString("first_name"));
                dto.setLast_name(rs.getString("last_name"));
                dto.setSalary(rs.getFloat("salary"));
                dto.setHire_date(rs.getString("hire_date"));
                arr.add(dto);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            disconn(rs, pstmt, conn);
        }
        return arr;
    }

    public int insertEmp(BoardDTO dto){
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
            conn = getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setInt(1,dto.getEmployee_id());
            pstmt.setString(2,dto.getFirst_name());
            pstmt.setString(3,dto.getLast_name());
            pstmt.setFloat(4,dto.getSalary());
            pstmt.setString(5,dto.getHire_date());
            result = pstmt.executeUpdate();
        } catch(Exception e){
            System.out.println(e);
        } finally {
            disconn(pstmt,conn);
        }
        return result;
    }



}
