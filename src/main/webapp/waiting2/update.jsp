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
        <h3> 대기현황 수정 페이지</h3>
        연락처:<textarea class="wphone"></textarea><br/>
        인원수:<textarea class="wcount"></textarea><br/>
        <button onclick="waitingUpdate()">수정</button>
    </div>
    <script src="/waiting2/update.js"></script>
</body>
</html>