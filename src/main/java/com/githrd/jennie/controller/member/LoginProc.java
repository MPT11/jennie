package com.githrd.jennie.controller.member;

import com.githrd.jennie.controller.*;
import com.githrd.jennie.controller.BlpInter;
import com.githrd.jennie.dao.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginProc implements BlpInter {

    @Override
    public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("isRedirect", true);
        String view = "/jennie/main.blp";
        //로그인 체크
        if (req.getSession().getAttribute("SID") != null) {
            //이미 로그인한 상태
            return view;
        }

        //아직 로그인이 안된상태
        //파라미터 받고
        String id = req.getParameter("id"); //파라미터 name 값은 jsp 에 설정되있는 네임값
        String pw = req.getParameter("pw");
        //데이터베이스 작업
        MemberDao mDao = new MemberDao();
        int cnt = mDao.getLogin(id, pw);
        //결과에 따라서 처리
        if(cnt == 1) {
            //로그인처리 후 메인페이지로
            req.getSession().setAttribute("SID", id);
        }else{
            // 로그인페이지로 돌려보낸다
            view = "/jennie/member/login.blp";
        }

        return view;
    }
}
