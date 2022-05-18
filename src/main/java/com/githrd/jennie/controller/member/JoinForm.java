package com.githrd.jennie.controller.member;

import com.githrd.jennie.controller.BlpInter;
import com.githrd.jennie.dao.MemberDao;
import com.githrd.jennie.vo.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JoinForm implements BlpInter {
    @Override
    public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String view = "/member/join";
        //세션 검사
        if (req.getSession().getAttribute("SID") != null) {
            //로그인한 경우
            //리다이렉트 셋팅
            req.setAttribute("isRedirect", true);
            //요청주소 반환
            return "/jennie/main.blp";
        }
        MemberDao mDao = new MemberDao();
        ArrayList<MemberVO> list = mDao.getAvtList();
        //데이터 심고
        req.setAttribute("LIST", list);
        //뷰 부르고
        return view;
    }
}
