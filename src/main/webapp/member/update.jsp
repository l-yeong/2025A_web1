<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset='utf-8'>
        <meta http-equiv='X-UA-Compatible' content='IE=edge'>
        <title>Page Title</title>
        <link rel='stylesheet' href='/cs/memeber/update.css'>
    </head>

    <body>
        <jsp:include page="/header.jsp"></jsp:include>

        <div id="container">
            <h3>회원정보 수정 페이지</h3>
            <div>회원번호:<span class="mno"></span></div>
            <div>아이디:<span class="mid"></span></div>
            <div>이름:<input type="text" class="mname" /></div>
            <div>연락처:<input type="text" class="mphone" /></div>
            <div>가입일:<span class="mdate"></span></div>
            <button type="button" onclick="onupdate()">수정</button>
        </div>

        <script src='/js/member/update.js'></script>
    </body>

    </html>