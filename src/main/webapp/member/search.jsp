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
    <h3>아이디/비밀번호 찾기</h3>
    이름:<input type="text" class="mname" /> <br/>
    연락처:<input type="text" class="mphone" /> <br/>
    <button type="button" onclick="search()">찾기</button>


</body>
<script src='search.js'></script>
</html>