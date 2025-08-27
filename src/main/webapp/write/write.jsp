<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset='utf-8'>
        <meta http-equiv='X-UA-Compatible' content='IE=edge'>
        <title>Page Title</title>
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        
        <!-- 썸머노트 용 js/css : CDN : 별도의 설치 없이 URL 웹페이지로 라이브러리 코드 불러오기-->         
        <!-- include libraries(jQuery, bootstrap) -->

        <!-- 부트스트랩 최신 버전-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" ></script>


        <!-- jquery 최신버전-->
        <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
        

        <!--썸머노트 0.9.1 최신버전 CSS/JS-->
        <!-- include summernote css/js -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.9.1/summernote-bs5.min.css" rel="stylesheet">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.9.1/summernote-bs5.min.js"></script>
        <!--썸머노트 0.9.1 한글 버전-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.9.1/lang/summernote-ko-KR.min.js"></script>

    </head>

    <body>
        <jsp:include page="/header.jsp"></jsp:include>
        <dvi id="container">
            <select class="cno">
                <option value="1">뉴스</option>
                <option value="2">이벤트</option>
                <option value="3">FAQ</option>
                <option value="4">튜토리얼</option>
                <option value="5">사용자 리뷰</option>
            </select>
            <input class="ptitle" />
            <textarea class="pcontent" id="summernote" name="editordata" ></textarea>
            <button type="button" onclick="onWrite()">등록</button>
        </dvi>

        <script src='/js/write/write.js'></script>
    </body>

    </html>