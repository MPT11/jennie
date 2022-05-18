$(document).ready(function () {
    $('#hbtn').click(function () {
        $(location).attr('href', '/jennie/main.blp');
    });
    $('#jbtn').click(function () {
        $(location).attr('href', '/jennie/member/join.blp');
    });
    $('#lbtn').click(function () {
        $(location).attr('href', '/jennie/member/login.blp');
    });
    $('#obtn').click(function () {
        $(location).attr('href', '/jennie/member/logout.blp');
    });
    $('.pbtn').click(function(){
        // 데이터 읽어오고
        var page = $(this).attr('id');

        // 데이터 셋팅하고
        $('#nowPage').val(page);
        $('#frm').submit();
    });
    $('#wbtn').click(function () {
        // get 방식으로 요청
        //$(location).attr('href', '/jennie/guestBoard/gBoardWrite.blp?nowPage=' + $('#nowPage').val());
        // post 방식
        $('#frm').attr('action', '/jennie/guestBoard/gBoardWrite.blp');
        $('#frm').submit();
    });
});