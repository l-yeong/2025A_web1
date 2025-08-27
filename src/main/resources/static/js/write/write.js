//[*]썸머노트
$(document).ready(function () {
    $('#summernote').summernote({
        lang: 'ko-KR', // default: 'en-US'
        minHeight:300, //썸머노트 구역 최소 높이
        placeholder:'여기에 내용 입력해주세요' //가이드 라인
        
    });

});

console.log("post_write.js exe");

// [1]글쓰기 요청
const onWrite = async () => {
    //1. 첨부파일 없는 게시물 : multipart/form vs 첨부파일 없고 내용에 텍스트+이미지
    let cno = document.querySelector('.cno').value;
    let ptitle = document.querySelector('.ptitle').value;
    let pcontent = document.querySelector('.pcontent').value;

    let obj = { cno, ptitle, pcontent }; console.log(obj);
    let option = {
        method: "POST",
        headers: { "content-type": "application/json" },
        body: JSON.stringify(obj)
    }//option end

    try {
        const response = await fetch("/post", option);
        const data = await response.json();
        if (data > 0) {
            alert("등록성공")
        } else {
            alert("등록실패")
        }//if end

    } catch (error) { console.log(error) }//catch end
}//func end