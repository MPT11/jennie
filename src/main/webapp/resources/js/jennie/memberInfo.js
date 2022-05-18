$(document).ready(function () {
    $('#lbtn').click(function () {
        $(location).attr('href', '/jennie/member/memberList.blp')
    });
    $('#dbtn').click(function () {
        //보낼 데이터 읽기
        var sno = $('#mno').html();
        var sid = $('#id').html();
        //보낼 데이터 수정
        $('#smno').val(sno);
        $('#sid').val(sid);
        //보낼주소 수정
        $('#frm').attr('action', '/jennie/member/delInfo.blp')
        if (confirm('정말 탈퇴하시겠습니까?')) {
        //form 태그 전송
        $('#frm').submit();
        }
    });
    $('#ebtn').click(function () {
        $(location).attr('href', '/jennie/member/editInfo.blp')
    });
});