<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <!-- <link rel='stylesheet' type='text/css' media='screen' href='main.css'> -->
    
</head>
<body>
    <jsp:include page="/assessment/menu.jsp"></jsp:include>
    <h4> 회원목록조회/수정</h4>
    <div id="container">
        <table border=1>
            <thead>
                <tr>
                    <th> 회원번호 </th> <th> 회원성명 </th> <th> 전화번호 </th>
                    <th> 주소 </th> <th> 가입일자 </th> <th> 고객등급 </th>
                    <th> 거주지역 </th>
                </tr>
            </thead>
            <tbody id="memberTbody">
                <tr>

                </tr>
            </tbody>
        </table>
    </div>

    <script src='/assessment/memberList.js'></script>
</body>
</html>