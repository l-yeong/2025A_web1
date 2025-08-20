<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset='utf-8'>
        <meta http-equiv='X-UA-Compatible' content='IE=edge'>
        <title>Page Title</title>
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        <link rel='stylesheet' type='text/css' media='screen' href='main.css'>

    </head>

    <body>
        
        <div id="container">
            <h3>홈쇼핑 회원 정보 수정</h3>
            <div>회원번호:<input type="text" class="custno" readonly></div>
            <div>회원성명:<input type="text" class="custname" /></div>
            <div>회원전화:<input type="text" class="phone" /></div>
            <div>회원주소:<input type="text" class="address" /></div>
            <div>가입일자:<input type="text" class="joindate" readonly></div>
            <div>가입등급(A:VIP,B:일반,C:직원):<input type="text" class="grade" /></div>
            <div>도시코드:<input type="text" class="city" /></div>
            <button type="button" onclick="memberUpdate()">수정</button>
            <a href="/assessment/memberList.jsp"><button type="button">조회</button></a>
        </div>
        <script src='/assessment/memberUpdate.js'></script>
    </body>

    </html>