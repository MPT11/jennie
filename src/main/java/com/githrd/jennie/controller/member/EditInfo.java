package com.githrd.jennie.controller.member;

import com.githrd.jennie.controller.BlpInter;
import com.githrd.jennie.dao.MemberDao;
import com.githrd.jennie.vo.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class EditInfo implements BlpInter {
    @Override
    public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String view = "/member/editInfo";
        HttpSession session = req.getSession();
        String sid = (String) session.getAttribute("SID");
        if (sid == null) {
            view = "/jennie/member/login.blp";
            req.setAttribute("isRedirect", true);
            return view;
        }
        MemberDao mDao = new MemberDao();
        MemberVO mvo = mDao.getIdInfo(sid);
        ArrayList<MemberVO> list = mDao.getAvtList();

        req.setAttribute("DATA", mvo);
        req.setAttribute("LIST", list);
        return view;
    }
}
