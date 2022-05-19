package com.githrd.jennie.controller.reboard;

import com.githrd.jennie.controller.BlpInter;
import com.githrd.jennie.dao.ReboardDao;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReboardCommentProc implements BlpInter {
    @Override
    public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("isRedirect", true);
        String view = "/jennie/reboard/reboardList.blp";

        String sid = (String) req.getSession().getAttribute("SID");
        if (sid == null) {
            view = "/jennie/member/login.blp";
            return view;
        }
        int mno = Integer.parseInt(req.getParameter("mno"));
        int bno = Integer.parseInt(req.getParameter("upno"));
        String spage = req.getParameter("nowPage");
        String body = req.getParameter("body");

        ReboardDao rDao = new ReboardDao();
        int cnt = rDao.addReboard(bno, mno, body);

        if (cnt != 1) {
            req.setAttribute("isRedirect", false);
            req.setAttribute("nowPage", spage);
            req.setAttribute("VIEW", "/jennie/reboard/reboardComment.blp");
            return "/reboard/redirect";
        }
        return view;
    }
}
