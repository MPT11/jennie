package com.githrd.jennie.controller.reboard;

import com.githrd.jennie.controller.BlpInter;
import com.githrd.jennie.dao.ReboardDao;
import com.githrd.jennie.vo.BoardVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReboardComment implements BlpInter {
    @Override
    public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String view = "/reboard/reboardComment";
        String sid = (String) req.getSession().getAttribute("SID");
        if (sid == null) {
            req.setAttribute("isRedirect", true);
            view = "/jennie/member/login.blp";
            return view;
        }
        String spage = req.getParameter("nowPage");
        int bno = Integer.parseInt(req.getParameter("bno"));
        ReboardDao rDao = new ReboardDao();
        BoardVO bvo = rDao.getReboardInfo(bno, sid);

        req.setAttribute("DATA", bvo);
        req.setAttribute("nowPage", spage);
        
        return view;
    }
}
