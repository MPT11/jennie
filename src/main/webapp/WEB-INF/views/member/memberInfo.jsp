<%--
  Created by IntelliJ IDEA.
  User: ghoas
  Date: 2022-05-16
  Time: 오전 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <title>Member List</title>
    <link rel="stylesheet" type="text/css" href="/jennie/resources/css/w3.css">
    <link rel="stylesheet" type="text/css" href="/jennie/resources/css/base.css">
    <script type="text/javascript" src="/jennie/resources/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="/jennie/resources/js/jennie/memberInfo.js"></script>
    <style type="text/css"></style>
    <script type="text/javascript">

    </script>
</head>
<body>
<%--
    요청시 부가정보 전달용 태그
--%>
<form method="post" action="" id="frm" name="frm">
    <input type="hidden" name="mno" id="smno">
    <input type="hidden" name="id" id="sid">
</form>
<div class="w3-content mx650 w3-center">
<c:if test="${DATA.gen ne 'F'}">
    <h1 class="w3-blue w3-center w3-padding w3-card-4">
        <c:if test="${DATA.id eq SID}">
            My Information
        </c:if>
        <c:if test="${DATA.id ne SID}">
            ${DATA.name} 회원 정보
        </c:if>
    </h1>
</c:if>
<c:if test="${DATA.gen eq 'F'}">
    <h1 class="w3-pink w3-center w3-padding w3-card-4">
        <c:if test="${DATA.id eq SID}">
            My Information
        </c:if>
        <c:if test="${DATA.id ne SID}">
            ${DATA.name} 회원 정보
        </c:if>
    </h1>
</c:if>
    <div class="w3-col w3-padding w3-margin-top w3-card-4">
        <div class="w3-col w3-modal-content" style="width: 250px; height: 250px;">
            <img src="/jennie/resources/img/avatar/img_avatar${(DATA.ano)-10}.png" class="avtbox w3-display-middle">
        </div>
        <div class="w3-rest w3-left-align">
            <h4>회원번호 : <span id="mno">${DATA.mno}</span></h4>
            <h4>회원이름 : <span id="name">${DATA.name}</span></h4>
            <h4>아 이 디 : <span id="id">${DATA.id}</span></h4>
            <h4>메일주소 : <span id="mail">${DATA.mail}</span></h4>
            <h4>연 락 처 : <span id="tel">${DATA.tel}</span></h4>
            <h4>성    별 : <span id="gen">${((DATA.gen == 'M') ? '남자' : '여자')}</span></h4>
            <h4>가 입 일 : <span id="sdate">${DATA.sdate}</span></h4>
        </div>
    </div>
    <footer class="w3-col w3-margin-top w3-card-4">
<c:if test="${DATA.id eq SID}">
        <div class="w3-third w3-button w3-green" id = "lbtn">Member List</div>
        <div class="w3-third w3-button w3-blue" id = "ebtn">edit</div>
        <div class="w3-third w3-button w3-red" id = "dbtn">회원탈퇴</div>
</c:if>
    <c:if test="${DATA.id ne SID}"><%-- 다른 회원의 정보를 조회한 경우... --%>
        <div class="w3-col w3-button w3-green" id="lbtn">Member List</div>
    </c:if>
    </footer>
</div>

</body>
</html>
