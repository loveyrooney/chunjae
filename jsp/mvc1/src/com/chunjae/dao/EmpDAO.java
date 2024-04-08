package com.chunjae.dao;

import com.chunjae.dto.EmpDTO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
    private static EmpDAO instance = new EmpDAO();

    public static EmpDAO getInstance() {
        return instance;
    }

    private EmpDAO(){}

    private Connection getConnection(){
        Connection conn = null;
        try {
            Context initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource)envContext.lookup("jdbc/myDB");
            conn = ds.getConnection();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public List<EmpDTO> getList(){
        StringBuilder sql = new StringBuilder();
        sql.append(" select employee_id    ");
        sql.append("        ,first_name    ");
        sql.append("        ,last_name     ");
        sql.append("        ,salary        ");
        sql.append("        ,hire_date     ");
        sql.append(" from tb_sample        ");
        ResultSet rs = null;
        ArrayList<EmpDTO> arr = new ArrayList<>();
        //try with resources 안에 ResultSet 을 넣을 수 없다.
        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        ){
          //pstmt.setString(1,"blabla");
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
        }catch (Exception e){
            System.out.println(e);
        } finally {
            if(rs !=null) try{rs.close();} catch (SQLException e){}
        }
        return arr;
    }

    public void insertData(EmpDTO dto) {
        StringBuilder sql = new StringBuilder();
        sql.append(" insert into tb_sample  ");
        sql.append(" values (?, ?, ?, ?, ?) ");

        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        ){
          pstmt.setInt(1,dto.getEmployee_id());
          pstmt.setString(2,dto.getFirst_name());
          pstmt.setString(3,dto.getLast_name());
          pstmt.setFloat(4,dto.getSalary());
          pstmt.setDate(5, Date.valueOf(dto.getHire_date()));
          pstmt.executeUpdate();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public EmpDTO detailData(int emp_no) {
        StringBuilder sql = new StringBuilder();
        sql.append(" select employee_id    ");
        sql.append("        ,first_name    ");
        sql.append("        ,last_name     ");
        sql.append("        ,salary        ");
        sql.append("        ,hire_date     ");
        sql.append(" from tb_sample        ");
        sql.append(" where employee_id = ? ");
        ResultSet rs = null;
        EmpDTO dto = new EmpDTO();
        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        ){
            pstmt.setInt(1, emp_no);
            rs = pstmt.executeQuery();
            while (rs.next()){
                dto.setEmployee_id(rs.getInt("employee_id"));
                dto.setFirst_name(rs.getString("first_name"));
                dto.setLast_name(rs.getString("last_name"));
                dto.setSalary(rs.getFloat("salary"));
                dto.setHire_date(rs.getDate("hire_date").toLocalDate());
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return dto;
    }

    public int deleteData(int emp_no) {
        StringBuilder sql = new StringBuilder();
        sql.append(" delete from tb_sample    ");
        sql.append(" where employee_id = ?    ");
        EmpDTO dto = new EmpDTO();
        int result=0;
        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        ){
            pstmt.setInt(1, emp_no);
            result = pstmt.executeUpdate();
        } catch (Exception e){
            System.out.println(e);
        }
        return result;
    }

    public int modifyData(EmpDTO dto) {
        StringBuilder sql = new StringBuilder();
        sql.append(" update tb_sample      ");
        sql.append(" set first_name = ?    ");
        sql.append("     ,last_name = ?    ");
        sql.append("     ,salary = ?       ");
        sql.append(" where employee_id = ? ");
        int result=0;
        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        ){
            pstmt.setString(1, dto.getFirst_name());
            pstmt.setString(2,dto.getLast_name());
            pstmt.setFloat(3,dto.getSalary());
            pstmt.setInt(4,dto.getEmployee_id());
            result = pstmt.executeUpdate();
        } catch (Exception e){
            System.out.println(e);
        }
        return result;
    }
}
