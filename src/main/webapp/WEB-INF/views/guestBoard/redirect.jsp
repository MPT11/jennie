<%--
  Created by IntelliJ IDEA.
  User: ghoas
  Date: 2022-05-18
  Time: 오후 2:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <script type="text/javascript" src="/jennie/resources/js/jquery-3.6.0.min.js"></script>
  <script type="text/javascript">
    $(document).ready(function () {
      $('#frm').submit();
    });
  </script>
</head>
<body>
<c:if test="${not empty VIEW}">
  <form method="post" action="${VIEW}" id="frm" name="frm">
<c:if test="${not empty NOWPAGE}">
    <input type="hidden" name="nowPage" value="${NOWPAGE}">
</c:if>
  </form>
</c:if>
</body>
</html>
