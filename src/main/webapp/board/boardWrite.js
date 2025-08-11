console.log("write.js")
const boardWrite= async()  => {         
    //1. 입력받은 데이터 가져오기
    const bcontentInput = document.querySelector(".bcontent");
    const bwriterInput = document.querySelector(".bwriter");
    const bcontent = bcontentInput.value;
    const bwriter = bwriterInput.value;

    //2. 입력받은 데이터를 객체화 한다. //속성명과 속성값의 변수명이 같으면 속성명 생략 가능
    const object = {bcontent:bcontent,bwriter:bwriter}
    //3.FETCH 옵션
    const option={
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify(object)
    }

    const response = await fetch("/board",option)
    const data= await response.json();
    if(data==true){
        alert("등록성공");
        location.href="/board/list.jsp"
    }else{
        alert("등록실패");
    }
}
