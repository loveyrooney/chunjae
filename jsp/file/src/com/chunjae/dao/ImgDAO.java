package com.chunjae.dao;

import com.chunjae.dto.ImgDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ImgDAO {
    private static ImgDAO dao = new ImgDAO();

    public static ImgDAO getDao() {
        return dao;
    }

    public void insertBoard(Connection conn, ImgDTO dto) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" INSERT INTO imgboard ( btitle    ");
        sql.append("                        ,bcontent ");
        sql.append("                        ,bimg )   ");
        sql.append(" VALUES (? ,? ,?)                 ");
        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
            pstmt.setString(1,dto.getBtitle());
            pstmt.setString(2,dto.getBcontent());
            pstmt.setString(3,dto.getBimg());
            pstmt.executeUpdate();
        }
    }

    public ArrayList<ImgDTO> findImgList(Connection conn) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT bno     ");
        sql.append("        ,btitle ");
        sql.append("        ,readno ");
        sql.append(" FROM imgboard  ");
        ResultSet rs = null;
        ArrayList<ImgDTO> list = new ArrayList<>();
        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
            rs = pstmt.executeQuery();
            while(rs.next()){
                ImgDTO dto = new ImgDTO();
                dto.setBno(rs.getInt("bno"));
                dto.setBtitle(rs.getString("btitle"));
                dto.setReadno(rs.getInt("readno"));
                list.add(dto);
            }
        }finally {
            if(rs!=null)try{rs.close();}catch (Exception e){}
        }
        return list;
    }

    public ImgDTO findImgBoard(Connection conn, int bno) throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT bno       ");
        sql.append("        ,btitle   ");
        sql.append("        ,bcontent ");
        sql.append("        ,bimg     ");
        sql.append("        ,readno   ");
        sql.append(" FROM imgboard    ");
        sql.append(" WHERE bno = ?    ");
        ResultSet rs = null;
        ImgDTO dto = new ImgDTO();
        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
            pstmt.setInt(1,bno);
            rs = pstmt.executeQuery();
            while(rs.next()){
                dto.setBno(rs.getInt("bno"));
                dto.setBtitle(rs.getString("btitle"));
                dto.setBcontent(rs.getString("bcontent"));
                dto.setBimg(rs.getString("bimg"));
                dto.setReadno(rs.getInt("readno"));
            }
        }finally {
            if(rs !=null)try{rs.close();}catch (Exception e){}
        }
        return dto;
    }

    public void countBoard(Connection conn, int bno) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE imgboard              ");
        sql.append(" SET readno = nvl(readno,0)+1 ");
        sql.append(" WHERE bno = ?                ");
        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
            pstmt.setInt(1,bno);
            pstmt.executeUpdate();
        }
    }
}
