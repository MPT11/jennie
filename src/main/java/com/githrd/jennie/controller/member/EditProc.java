package com.githrd.jennie.controller.member;

import com.githrd.jennie.controller.BlpInter;
import com.githrd.jennie.dao.MemberDao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EditProc implements BlpInter {
    @Override
    public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("isRedirect", true);
        String view = "/jennie/member/myInfo.blp";
        //로그인 체크
        String sid = (String) req.getSession().getAttribute("SID");
        if (sid == null) {
            view = "/jennie/member/login.blp";
            return view;
        }

        //파라미터 가져오고
        String smno = req.getParameter("mno");
        int mno = Integer.parseInt(smno);
        String pw = req.getParameter("pw");
        String mail = req.getParameter("mail");
        String tel = req.getParameter("tel");
        String sno = req.getParameter("ano");

        StringBuffer buff = new StringBuffer();
        if (pw != null) {
            buff.append(" , MEMBER_PW = '" + pw + "' ");
        }
        if (mail != null) {
            buff.append(" , MEMBER_MAIL = '" + mail + "' ");
        }
        if (tel != null) {
            buff.append(" , MEMBER_TEL = '" + tel + "' ");
        }
        if (sno != null) {
            buff.append(" , MEMBER_AVT = '" + sno + "' ");
        }

        String psql = buff.toString().substring(3);
        MemberDao mDao = new MemberDao();
        int cnt = mDao.editMyInfo(mno, psql);

        if (cnt != 1) {
            view = "/jennie/member/editInfo.blp";
        }

        return view;
    }
}
