$(document).ready(function () {
    $('#rbtn').click(function () {
        document.frm.reset();
    });
    $('#obtn').click(function () {
        $(location).attr('href', '/jennie/member/logout.blp');
    });
    $('#lbtn').click(function () {
        $('#body').prop('disabled', true);
        $('#frm').attr('action', '/jennie/guestBoard/gBoardList.blp')
        $('#frm').submit();
    });
    $('#wbtn').click(function () {
        //데이터 유효성 확인
        var body = $('#body').val();
        body = body.trim();

        if (!body || body.length == 0) {
            $('#body').val('');
            $('#body').focus();
            alert('내용을 입력해주세요')
            return;
        }

        $('#frm').attr('action', '/jennie/guestBoard/gBoardWriteProc.blp');
        $('#frm').submit();
    });
});