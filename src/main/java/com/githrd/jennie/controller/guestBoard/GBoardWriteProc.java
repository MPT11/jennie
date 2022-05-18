package com.githrd.jennie.controller.guestBoard;

import com.githrd.jennie.controller.*;
import com.githrd.jennie.dao.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class GBoardWriteProc implements BlpInter {
    @Override
    public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("isRedirect", true);
        String view = "/jennie/guestBoard/gBoardList.blp";
        //세션 검사
        String sid = (String) req.getSession().getAttribute("SID");
        if (sid == null) {
            return "/jennie/member/login.blp";
        }
        //파라미터 꺼내기
        String spage = req.getParameter("nowPage");
        String sbody = req.getParameter("body");
        //글 등록여부 검사
        GBoardDao gDao = new GBoardDao();
        int cnt = gDao.getWriteCount(sid);
        //현재 보는 페이지 요청객체에 등록
        req.setAttribute("NOWPAGE", spage);
        if (cnt != 0) {
            //get 방식
            //return "/jennie/guestBoard/gBoardList.blp?nowPage=" + spage;
            //post 방식
            req.setAttribute("isRedirect", false);

            //불러올 뷰를 요청객체에 등록
            req.setAttribute("VIEW", "/jennie/guestBoard/gBoardList.blp");
            return "/guestBoard/redirect";
        }

        //데이터베이스 작업하고 결과받고
        int result = gDao.addGBoard(sid, sbody);
        //결과에 따라서 뷰 작성하고
        if (result != 1) {
            //get 방식
            //return "/jennie/guestBoard/gBoardWrite.blp?nowPage=" + spage;
            //post 방식
            req.setAttribute("isRedirect", false);
            req.setAttribute("VIEW", "/jennie/guestBoard/gBoardWrite.blp");
            return "/guestBoard/redirect";
        }
        req.setAttribute("nowPage", spage);

        return view;
    }
}
