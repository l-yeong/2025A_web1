<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' href='search.css'>
    
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
    <h3>아이디 찾기</h3>
    이름:<input type="text" class="mname" /> <br/>
    연락처:<input type="text" class="mphone-id" /> <br/>
    <button type="button" onclick="searchId()">아이디 찾기</button>

    <h3>비밀번호 찾기</h3>
    아이디:<input type="text" class="mid" /> <br/>
    연락처:<input type="text" class="mphone-pwd" /> <br/>
    <button type="button" onclick="searchPwd()">비밀번호 찾기</button>


</body>
<script src='/js/member/search.js'></script>
</html>