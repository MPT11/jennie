package com.githrd.jennie.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public interface BlpInter {
    String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
