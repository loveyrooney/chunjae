package com.chunjae.dao;

import com.chunjae.dto.EmpDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
    private Connection getConnection(){
        Connection conn =null;
        String url = "jdbc:mariadb://localhost:3306/hr";
        String user = "root";
        String pwd = "mariadb";
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn= DriverManager.getConnection(url,user,pwd);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    private void disconn(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        if(rs !=null) try{ rs.close();} catch (Exception e) {}
        if(pstmt !=null) try{ pstmt.close();} catch (Exception e) {}
        if(conn !=null) try{ conn.close();} catch (Exception e) {}
    }
    public List<EmpDTO> getList(int startRow, int pageSize) {
        Connection conn = null;
        PreparedStatement pstmt =null;
        ResultSet rs =null;
        StringBuilder sql = new StringBuilder();
        sql.append(" select employee_id     ");
        sql.append("        ,first_name     ");
        sql.append("        ,last_name      ");
        sql.append("        ,salary         ");
        sql.append("        ,hire_date      ");
        sql.append(" from tb_sample         ");
        sql.append(" limit ?,?              ");
        ArrayList<EmpDTO> arr = new ArrayList<>();
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setInt(1,startRow);
            pstmt.setInt(2,pageSize);
            rs = pstmt.executeQuery();
            while(rs.next()){
                EmpDTO dto = new EmpDTO();
                dto.setEmployee_id(rs.getInt("employee_id"));
                dto.setFirst_name(rs.getString("first_name"));
                dto.setLast_name(rs.getString("last_name"));
                dto.setSalary(rs.getFloat("salary"));
                dto.setHire_date(rs.getDate("hire_date").toLocalDate());
                arr.add(dto);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            disconn(rs,pstmt,conn);
        }
        return arr;
    }
    public int getCount() {
        Connection conn = null;
        PreparedStatement pstmt =null;
        ResultSet rs =null;
        StringBuilder sql = new StringBuilder();
        sql.append(" select count(*) from tb_sample ");
        int totalData= 0;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            if(rs.next()) {
                // ResultSet.getType() 안에는 label(String 컬럼명), index(int 컬럼의 idx)를 쓸 수 있다.
                // 이 쿼리는 컬럼이 단일하게 나오므로 인덱스로 가져왔다.
                totalData = rs.getInt(1);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            disconn(rs,pstmt,conn);
        }
        return totalData;
    }
}
