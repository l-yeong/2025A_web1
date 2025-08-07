<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>
    <script src='main.js'></script>
</head>
<body>
    <jsp:include page="/waiting/header.jsp"></jsp:include>
    <div>
        <h3> 등록 페이지 </h3>
        연락처:<input type="text" class="wPhone" />
        인원수:<input type="text" class="wCount"/>
        <button type="button" onclick="add()"> 등록 </button>
    </div>
    <script src="add.js"></script>
</body>
</html>