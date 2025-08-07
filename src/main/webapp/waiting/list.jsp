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
        <h3> 전체조회 페이지</h3>
        <table border="1">
            <thead>
                <tr>
                    <th>대기번호</th><th>연락처</th><th>인원수</th><th>등록일</th>
                </tr>
            </thead>
            <tbody id="waitingTbody">
            </tbody>
        </table>
    </div>
    <script src="list.js"></script>
</body>
</html>