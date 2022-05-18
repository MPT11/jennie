/**
 * /resources/js/whistle/main.js
 */

$(document).ready(function () {
    $('#jbtn').click(function () {
        $(location).attr('href', '/jennie/member/join.blp');
    });
    $('#lbtn').click(function () {
        $(location).attr('href', '/jennie/member/login.blp');
    });
    $('#obtn').click(function () {
        $(location).attr('href', '/jennie/member/logout.blp');
    });
    $('#mlbtn').click(function () {
        $(location).attr('href', '/jennie/member/memberList.blp')
    });
    $('#ibtn').click(function () {
        $(location).attr('href', '/jennie/member/myInfo.blp')
    });
    $('#gbtn').click(function () {
        $(location).attr('href', '/jennie/guestBoard/gBoardList.blp');
    });
    $('#rbtn').click(function () {
        $(location).attr('href', '/jennie/reboard/reboardList.blp');
    });
});