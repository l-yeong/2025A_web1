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
    <jsp:include page="/header.jsp"></jsp:include>
        <div>
            <div> 작성자: <span class="mid"></span></div>
            <div>
                조회수: <span class="pview"></span>
                작성일: <span class="pdate"></span>
            </div>
            <div class="ptitle">
                
            </div>
            <div class="pcontent">

            </div>
            <div class="etcBox">
                <!-- 내가 쓴글이면 수정 / 삭제 버튼이 들어가는곳-->
            </div>
        </div>
    
    <div class="replyList">
        
    </div>
    <textarea type="text"  class="rcontent" placeholder="댓글 입력 해주세요" ></textarea>
    <button type="button" onclick="writeReply()">등록</button>


    <script src='/js/post/view.js'></script>
</body>
</html>