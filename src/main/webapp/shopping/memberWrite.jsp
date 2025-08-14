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
    <jsp:include page="/shopping/menu.jsp"></jsp:include>
    <div>
        <h3></h3>
        회원번호(자동발생):<input class="custno" value="<%= request.get %>" readonly/></br>
        회원성명:<input type="text" class="custname" /></br>
        회원전화:<input type="text" class="phone" /></br>
        회원주소:<input type="text" class="address" /></br>
        가입일자:<input class="joindate" /></br>
        가입등급(A:VIP,B:일반,C:직원):<input type="text" class="grade" /></br>
        도시코드:<input type="text" class="city" /></br>
        <button type="button" onclick="memberWrite()">등록</button>
        <button type="button" onclick="memberList()">조회</button>
    </div>
    <script src="/shopping/memberWrite.js"></script>
</body>
</html>