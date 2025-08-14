// * JS 실행확인
console.log("header.js exe");

// [1] 내정보 요청해서 메뉴 나누기
const myinfo = async() =>{
     console.log("test");
    const logMenu=document.querySelector('#log-menu');
    let html='';

    try{
    //1. fetch 실행
    const response = await fetch("/member/info")
    const data=await response.json(); console.log(data);
    // ** 비로그인시 응답 자료가 null 라서 json()타입변환 함수에서 오류 발생해서 catch 
    //2. [로그인중] 로그인 했을때 정상 fetch
    html += `
             <li> <span> ${data.mid}님 100 POINT </span></li>
             <li> <a href="member/info.jsp"> 내정보 </a></li>
             <li> <a href="#" onclick="logout()"> 로그아웃 </a> </li>
            `
    }catch{
        console.log("catch");
    //3. [비로그인중] 로그인 안했을때 비정상 통신 fetch
    html += `
             <li> <a href="/member/login.jsp"> 로그인 </a> </li>
             <li> <a href="/member/signup.jsp"> 회원가입 </a> </li>
            `
    }//catch end
    logMenu.innerHTML=html;
}//func end
myinfo(); //header.jsp 통신
// [2] 로그아웃

const logout = async()=>{
    try{
        const option = { method : "GET"}
        const response = await fetch( "/member/logout" , option );
        const data = await response.json();
        //2.fetch통신 결과
        if(data==true){
            alert("로그아웃 했습니다");
            location.href="/index.jsp"
        }else{
            alert("비정상 요청 및 관리자에게 문의")
        }//if end
    }catch{} //catch end
} //func end

