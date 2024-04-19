package com.chunjae.dao;

import com.chunjae.dto.ReplyDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReplyDAO {
    private static ReplyDAO replyDAO = new ReplyDAO();
    private ReplyDAO() {
    }

    public static ReplyDAO getReplyDAO() {
        return replyDAO;
    }

    public void insertReply(Connection conn, ReplyDTO repdto) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" INSERT INTO subboard ( subcontent ");
        sql.append("                        ,writer    ");
        sql.append("                        ,boardno ) ");
        sql.append(" VALUES ( ? ,? ,? )                ");
        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
            pstmt.setString(1,repdto.getSubcontent());
            pstmt.setString(2,repdto.getWriter());
            pstmt.setInt(3,repdto.getBoardno());
            pstmt.executeUpdate();
        }
    }

    public List<ReplyDTO> findReplyList(Connection conn, int bno) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT subno        ");
        sql.append("        , subcontent ");
        sql.append("        , writer     ");
        sql.append(" FROM subboard       ");
        sql.append(" WHERE boardno = ?   ");
        ResultSet rs = null;
        ArrayList<ReplyDTO> replist = new ArrayList<>();
        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
            pstmt.setInt(1,bno);
            rs = pstmt.executeQuery();
            while(rs.next()){
                ReplyDTO dto = new ReplyDTO();
                dto.setSubno(rs.getInt("subno"));
                dto.setSubcontent(rs.getString("subcontent"));
                dto.setWriter(rs.getString("writer"));
                replist.add(dto);
            }
        }finally {
            if(rs !=null)try{rs.close();}catch (Exception e){}
        }
        return replist;
    }

    public void deleteReply(Connection conn, int subno) throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append(" DELETE FROM subboard ");
        sql.append(" WHERE subno = ?      ");
        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
            pstmt.setInt(1,subno);
            pstmt.executeUpdate();
        }
    }

    public void updateReply(Connection conn, ReplyDTO dto) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE subboard      ");
        sql.append(" SET writer = ?       ");
        sql.append("     , subcontent = ? ");
        sql.append(" WHERE subno = ?      ");
        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
            pstmt.setString(1,dto.getWriter());
            pstmt.setString(2,dto.getSubcontent());
            pstmt.setInt(3,dto.getSubno());
            pstmt.executeUpdate();
        }
    }
}
