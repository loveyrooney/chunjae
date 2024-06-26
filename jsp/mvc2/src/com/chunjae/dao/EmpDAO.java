package com.chunjae.dao;

import com.chunjae.dto.EmpDTO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
    private static EmpDAO instance = new EmpDAO();

    public static EmpDAO getInstance() {
        return instance;
    }
    private EmpDAO() {
    }
    private Connection getConnection(){
        Connection conn = null;
        try{
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/myDB");
            conn = ds.getConnection();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public int countEmp(String search, String input) {
        int result = 0;
        StringBuilder sql = new StringBuilder();
        sql.append(" select count(*)         ");
        sql.append(" from tb_sample          ");
        if(!"".equals(search) && !"".equals(input)){
            if("employee_id".equals(search))
                sql.append(" where employee_id = ?   ");
            else if("first_name".equals(search))
                sql.append(" where first_name like ? ");
            else
                sql.append(" where hire_date like ?  ");
        }
        ResultSet rs = null;
        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
            if(!"".equals(search) && !"".equals(input)){
                if("employee_id".equals(search))
                    pstmt.setInt(1,Integer.parseInt(input));
                else
                    pstmt.setString(1,"%"+input+"%");
            }
            rs = pstmt.executeQuery();
            while(rs.next()){
                result = rs.getInt(1);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            if(rs != null) try{rs.close();}catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return result;
    }

    public List<EmpDTO> findEmpList(int startRow, int pageSize, String search, String input) {
        StringBuilder sql = new StringBuilder();
        sql.append(" select employee_id      ");
        sql.append("        ,first_name      ");
        sql.append("        ,last_name       ");
        sql.append("        ,salary          ");
        sql.append("        ,hire_date       ");
        sql.append(" from tb_sample          ");
        if(!"".equals(search) && !"".equals(input)){
            if("employee_id".equals(search))
                sql.append(" where employee_id = ?   ");
            else if("first_name".equals(search))
                sql.append(" where first_name like ? ");
            else
                sql.append(" where hire_date like ?  ");
        }
        sql.append(" limit ? , ?             ");
        ResultSet rs = null;
        ArrayList<EmpDTO> list = new ArrayList<>();
        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
            if(!"".equals(search) && !"".equals(input)){
                if("employee_id".equals(search))
                    pstmt.setInt(1,Integer.parseInt(input));
                else
                    pstmt.setString(1,"%"+input+"%");
                pstmt.setInt(2, startRow);
                pstmt.setInt(3, pageSize);
            } else {
                pstmt.setInt(1, startRow);
                pstmt.setInt(2, pageSize);
            }
            rs = pstmt.executeQuery();
            while(rs.next()){
                EmpDTO dto = new EmpDTO();
                dto.setEmployee_id(rs.getInt("employee_id"));
                dto.setFirst_name(rs.getString("first_name"));
                dto.setLast_name(rs.getString("last_name"));
                dto.setSalary(rs.getFloat("salary"));
                dto.setHire_date(rs.getDate("hire_date").toLocalDate());
                list.add(dto);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            if(rs !=null) try{rs.close();}catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return list;
    }

    public EmpDTO findEmp(int emp_no) {
        StringBuilder sql = new StringBuilder();
        sql.append(" select employee_id      ");
        sql.append("        ,first_name      ");
        sql.append("        ,last_name       ");
        sql.append("        ,salary          ");
        sql.append("        ,hire_date       ");
        sql.append(" from tb_sample          ");
        sql.append(" where employee_id = ?   ");
        ResultSet rs = null;
        EmpDTO dto = new EmpDTO();
        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
            pstmt.setInt(1,emp_no);
            rs = pstmt.executeQuery();
            while(rs.next()){
                dto.setEmployee_id(rs.getInt("employee_id"));
                dto.setFirst_name(rs.getString("first_name"));
                dto.setLast_name(rs.getString("last_name"));
                dto.setSalary(rs.getFloat("salary"));
                dto.setHire_date(rs.getDate("hire_date").toLocalDate());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            if(rs !=null)try{rs.close();}catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return dto;
    }

    public void deleteEmp(int emp_no) {
        StringBuilder sql = new StringBuilder();
        sql.append(" delete from tb_sample ");
        sql.append(" where employee_id = ? ");
        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
            pstmt.setInt(1,emp_no);
            pstmt.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void insertEmp(EmpDTO dto) {
        StringBuilder sql = new StringBuilder();
        sql.append(" insert into tb_sample(employee_id ,first_name ,last_name ,salary ,hire_date) ");
        sql.append(" values(? ,? ,? ,? ,?) ");
        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
            pstmt.setInt(1,dto.getEmployee_id());
            pstmt.setString(2,dto.getFirst_name());
            pstmt.setString(3,dto.getLast_name());
            pstmt.setFloat(4,dto.getSalary());
            pstmt.setDate(5, Date.valueOf(dto.getHire_date()));
            pstmt.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void updateEmp(EmpDTO dto) {
        StringBuilder sql = new StringBuilder();
        sql.append(" update tb_sample      ");
        sql.append(" set first_name = ?    ");
        sql.append("     , last_name = ?   ");
        sql.append("     , salary = ?      ");
        sql.append("     , hire_date = ?   ");
        sql.append(" where employee_id = ? ");
        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
            pstmt.setString(1,dto.getFirst_name());
            pstmt.setString(2,dto.getLast_name());
            pstmt.setFloat(3,dto.getSalary());
            pstmt.setDate(4, Date.valueOf(dto.getHire_date()));
            pstmt.setInt(5,dto.getEmployee_id());
            pstmt.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
