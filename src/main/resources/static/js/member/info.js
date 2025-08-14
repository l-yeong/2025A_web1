console.log("info.js exe");

// [1] 내 정보 조회
const onInfo = async () => {
        try {
            const response = await fetch('/member/info');
            const data = await response.json(); // 비로그인상태이면 null 이므로 예외/오류 발생
            //fetch 결과 : 로그인상태
            document.querySelector('.mno').innerHTML=data.mno;
            document.querySelector('.mid').innerHTML=data.mid;
            document.querySelector('.mname').innerHTML=data.mname;
            document.querySelector('.mphone').innerHTML=data.mphone;
            document.querySelector('.mdate').innerHTML=data.mdate;
        } catch(error) {console.log(error) // 비로그인상태이면 catch 이동
            location.href="/member/login.jsp"; // 로그인페이지로
        }//catch end
}//func end
onInfo();

// [2] 회원 탈퇴: alert(): 확인,알람창, prompt():입력상자 알림창, confirm: 확인/취소 알람창

const onDelete = async() =>{
    //1. 삭제 확인
    let result=confirm("정말 탈퇴 할까요?");
    if(result==false){return;}
    //2. 삭제 하기 위한 기존 패스워드 확인
    let oldpwd=prompt("현재 비밀번호 입력 해주세요.")
    try{
        const option={method:"DELETE"}
        const response = await fetch(`/member/delete?oldpwd=${oldpwd}`,option);
        const data= await response.json();
        if(data==true){
            alert("탈퇴성공"); location.href="/index.jsp";
        }else{
            alert("탈퇴실패: 현재 비밀번호가 일치 하지 않는다.")
        }//if end
    }catch(error){
        console.log(error);
    }//catch end
} //func end