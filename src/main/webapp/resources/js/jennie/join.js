$(document).ready(function () {
    $(document.frm.gen).change(function () {
        var sgen = $(this).val();
        $('#avtfr').stop().slideUp(100, function () {
            if (sgen == 'M') {
                $('#favt').css('display', 'none');
                $('#mavt').css('display', 'block');
                $('#avtfr').stop().slideDown(500);
            } else {
                $('#mavt').css('display', 'none');
                $('#favt').css('display', 'block');
                $('#avtfr').stop().slideDown(500);
            }
        });
    });

    //아이디 체크버튼 클릭 이벤트
    $('#idck').click(function () {
        //할일
        //입력한 아이디 꺼내오고
        var sid = $('#id').val();
        if (!sid) {
            //입력내용이 없는 경우
            $('#id').focus();
            alert('### 아이디를 입력하세요 ###')
            return;
        }
        //전달해서 사용가능 유무 판단하고
        $.ajax({
            url: '/jennie/member/idCheck.blp',
            type: 'post',
            dataType: 'json',
            data: {
                id: sid
            },
            success: function (data) {
                var result = data.result;
                $('#idmsg').removeClass('w3-text-green w3-text-red');
                //뷰에 보여주고
                if (result == 'OK') {
                    //입력한 아이디가 사용 가능한 경우
                    $('#idmsg').html('* 사용 가능한 아이디입니다 *');
                    $('#idmsg').addClass('w3-text-green');
                } else {
                    $('#idmsg').html('* 사용 불가능한 아이디입니다 *');
                    $('#idmsg').addClass('w3-text-red');
                }
                $('#idmsg').css('display', 'block');
            },
            error: function () {
                alert('### 통신 에러 ###')
            }
        });
    });

    //비밀번호 입력 이벤트
    $('#pw').keyup(function () {
        //할일
        //입력된 데이터를 읽어온다
        var pw = $(this).val();

        if (pw != '12345') {
            $('#pwmsg').css('display', 'block');
        } else {
            $('#pwmsg').css('display', 'none');
        }
    });
    /*
    $('#pw').change(function () {
        //할일
        //입력된 데이터를 읽어온다
        var pw = $(this).val();
        if (pw != '12345') {
            $('#pwmsg').html('# 비밀번호는 12345 만 가능합니다.');
            $('#pwmsg').removeClass('w3-text-green w3-text-red')addClass('w3-text-red');
        } else {
            $('#pwmsg').css('display', 'none');
            $('#pwmsg').html('* 정확한 비밀번호입니다 *');
            $('#pwmsg').removeClass('w3-text-green w3-text-red')addClass('w3-text-green');
        }
        $('#pwmsg').css('display', 'block');
    });
    */

    $('#repw').keyup(function () {
        var repw = $(this).val();
        var pw = $('#pw').val();

        if (repw != pw) {
            $('#repwmsg').css('display', 'block');
        } else {
            $('#repwmsg').css('display', 'none');
        }
    });

    $('#jbtn').click(function () {
        //데이터 유효성 검사
        var el = $('#id, #pw, #name, #mail, #tel');

        for (var i = 0; i < el.length; i++) {
            var txt = $(el).eq(i).val();
            if (!txt) {
                $(el).eq(i).focus();
                return;
            }
        }
        var check = $('input[name="gen"]:checked').val();
        if (!check) {
            alert('### 회원성별을 체크해주세요 ###')
            return;
        }
        var checkavt = $('input[name="ano"]:checked').val();
        if (!checkavt) {
            alert('### 아바타를 지정해주세요 ###')
            return;
        }

        $('#frm').attr('action', '/pink/member/joinProc.blp');
        $('#frm').submit();
    });
    $('#hbtn').click(function () {
        $(location).attr('href', '/jennie/main.blp');
    });
    $('#rbtn').click(function () {
        document.frm.reset();
    });

});