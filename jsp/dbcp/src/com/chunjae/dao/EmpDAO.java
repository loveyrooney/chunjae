package com.chunjae.dao;

import com.chunjae.dto.EmpDTO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
    private Connection getConn() throws NamingException {
        Context initContext = new InitialContext();
        Context envContext  = (Context)initContext.lookup("java:/comp/env");
        // lookup 안에는 context resource 의 name 이 들어가야 한다.
        DataSource ds = (DataSource)envContext.lookup("jdbc/myDB");
        Connection conn = null;
        try {
            conn = ds.getConnection();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
    private void disConn(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        if(rs !=null) try{ rs.close();} catch (Exception e) {}
        disConn(pstmt,conn);
    }

    private void disConn(PreparedStatement pstmt, Connection conn) {
        if(pstmt !=null) try{ pstmt.close();} catch (Exception e) {}
        if(conn !=null) try{ conn.close();} catch (Exception e) {}
    }
    public List<EmpDTO> getList(int startRow, int pageSize, String col, String input) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StringBuilder sql = new StringBuilder();
        sql.append(" select * from tb_sample ");
        if(col != null) {
            if (col.equals("employee_id"))
                sql.append(" where employee_id = "+input);
            else if (col.equals("first_name"))
                sql.append(" where first_name like"+"'%"+input+"%'");
            else if (col.equals("hire_date"))
                sql.append(" where hire_date = "+"'"+input+"'");
            else
                sql.append(" where year(hire_date) = "+"'"+input+"'");
        }
        sql.append(" limit ?,? ");
        ArrayList<EmpDTO> dtoList = new ArrayList<>();
        try {
            conn = getConn();
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
                dtoList.add(dto);
            }
        } catch (Exception e){
            System.out.println("getList: "+e.getMessage());
        } finally {
            disConn(rs,pstmt,conn);
        }
        return dtoList;
    }
    public int getCount(String col, String input){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int result = 0;
        StringBuilder sql = new StringBuilder();
        sql.append(" select count(*) from tb_sample ");
        ArrayList<EmpDTO> dtoList = new ArrayList<>();
        try {
            conn = getConn();
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            while(rs.next()){
                result = rs.getInt(1);
            }
        } catch (Exception e){
            System.out.println("getCount: "+e.getMessage());
        } finally {
            disConn(rs,pstmt,conn);
        }
        return result;
    }

}
