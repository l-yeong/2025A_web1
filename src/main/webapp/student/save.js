console.log("save js open")

// [1] 등록 fetch, 동기

//const save = () =>{}
//async function save(){}

const save = async() => {
    //1. 입력받은 값을 가져오기
    const snameInput = document.querySelector(".sname");
    const skorInput = document.querySelector(".skor");
    const smathInput = document.querySelector(".smath");
    const sname = snameInput.value;
    const skor = skorInput.value;
    const smath = smathInput.value;

    //2. 입력받은 값을 객체화, 속성명과 속성값 변수명이 같으면 생략 가능
    const object = {sname:sname, skor:skor, smath:smath}

    //3. fetch
    const option ={
        method:"POST",
        headers:{"Content-Type" : "application/json"},
        body:JSON.stringify(object)
    }//option end
    const response = await fetch("/student/save",option);
    const data = await response.json();
    if(data==true){
        alert("등록성공");
        location.href="/student/find.jsp";
    }else{
        alert("등록실패");
    }

}//func end