$(document).ready(function () {
    //reset 버튼 이벤트
    $('#rbtn').click(function () {
        document.frm.reset();
    });
    //home 버튼 이벤트
    $('#hbtn').click(function () {
        $(location).attr('href', '/jennie/main.blp');
    });
    $('#repw').keyup(function () {
        var repw = $(this).val();
        var pw = $('#pw').val();

        if (repw != pw) {
            $('#repwmsg').css('display', 'block');
        } else {
            $('#repwmsg').css('display', 'none');
        }
    });

    //수정버튼 클릭이벤트
    $('#ebtn').click(function () {
        //받은 데이터 꺼내오기
        var tmail = $('#tmail').val();
        var ttel = $('#ttel').val();
        var tano = $('#tano').val();
        //수정된 데이터 꺼내오기
        var pw = $('#pw').val();
        var mail = $('#mail').val();
        var tel = $('#tel').val();
        var ano = $('[name="ano"]:checked').val();

        if (!pw) {
            $('#pw').prop('disabled', true);
        }
        if (tmail == mail) {
            $('#mail').prop('disabled', true);
        }
        if (ttel == tel) {
            $('#tel').prop('disabled', true);
        }
        if (tano == ano) {
            $('[name="ano"]').prop('disabled', true);
        }

        if (!pw && (tmail == mail) && (ttel == tel) && (tano == ano)) {
            alert('아무것도 수정안함');
            return;
        }

        //보낼 주소 설정
        $('#frm').attr('action', '/jennie/member/editProc.blp');
        $('#frm').submit();
    });
});