package com.githrd.jennie.controller.member;

import com.githrd.jennie.controller.BlpInter;
import com.githrd.jennie.dao.MemberDao;
import com.githrd.jennie.vo.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyInfo implements BlpInter {
    @Override
    public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String id = (String) session.getAttribute("SID");
        String view = "/member/memberInfo";
        if (id == null) {
            req.setAttribute("isRedirect", true);
            view = "/jennie/member/login.blp";
            return view;
        }

        MemberDao mDao = new MemberDao();
        MemberVO mvo = mDao.getIdInfo(id);

        req.setAttribute("DATA", mvo);
        return view;
    }
}
