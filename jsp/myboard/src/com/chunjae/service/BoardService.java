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
   mvc2에서는 DAO 에서 db connection 과 sql method 를 모두 동작시키고 있는데,
   autoCommit 으로 설정되어 있는경우 transaction 의 원자성 측면에서 문제가 발생할 수 있다.
   그래서 db connection 클래스를 따로 만들어 service 단의 각각의 메서드에서 연결을 시도한다.
   connection 일체의 작업이 동시에 이루어지지 못하도록, db connection class 와 service, dao 는 모두 싱글톤 패턴을 사용.
*/
public class BoardService {
    private static BoardService service = new BoardService();

    public static BoardService getService() {
        return service;
    }
    private BoardService() {
    }
    public List<BoardDTO> findAll(){
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        List<BoardDTO> boardList = new ArrayList<>();
        try{
            conn= db.getConnection();
            conn.setAutoCommit(false);
            BoardDAO dao = BoardDAO.getDao();
            boardList = dao.findAll(conn);
            conn.commit();
        }catch (SQLException | NamingException e){
            try{conn.rollback();}catch (SQLException e2){
                System.out.println(e2);
            }
            System.out.println(e);
        } finally {
            if(conn!=null)try{conn.close();}catch (Exception e){}
        }
        return boardList;
    }

    public BoardDTO findOne(int boardno) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        BoardDTO board = new BoardDTO();
        try{
            conn= db.getConnection();
            conn.setAutoCommit(false);
            BoardDAO dao = BoardDAO.getDao();
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
}
