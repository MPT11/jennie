package com.githrd.jennie.controller.member;

import com.githrd.jennie.controller.BlpInter;
import com.githrd.jennie.dao.MemberDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DelInfo implements BlpInter {
    @Override
    public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //뷰 부르는 방식 설정
        req.setAttribute("isRedirect", true);
        String view = "/jennie/main.blp";
        //로그인 체크
        HttpSession session = req.getSession();
        String sid = (String) session.getAttribute("SID");
        if (sid == null) {
            view = "/jennie/member/login.blp";
            return view;
        }
        //파라미터 꺼내기
        String sno = req.getParameter("mno");
        String id = req.getParameter("id");
        //신원확인
        if (!sid.equals(id)) {
            //세션에 기억한 아이디와 전달받은 아이디가 다른경우
            view = "/jennie/member/memberList.blp";
            return view;
        }
        //데이터베이스 작업, 결과받기
        MemberDao mDao = new MemberDao();
        int cnt = mDao.delMember(Integer.parseInt(sno));
        //결과에 따라서 처리
        if (cnt != 1) {
            view = "/jennie/member/myInfo.blp";
        } else{
            session.removeAttribute("SID");
        }
        //뷰 반환
        return view;
    }
}
