package com.chunjae.service;

import com.chunjae.comm.DBConnection;
import com.chunjae.dao.BoardDAO;
import com.chunjae.dto.BoardDTO;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/*
   mvc2에서는 dao 단에서 db connection 과 sql method 를 모두 동작시키고 있는데,
   autoCommit 으로 설정되어 있는경우 transaction 의 원자성 측면에서 문제가 발생할 수 있다.
   한 요청에 두 개의 dao 메서드 작업을 해야하는 경우는 두 작업을 한번에 commit 해야 하는 상황.
   그래서 db connection 클래스를 따로 만들어 service 단의 각각의 메서드에서 연결을 시도한다.
   dao 단의 메서드는 하나의 sql 기능을 수행하는 것이고
   service 단의 메서드는 dao 메서드들의 commit 단위를 관리하는 곳이 된다.
*/
public class BoardService {
    private static BoardService service = new BoardService();

    public static BoardService getService() {
        return service;
    }
    private BoardService() {
    }
    public List<BoardDTO> readBoardList(){
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        List<BoardDTO> boardList = new ArrayList<>();
        try{
            conn= db.getConnection();
            BoardDAO dao = BoardDAO.getDao();
            boardList = dao.findAll(conn);
        }catch (SQLException | NamingException e){
            System.out.println(e);
        } finally {
            if(conn!=null)try{conn.close();}catch (Exception e){}
        }
        return boardList;
    }

    public BoardDTO readBoard(int boardno) {
        // 이 메서드에서 dao 메서드를 2개 호출한다.
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        BoardDTO board = new BoardDTO();
        try{
            conn= db.getConnection();
            conn.setAutoCommit(false);
            BoardDAO dao = BoardDAO.getDao();
            dao.addReadCount(conn,boardno);
            // exception 처리를 여기서 하는게 좋은지, dao 메서드에서 하는게 좋은지에 대해.
            // 여기가 commit 단위를 관리하는 곳이므로 여기서 처리를 하는 것이 좋겠다.
            board = dao.findOne(conn,boardno);
            conn.commit();
        }catch (SQLException | NamingException e){
            try{conn.rollback();}catch (SQLException e2){
                System.out.println(e2);
            }
            System.out.println(e);
        } finally {
            if(conn!=null)try{conn.close();}catch (Exception e){}
        }
        return board;
    }
    public void writeBoard(BoardDTO dto) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        try{
            conn= db.getConnection();
            BoardDAO dao = BoardDAO.getDao();
            dao.insertBoard(conn,dto);
        }catch (SQLException | NamingException e){
            System.out.println(e);
        } finally {
            if(conn!=null)try{conn.close();}catch (Exception e){}
        }
    }
    public BoardDTO updateBoard(BoardDTO dto) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        BoardDTO board = new BoardDTO();
        try{
            conn = db.getConnection();
            conn.setAutoCommit(false);
            BoardDAO dao = BoardDAO.getDao();
            dao.updateBoard(conn,dto);
            board = dao.findOne(conn,dto.getBoardno());
            conn.commit();
        }catch (SQLException|NamingException e){
            try{conn.rollback();}catch (SQLException e2){
                System.out.println(e2);
            }
            System.out.println(e);
        }finally {
            if(conn!=null)try{conn.close();}catch (Exception e){}
        }
        return board;
    }
    public void deleteBoard(int boardno) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        try{
            conn = db.getConnection();
            BoardDAO dao = BoardDAO.getDao();
            dao.deleteBoard(conn,boardno);
        }catch (SQLException|NamingException e){
            System.out.println(e);
        }finally {
            if(conn!=null)try{conn.close();}catch (Exception e){}
        }
    }
}
