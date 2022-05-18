$(document).ready(function () {
    // home 버튼
    $('#hbtn').click(function () {
        $(location).attr('href', '/jennie/main.blp');
    });

    // login 버튼
    $('#lbtn').click(function () {
        var sid = $('#id').val();
        var spw = $('#pw').val();
        if (!(spw && spw)) {
            alert('아이디와 비밀번호를 다시 입력해주세요');
            $('#id').focus();
            return;
        }

        // 이 행을 실행하는 경우는 입력한 데이터가 사용가능할 때 이므로
        $('#frm').attr('action', '/jennie/member/loginProc.blp');
        $('#frm').submit();
    });
});