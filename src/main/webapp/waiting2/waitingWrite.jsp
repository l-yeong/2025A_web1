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
    <jsp:include page="header.jsp"></jsp:include>
    <div>
        <h1> 대기 등록 </h1>
        연락처:<input type="text" class="wphone" /><br/>
        인원수:<input type="text" class="wcount" /><br/>
        <button type="button" onclick="waitingWrite()">등록</button>
    </div>

    <script src="/waiting2/waitingWrite.js"></script>
</body>
</html>z