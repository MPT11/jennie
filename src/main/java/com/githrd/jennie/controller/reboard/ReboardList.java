package com.githrd.jennie.controller.reboard;

import com.githrd.jennie.controller.*;
import com.githrd.jennie.dao.*;
import com.githrd.jennie.util.*;
import com.githrd.jennie.vo.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class ReboardList implements BlpInter {
    @Override
    public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String view = "/reboard/reboardList";
        int nowPage = 1;
        if (req.getParameter("nowPage") != null) {
            nowPage = Integer.parseInt(req.getParameter("nowPage"));
        }

        ReboardDao rDao = new ReboardDao();
        PageUtil page = new PageUtil(nowPage, rDao.getTotalCount());

        ArrayList<BoardVO> list = rDao.getList(page);

        req.setAttribute("LIST", list);
        req.setAttribute("PAGE", page);

        return view;
    }
}
