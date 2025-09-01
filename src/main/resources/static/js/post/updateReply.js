console.log("updateReply.exe");

//[*] 썸머노트 실행
//[*]썸머노트
$(document).ready(function () {
    $('#summernote').summernote({
        lang: 'ko-KR', // default: 'en-US'
        minHeight:300, //썸머노트 구역 최소 높이
    });

});
//[1] 기존 게시물 정보 가져오기
    const params=new URL(location.href).searchParams;
    const pno=params.get('pno');

const getPost = async() => {

    const response = await fetch(`/post/view?pno=${pno}`);
    const data = await response.json();
    console.log(data);

    document.querySelector('.cno').value=data.cno;
    document.querySelector('.ptitle').value=data.ptitle;
    document.querySelector('.note-editable').innerHTML=data.pcontent;
}//func end
getPost();

//[2] 수정 처리
const updateReply = async() =>{
    //1. 수정 할 자료 
    const cno = document.querySelector('.cno').value;
    const ptitle=document.querySelector('.ptitle').value;
    const pcontent=document.querySelector('.pcontent').value;
    const obj={cno,ptitle,pcontent,pno}
    console.log(obj);
    //2.
    const option={method:"PUT", 
                headers:{"content-type":"application/json"},
                body:JSON.stringify(obj)}

    const response = await fetch("/post",option);
    const data = await response.json();
    if(data==0){alert("수정실패")}
    else{alert("수정성공"); location.href=`view.jsp?pno=${pno}`;}
    
}//func end