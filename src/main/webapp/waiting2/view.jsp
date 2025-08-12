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
        <jsp:include page="/waiting2/header.jsp"></jsp:include>
        <div>
            <h3> 등록 현황 수정 </h3>
            연락처:<div class="wphoneBox"></div>
            인원수:<div class="wcountBox"></div>
            <button type="button" onclick="waitingDelete()">삭제</button>
            <button type="button" onclick="waitingUpdateView()">수정</button>
        </div>
        <script src="/waiting2/view.js"></script>

    </body>

    </html>