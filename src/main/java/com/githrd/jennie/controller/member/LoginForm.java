package com.githrd.jennie.controller.member;

import com.githrd.jennie.controller.*;
import com.githrd.jennie.controller.BlpInter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginForm implements BlpInter {

    @Override
    public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String view = "/member/login";
        if (req.getSession().getAttribute("SID") != null) {
            // 이미 로그인 한 경우
            req.setAttribute("isRedirect", true);
            view = "/jennie/main.blp";
        }
        return view;
    }
}
