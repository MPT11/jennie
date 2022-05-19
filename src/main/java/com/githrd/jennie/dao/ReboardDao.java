package com.githrd.jennie.dao;

import com.githrd.jennie.db.*;
import com.githrd.jennie.sql.*;
import com.githrd.jennie.util.*;
import com.githrd.jennie.vo.*;
import java.sql.*;
import java.util.*;


public class ReboardDao {
    private BlpDBCP db;
    private ReboradSQL rsql;
    private Connection con;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public ReboardDao() {
        db = new BlpDBCP();
        rsql = new ReboradSQL();
    }

    // 게시글 리스트 조회 전담 처리함수
    public ArrayList<BoardVO> getList(PageUtil page) {
        ArrayList<BoardVO> list = new ArrayList<BoardVO>();
        con = db.getCon();
        String sql = rsql.getSQL(rsql.SEL_ALL_LIST);
        pstmt = db.getPSTMT(con, sql);
        try {
            pstmt.setInt(1, page.getStartCont());
            pstmt.setInt(2, page.getEndCont());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                BoardVO bvo = new BoardVO();
                bvo.setRno(rs.getInt("rno"));
                bvo.setBno(rs.getInt("rbno"));
                bvo.setUpno(rs.getInt("upno"));
                bvo.setMno(rs.getInt("mno"));
                bvo.setId(rs.getString("id"));
                bvo.setBody(rs.getString("body"));
                bvo.setAvatar(rs.getString("savename"));
                bvo.setWdate(rs.getDate("wdate"));
                bvo.setWtime(rs.getTime("wdate"));
                bvo.setStep(rs.getInt("step"));
                bvo.setSdate();

                list.add(bvo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close(rs);
            db.close(pstmt);
            db.close(con);
        }
        return list;
    }

    // 총 게시글 수 조회 전담 처리함수
    public int getTotalCount() {
        int cnt = 0;
        con = db.getCon();
        String sql = rsql.getSQL(rsql.SEL_TOTAL_CNT);
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

    // 작성자 정보조회 전담 처리함수
    public BoardVO getWriterInfo(String id) {
        BoardVO bvo = new BoardVO();
        con = db.getCon();
        String sql = rsql.getSQL(rsql.SEL_WRITER_INFO);
        pstmt = db.getPSTMT(con, sql);
        try {
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            rs.next();
            bvo.setMno(rs.getInt("mno"));
            bvo.setAvatar(rs.getString("SAVENAME"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close(rs);
            db.close(pstmt);
            db.close(con);
        }
        return bvo;
    }

    // 원글등록 데이터베이스작업 전담 처리함수
    public int addReboard(int mno, String body) {
        int cnt = 0;
        con = db.getCon();
        String sql = rsql.getSQL(rsql.INS_REBOARD);
        pstmt = db.getPSTMT(con, sql);
        try {
            pstmt.setNull(1, Types.NULL);
            pstmt.setInt(2, mno);
            pstmt.setString(3, body);
            cnt = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close(pstmt);
            db.close(con);
        }
        return cnt;
    }

    // 댓글 데이터베이스작업 전담 처리함수
    public int addReboard(int upno, int mno, String body) {
        int cnt = 0;
        con = db.getCon();
        String sql = rsql.getSQL(rsql.INS_REBOARD);
        pstmt = db.getPSTMT(con, sql);
        try {
            pstmt.setInt(1, upno);
            pstmt.setInt(2, mno);
            pstmt.setString(3, body);
            cnt = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close(pstmt);
            db.close(con);
        }
        return cnt;
    }

    // 댓글 쓰기 사용데이터 조회 전담 처리함수
    public BoardVO getReboardInfo(int bno, String id) {
        BoardVO bvo = new BoardVO();
        con = db.getCon();
        String sql = rsql.getSQL(rsql.SEL_REBOARD_INFO);
        pstmt = db.getPSTMT(con, sql);
        try {
            pstmt.setInt(1, bno);
            pstmt.setString(2, id);
            rs = pstmt.executeQuery();
            rs.next();
            bvo.setBno(rs.getInt("rbno"));
            String body = rs.getString("body");
            if (body.length() >= 10) {
                body.substring(0, 10);
            }
            bvo.setBody(body);
            bvo.setMno(rs.getInt("mno"));
            bvo.setId(rs.getString("id"));
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
}
