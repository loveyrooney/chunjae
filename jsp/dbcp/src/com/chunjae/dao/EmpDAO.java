package com.chunjae.dao;

import com.chunjae.dto.EmpDTO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
    // 외부에서 DAO에 접근하지 못하도록 싱글톤 패턴으로 사용한다.
    private static EmpDAO instance = new EmpDAO();
    private EmpDAO(){}
    public static EmpDAO getInstance(){
        return instance;
    }
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private void getConn() {
        try {
            Context initContext = new InitialContext();
            // lookup 은 Object 를 리턴하므로 형변환
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            // lookup 안에는 context resource 의 name 이 들어가야 한다.
            DataSource ds = (DataSource)envContext.lookup("jdbc/myDB");
            conn = ds.getConnection();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
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
        System.out.println("getList search : "+col+","+input);
        ArrayList<EmpDTO> dtoList = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
                sql.append(" SELECT *                 ");
                sql.append(" FROM tb_sample           ");
//        if(!"".equals(col) && !"".equals(input)) {
//            if ("employee_id".equals(col))
//                sql.append(" where employee_id = " + input + "          ");
//            else if ("first_name".equals(col))
//                sql.append(" where first_name like" + "'%" + input + "%'  ");
//            else if ("hire_date".equals(col))
//                sql.append(" where hire_date = " + "'" + input + "'       ");
//            else
//                sql.append(" where year(hire_date) = " + "'" + input + "' ");
//        }
        if(!"".equals(col) && !"".equals(input)) {
            if ("employee_id".equals(col))
                sql.append(" WHERE employee_id = ?     ");
            else if ("first_name".equals(col))
                sql.append(" WHERE first_name LIKE ?   ");
            else if ("hire_date".equals(col))
                sql.append(" WHERE hire_date LIKE ?    ");
            else
                sql.append(" WHERE YEAR(hire_date) = ? ");
        }
                sql.append(" LIMIT ?,? ");
        try {
            getConn();
            pstmt = conn.prepareStatement(sql.toString());
            // pstmt 의 set 메서드들은 값의 타입을 결정해 주므로 sql 쿼리문에서 문자열은 '' 처리를 해준다.
            if (!"".equals(col) && !"".equals(input)){
                if ("employee_id".equals(col))
                    pstmt.setInt(1,Integer.parseInt(input));
                else if ("first_name".equals(col))
                    pstmt.setString(1,"%"+input+"%");
                else if ("hire_date".equals(col))
                    pstmt.setString(1,"%"+input+"%");
                else
                    pstmt.setInt(1,Integer.parseInt(input));
                pstmt.setInt(2,startRow);
                pstmt.setInt(3,pageSize);
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
        int result = 0;
        StringBuilder sql = new StringBuilder();
                sql.append(" SELECT COUNT(*)                ");
                sql.append(" FROM tb_sample                 ");
        if(!"".equals(col) && !"".equals(input)) {
            if ("employee_id".equals(col))
                sql.append(" WHERE employee_id = ?          ");
            else if ("first_name".equals(col))
                sql.append(" WHERE first_name LIKE ?        ");
            else if ("hire_date".equals(col))
                sql.append(" WHERE hire_date LIKE ?         ");
            else
                sql.append(" WHERE YEAR(hire_date) = ?      ");
        }
        try {
            getConn();
            pstmt = conn.prepareStatement(sql.toString());
            if (!"".equals(col) && !"".equals(input)){
                if ("employee_id".equals(col))
                    pstmt.setInt(1,Integer.parseInt(input));
                else if ("first_name".equals(col))
                    pstmt.setString(1,"%"+input+"%");
                else if ("hire_date".equals(col))
                    pstmt.setString(1,"%"+input+"%");
                else
                    pstmt.setInt(1,Integer.parseInt(input));
            }
            rs = pstmt.executeQuery();
            while(rs.next()){
                result = rs.getInt(1);
            }
            System.out.println("count: "+result);
        } catch (Exception e){
            System.out.println("getCount: "+e.getMessage());
        } finally {
            disConn(rs,pstmt,conn);
        }
        return result;
    }

}
