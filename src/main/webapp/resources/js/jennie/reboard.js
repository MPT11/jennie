$(document).ready(function () {
    $('.pbtn').click(function () {
        var pno = $(this).attr('id');
        $('#nowPage').val(pno);

        $('#frm').submit();
    });

    /*$('#hbtn').click(function (){
        $(location).attr('href', "/jennie/main.blp")
    });
    $('#lbtn').click(function () {
        $(location).attr('href', "/jennie/member/login.blp")
    });

    $('#jbtn').click(function () {
        $(location).attr('href', '/jennie/member/join.blp');
    });

    $('#obtn').click(function () {
        $(location).attr('href', '/jennie/member/logout.blp');
    });*/

    $('.menubtn').click(function () {
        var bid = $(this).attr('id');

        var addr = '/jennie/main.blp';

        switch (bid) {
            case 'hbtn':
                break;
            case 'lbtn':
                addr = '/jennie/member/login.blp';
                break;
            case 'jbtn':
                addr = '/jennie/member/join.blp';
                break;
            case 'obtn':
                addr = '/jennie/member/logout.blp';
                break;
            case 'wbtn':
                $('#frm').attr('action', '/jennie/reboard/reboardWrite.blp');
                $('#frm').submit();
                return;
        }
        $(location).attr('href', addr);
    });

    $('#listbtn').click(function(){
        // form 태그의 액션 속성값 변경
        $('#frm').attr('action', '/jennie/reboard/reboardList.blp');
        // 사용하지 않는 태그 비활성시키고
        $('#mno').prop('disabled', true);
        $('#body').prop('disabled', true);

        $('#frm').submit();
    });
    $('#rbtn').click(function(){
        document.frm.reset();
    });

    $('#wpbtn').click(function(){
        // 입력된 글 유효성 검사
        var txt = $('#body').val();

        txt = txt.trim();
        if(!txt || txt.length == 0){
            $('#body').val('');
            $('#body').focus();
            return;
        }
        alert(txt);
        $('#body').val(txt);

        $('#frm').submit();
    });

    $('.w3-button.w3-small.w70').click(function () {
        // 어떤 버튼이 클릭이 되었는지 알아내고
        var btxt = $(this).html();

        // 글번호 읽어오기
        var sno = $(this).parent().attr('id');

        if(btxt == '댓글'){
            $('#bno').val(sno);

            $('#frm').attr('action', '/jennie/reboard/reboardComment.blp');

            $('#frm').submit();
        }
    });

});