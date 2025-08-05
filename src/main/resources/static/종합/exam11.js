//1.
console.log("exam11.js exe");

//2. 함수 연동 확인
//일반 함수 선언  : function 함수명(){}
//람다식 함수 선언 : const 함수명 = ( ) => { }
const boardWrite = ( ) => {
    console.log("boardWrite")
    // 3. 함수 기능 구현 - fetch
    // (1) 보낼 데이터 객체 준비 - 샘플
    let data={"bcontent":"JS테스트","bwriter":"신동엽"}
    // (2) fetch 옵션 : 3가지 (method,header,body)
    let option = {
        method: "POST",//1)method
        headers: {"Content-Type":"application/json"},//2)headers
        body:JSON.stringify(data)//3)body
    }//option end

// (3) fetch(url,option)
//    .then(response => response.json()) //응답자료를 타입변환
//    .then(data => {})                  //타입변환된 자료
//    .catch(error => {})                //통신간의 예외발생

    fetch("/board",option)
    .then(response => response.json())
    .then(data => {console.log(data)})
    .catch(error => {console.log(error)})
} // func end

//전체전회
const boardPrint =( ) => {
    console.log("boardPrint")
    //(1) 보낼 데이터 - 없음
    //(2) fetch option - GET 생략
    let option ={method:"GET"}
    //(3) fetch
    fetch("/board",option)
    .then(response => response.json())
    .then(data => {console.log(data)})
    .catch(error => {console.log(error)})
}//func end

//삭제
const boardDelete = ( ) => {
    console.log("boardDelete")
    // 3. 함수 기능 구현 - fetch
    // (1) 보낼 데이터 객체 준비 - 샘플
    let bno=42;
    // (2) fetch 옵션 : 3가지 (method,header,body)
    let option ={method: "DELETE"}
    // (3) fetch
    fetch(`/board?bno=${bno}`,option)
    .then(response => response.json())
    .then(data => {console.log(data)})
    .catch(error => {console.log(error)})
}//func end

//수정
const boardUpdate = ( )=> {
    console.log("boardUpdate")
    let data={"bno":41,"bcontent":"테스트"}
    let option={
    method : "PUT",
    headers:{"Content-Type":"application/json"},
    body: JSON.stringify(data)
    }
    fetch("/board",option)
    .then(response => response.json())
    .then(data => {console.log(data)})
    .catch(error => {console.log(error)})
}//func end