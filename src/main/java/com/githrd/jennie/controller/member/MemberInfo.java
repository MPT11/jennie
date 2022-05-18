package com.githrd.jennie.controller.member;

import com.githrd.jennie.controller.BlpInter;
import com.githrd.jennie.dao.MemberDao;
import com.githrd.jennie.vo.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class MemberInfo implements BlpInter {

    @Override
    public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String view = "/member/memberInfo";
        String sno = req.getParameter("mno");
        int mno = Integer.parseInt(sno);

        MemberDao mDao = new MemberDao();
        MemberVO mvo = mDao.getMnoInfo(mno);

        req.setAttribute("DATA", mvo);


        return view;
    }
}
