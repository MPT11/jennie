package com.githrd.jennie.controller.reboard;

import com.githrd.jennie.controller.BlpInter;
import com.githrd.jennie.dao.ReboardDao;
import com.githrd.jennie.vo.BoardVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReboardWrite implements BlpInter {
    @Override
    public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String view = "/reboard/reboardWrite";
        String sid = (String) req.getSession().getAttribute("SID");
        if (sid == null) {
            req.setAttribute("isRedirect", true);
            view = "/jennie/member/login.blp";
            return view;
        }
        ReboardDao rDao = new ReboardDao();
        BoardVO bvo = rDao.getWriterInfo(sid);

        req.setAttribute("DATA", bvo);

        return view;
    }
}
