<%--
  Created by IntelliJ IDEA.
  User: ghoas
  Date: 2022-05-19
  Time: 오후 3:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Jennie 댓글 게시판 글작성</title>
    <link rel="stylesheet" type="text/css" href="/jennie/resources/css/w3.css">
    <link rel="stylesheet" type="text/css" href="/jennie/resources/css/user.css">
    <script type="text/javascript" src="/jennie/resources/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="/jennie/resources/js/jennie/reboardComment.js"></script>
    <style type="text/css">
        .w3-button {
            padding: 1px 16px;
        }
        .box120 {
            width: 135px;
            height: auto;
        }
        .mid {
            position: relative;
            top: 5px;
        }
    </style>
</head>
<body>
<div class="w3-content mxw750 w3-margin-top">
    <!-- 페이지 헤더 -->
    <header class="w3-col w3-card-4 mgb20">
        <h1 class="w3-pink w3-center w3-padding mg0">Jennie 댓글 작성</h1>
        <nav class="w3-bar w3-amber">
            <div class="w3-col w150 w3-button w3-small w3-green menubtn" id="hbtn">home</div>
            <div class="w3-col w150 w3-button w3-small w3-red w3-right menubtn" id="obtn">logout</div>
        </nav>
    </header>

    <!-- 페이지 본문 -->
    <div class="w3-col">
        <div class="w3-col w3-round-large w3-card-4 w3-margin-bottom w3-padding">
            <div class="w3-col box120 pdAll10 w3-border-right">
                <img src="/jennie/resources/img/avatar/${DATA.avatar}" class="inblock avtBox100 w3-border w3-border-grey">
                <span class="w3-col w3-center ft10 mid"><b>${SID}</b></span>
            </div>
            <div class="w3-rest w3-padding">
                <div class="w3-col w3-border-bottom">
                    <span class="w3-col w3-left mgb10 ft10"><strong>글내용 :</strong>${DATA.body}</span>
                </div>
                <form method="POST" action="/jennie/reboard/reboardCommentProc.blp" id="frm" name="frm" class="w3-col w3-margin-top">
                    <input type="hidden" id="nowPage" name="nowPage" value="${param.nowPage}">
                    <input type="hidden" id="mno" name="mno" value="${DATA.mno}">
                    <input type="hidden" id="upno" name="upno" value="${DATA.bno}">
                    <textarea class="w3-col w3-padding ft12" id="body" name="body" style="resize: none;"></textarea>
                </form>
                <%--
                    요청 객체에 입력해 놓은 속성을 el에서 꺼내는 방법은
                        ${requestScope.속성키값}
                    세션의 경우
                        ${sessionScrope.속성키값}
                --%>
            </div>
        </div>
    </div>
    <div class="w3-col w3-margin-top w3-card-4">
        <div class="w3-third w3-button w3-green" id="listbtn">리스트</div>
        <div class="w3-third w3-button w3-blue" id="rbtn">reset</div>
        <div class="w3-third w3-button w3-deep-orange" id="wpbtn">등록</div>
    </div>
</div>
</form>
</body>
</html>