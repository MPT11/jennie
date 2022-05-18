<%--
  Created by IntelliJ IDEA.
  User: ghoas
  Date: 2022-05-13
  Time: 오후 3:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Member List</title>
    <link rel="stylesheet" type="text/css" href="/jennie/resources/css/w3.css">
    <link rel="stylesheet" type="text/css" href="/jennie/resources/css/base.css">
    <script type="text/javascript" src="/jennie/resources/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="/jennie/resources/js/jennie/memberList.js"></script>
    <style type="text/css"></style>
    <script type="text/javascript">

    </script>
</head>
<body>
<form method="post" action="/jennie/member/memberInfo.blp" name="frm" id="frm">
    <%--
        이 폼태그는 데이터 전송용 태그이다
        따라서 화면에 보여지면 곤란하고
        이 폼태그가 전송될때 데이터는
        이 태그가 감싸고 이쓴ㄴ input 태그만 전송이 된다.
    --%>
    <input type="hidden" name="mno" id="mno"/>
</form>
<div class="w3-content mx650 w3-center">
    <%--타이를태그--%>
    <h1 class="w3-pink w3-padding w3-card-4">Whistle Member List</h1>
    <div class="w3-col ">
<c:forEach var="data" items="${LIST}">
    <%--아래 클래스에 입력한 lbtn은 버튼태그에 이벤트 등록용 클래스로 사용할 예정--%>
        <div class="box w150 w3-button w3-blue ml10 mb5 lbtn" id="${data.mno}">${data.name}</div>
</c:forEach>
    </div>
    <div class="w3-col w3-margin-top">
        <div class="w3-col w3-button w3-orange w3-hover-amber w3-card-4" id="hbtn">home</div>
    </div>
</div>

</body>
</html>
