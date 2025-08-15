<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
</head>
<body>
    <jsp:include page="/assessment/menu.jsp"></jsp:include>
    <div id="container">
        <h3>회원가입 페이지</h3>
            <div>회원번호(자동발생):<span class="custno"></span></div>
            <div>회원성명:<input type="text" class="custname" /></div>
            <div>회원전화:<input type="text" class="phone" /></div>
            <div>회원주소:<input type="text" class="address" /></div>
            <div>가입일자:<span class="joindate"></span></div>
            <div>가입등급(A:VIP,B:일반,C:직원):<input type="text" class="grade" /></div>
            <div>도시코드:<input type="text" class="city" /></div>
            <button type="button" onclick="memberWrite()">등록</button>
            <button type="button" onclick="memberList()">조회</button>
    </div>
    <script src="/assessment/memberWrite.js"></script>
</body>
</html>