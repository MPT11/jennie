package com.githrd.jennie.controller.member;

import com.githrd.jennie.controller.BlpInter;
import com.githrd.jennie.dao.MemberDao;
import com.githrd.jennie.vo.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JoinProc implements BlpInter {
    @Override
    public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("isRedirect", true);
        String view = "/jennie/main.blp";
        //받은 데이터 mvo 에 입력
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        MemberVO mvo = new MemberVO();
        mvo.setName(req.getParameter("name"));
        mvo.setId(id);
        mvo.setPw(pw);
        mvo.setMail(req.getParameter("mail"));
        mvo.setTel(req.getParameter("tel"));
        mvo.setGen(req.getParameter("gen"));
        mvo.setAno(Integer.parseInt(req.getParameter("ano")));
        MemberDao mDao = new MemberDao();
        int cnt = mDao.addMember(mvo);
        if(cnt == 1) {
            //로그인처리 후 메인페이지로
            mDao.getLogin(id, pw);
            req.getSession().setAttribute("SID", id);
        }else{
            // 로그인페이지로 돌려보낸다
            view = "/jennie/member/join.blp";
        }

        return view;
    }
}
