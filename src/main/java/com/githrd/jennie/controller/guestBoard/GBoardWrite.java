package com.githrd.jennie.controller.guestBoard;

import com.githrd.jennie.controller.BlpInter;
import com.githrd.jennie.dao.GBoardDao;
import com.githrd.jennie.vo.BoardVO;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class GBoardWrite implements BlpInter {
    @Override
    public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String view = "/guestBoard/gBoardWrite";
        //세션검사
        HttpSession session = req.getSession();
        String sid = (String) session.getAttribute("SID");
        if (sid == null) {
            req.setAttribute("isRedirect", true);
            return "/jennie/member/login.blp";
        }
        //작성게시글 검사
        String spage = req.getParameter("nowPage");
        GBoardDao gDao = new GBoardDao();
        int cnt = gDao.getWriteCount(sid);
        if (cnt == 1) {
            req.setAttribute("isRedirect", true);
            return "/jennie/guestBoard/gBoardList.blp?nowPage=" + spage; // get 방식으로 요청
        }

        BoardVO bvo = gDao.getWriterInfo(sid);
        req.setAttribute("DATA", bvo);

        return view;
    }
}
