$(document).ready(function () {
    $('.menubtn').click(function () {
        var bid = $(this).attr('id');

        var addr = '/jennie/main.blp';

        switch (bid) {
            case 'hbtn':
                break;
            case 'obtn':
                addr = '/jennie/member/logout.blp';
                break;
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
    $('#wpbtn').click(function () {
        var txt = $('#body').val();

        txt = txt.trim();
        if(!txt || txt.length == 0){
            $('#body').val('');
            $('#body').focus();
            return;
        }

        $('#body').val(txt);

        $('#frm').submit();

    });

});