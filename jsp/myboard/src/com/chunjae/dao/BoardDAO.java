package com.chunjae.dao;

import com.chunjae.dto.BoardDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
    private static BoardDAO dao = new BoardDAO();
    public static BoardDAO getDao() {
        return dao;
    }
    private BoardDAO() {
    }
    public List<BoardDTO> findAll(Connection conn) throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT boardno   ");
        sql.append("       ,title     ");
        sql.append("       ,writer    ");
        sql.append("       ,writedate ");
        sql.append("       ,readno    ");
        sql.append(" FROM myboard     ");
        ResultSet rs = null;
        ArrayList<BoardDTO> list = new ArrayList<>();
        try(PreparedStatement pstmt= conn.prepareStatement(sql.toString());){
            rs = pstmt.executeQuery();
            while(rs.next()){
                BoardDTO dto = new BoardDTO();
                dto.setBoardno(rs.getInt("boardno"));
                dto.setTitle(rs.getString("title"));
                dto.setWriter(rs.getString("writer"));
                dto.setWritedate(rs.getDate("writedate").toLocalDate());
                dto.setReadno(rs.getInt("readno"));
                list.add(dto);
            }
        }finally {
            if(rs!=null)try{rs.close();}catch (Exception e){}
        }
        return list;
    }

    public BoardDTO findOne(Connection conn, int boardno) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT boardno    ");
        sql.append("       ,title      ");
        sql.append("       ,content    ");
        sql.append("       ,writer     ");
        sql.append("       ,writedate  ");
        sql.append("       ,readno     ");
        sql.append(" FROM myboard      ");
        sql.append(" WHERE boardno = ? ");
        ResultSet rs = null;
        BoardDTO dto = new BoardDTO();
        try(PreparedStatement pstmt= conn.prepareStatement(sql.toString());){
            pstmt.setInt(1,boardno);
            rs = pstmt.executeQuery();
            while(rs.next()){
                dto.setBoardno(rs.getInt("boardno"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setWriter(rs.getString("writer"));
                dto.setWritedate(rs.getDate("writedate").toLocalDate());
                dto.setReadno(rs.getInt("readno"));
            }
        }finally {
            if(rs!=null)try{rs.close();}catch (Exception e){}
        }
        return dto;
    }
    public void addReadCount(Connection conn,int boardno) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE myboard               ");
        sql.append(" SET readno = nvl(readno,0)+1 ");
        sql.append(" WHERE boardno = ?            ");
        try(PreparedStatement pstmt= conn.prepareStatement(sql.toString());){
            pstmt.setInt(1,boardno);
            pstmt.executeUpdate();
        }
    }

    public void insertBoard(Connection conn, BoardDTO dto) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" INSERT INTO myboard ( title       ");
        sql.append("                      ,content     ");
        sql.append("                      ,writer      ");
        sql.append("                      ,writedate ) ");
        sql.append(" VALUES ( ? ,? ,? ,DATE(NOW()) )   ");
        try(PreparedStatement pstmt= conn.prepareStatement(sql.toString());){
            pstmt.setString(1,dto.getTitle());
            pstmt.setString(2,dto.getContent());
            pstmt.setString(3,dto.getWriter());
            pstmt.executeUpdate();
        }
    }

    public void updateBoard(Connection conn, BoardDTO dto) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE myboard    ");
        sql.append(" SET title = ?     ");
        sql.append("    , content = ?  ");
        sql.append(" WHERE boardno = ? ");
        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
            pstmt.setString(1,dto.getTitle());
            pstmt.setString(2,dto.getContent());
            pstmt.setInt(3,dto.getBoardno());
            pstmt.executeUpdate();
        }
    }

    public void deleteBoard(Connection conn, int boardno) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" DELETE FROM myboard ");
        sql.append(" WHERE boardno = ?   ");
        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
            pstmt.setInt(1,boardno);
            pstmt.executeUpdate();
        }
    }
}
