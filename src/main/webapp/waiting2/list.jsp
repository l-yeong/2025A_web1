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
    <h2> 대기현황 </h2>
    <a href="/waiting2/waitingWrite.jsp"> 대기 등록 </a>
    <div>
        <table border=1>
            <thead>
                <tr>
                    <th> 대기순서 </th> <th> 연락처 </th> <th> 인원수 </th> <th> 등록일 </th>
                </tr>
            </thead>
            <tbody id="waitingTbody">

            </tbody>
        </table>
    </div> 
    <script src="/waiting2/list.js"></script>
</body>
</html>