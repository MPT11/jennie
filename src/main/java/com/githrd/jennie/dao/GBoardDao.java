package com.githrd.jennie.dao;

import java.sql.*;
import java.util.*;
import java.util.Date;

import com.githrd.jennie.db.*;
import com.githrd.jennie.sql.*;
import com.githrd.jennie.util.PageUtil;
import com.githrd.jennie.vo.*;

public class GBoardDao {
    private BlpDBCP db;
    private Connection con;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private GBoardSQL gSQL;

    public GBoardDao() {
        // 커넥션 풀 찾고
        db = new BlpDBCP();
        // 질의명령 준비
        gSQL = new GBoardSQL();
    }

    // 게시글 리스트 가져오기 전담 처리함수
    public ArrayList<BoardVO> getGBoardList(PageUtil page){
        ArrayList<BoardVO> list = new ArrayList<BoardVO>();
        // 커넥션
        con =db.getCon();
        // 질의명령
        String sql = gSQL.getSQL(gSQL.SEL_GBRD_LIST);
        // 명령전달도구
        pstmt = db.getPSTMT(con, sql);
        try {
            // 질의명령 완성(페이징처리)
            pstmt.setInt(1, page.getStartCont());
            pstmt.setInt(2, page.getEndCont());
            // 질의명령 보내고 결과 받고
            rs = pstmt.executeQuery();
            while(rs.next()) {
                // 결과에서 꺼내서 VO에 담고
                BoardVO bVO = new BoardVO();
                int rno = rs.getInt("rno");
                int bno = rs.getInt("gno");
                String id = rs.getString("id");
                String body = rs.getString("body");
                String avatar = rs.getString("savename");
                Date wdate = rs.getDate("wdate");
                Time wtime = rs.getTime("wdate");
                // vo에 채우고
                bVO.setRno(rno);
                bVO.setBno(bno);
                bVO.setId(id);
                bVO.setBody(body.replaceAll("\r\n", "<br>"));
                bVO.setAvatar(avatar);
                bVO.setWdate(wdate);
                bVO.setWtime(wtime);
                bVO.setSdate();

                // VO를 list에 담고
                list.add(bVO);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            db.close(rs);
            db.close(pstmt);
            db.close(con);
        }
        // list 반환하고
        return list;
    }

    // 작성한 게시글 수 조회 전담 처리함수
    public int getWriteCount(String id) {
        int cnt = 0;
        con = db.getCon();
        String sql = gSQL.getSQL(gSQL.SEL_WRITE_CNT);
        pstmt = db.getPSTMT(con, sql);
        try {
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            rs.next();
            cnt = rs.getInt("cnt");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close(rs);
            db.close(pstmt);
            db.close(con);
        }
        return cnt;
    }

    //총 게시글 수 조회 전담 처리함수
    public int getTotalCnt() {
        int cnt = 0;
        con = db.getCon();
        String sql = gSQL.getSQL(gSQL.SEL_TOTAL_CNT);
        stmt = db.getSTMT(con);
        try {
            rs = stmt.executeQuery(sql);
            rs.next();
            cnt = rs.getInt("cnt");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close(rs);
            db.close(stmt);
            db.close(con);
        }

        return cnt;
    }

    //작성자 정보조회 전담 처리함수
    public BoardVO getWriterInfo(String id) {
        BoardVO bvo = new BoardVO();
        con = db.getCon();
        String sql = gSQL.getSQL(gSQL.SEL_WRITER_INFO);
        pstmt = db.getPSTMT(con, sql);
        try {
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            rs.next();
            bvo.setMno(rs.getInt("mno"));
            bvo.setAvatar(rs.getString("savename"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close(rs);
            db.close(pstmt);
            db.close(con);
        }
        return bvo;
    }

    // 게시글 데이터베이스 등록 전담 처리함수
    public int addGBoard(String id , String body) {
        int cnt = 0;
        con = db.getCon();
        String sql = gSQL.getSQL(gSQL.INS_GBOARD);
        pstmt = db.getPSTMT(con, sql);
        try {
            pstmt.setString(1, id);
            pstmt.setString(2, body);
            cnt = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close(pstmt);
            db.close(con);
        }
        return cnt;
    }

}