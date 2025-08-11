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
        <jsp:include page="header.jsp"></jsp:include>
        <div>
            <h3> 게시물 쓰기 페이지</h3>
            내용:<textarea class="bcontent"></textarea> </br>
            작성자:<input type="text" class="bwriter" /> </br>
            <button type="button" onclick="boardWrite()">등록</button>
        </div>
        <script src="/board/boardWrite.js"></script>

    </body>

    </html>