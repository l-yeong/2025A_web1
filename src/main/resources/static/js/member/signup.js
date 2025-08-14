console.log("signup.js exe");

//***유효성검사 체크리스트***/
const signPass = [false, false]// 초기값은 실패, 0인덱스:아이디체크, 1인덱스: 연락처 체크

// [1] 회원가입 처리
const signup = async () => {

    //만약에 유효성검사 체크리스트에 false 가 존재하면 회원가입 진행 불가능
    //JS배열 요소 찾기 함수: 1 .includeOf() 2 .incluides()
    if (signPass.includes(false)) {
        alert("올바른 정보를 입력 후 가능합니다.");
        return;
    }//if end

    const idInput = document.querySelector(".idInput");
    const pwdInput = document.querySelector(".pwdInput");
    const nameInput = document.querySelector(".nameInput");
    const phoneInput = document.querySelector(".phoneInput");

    const mid = idInput.value;
    const mpwd = pwdInput.value;
    const mname = nameInput.value;
    const mphone = phoneInput.value;

    const obj = { mid, mpwd, mname, mphone }

    try {
        const option = {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(obj)
        }
        const response = await fetch("/member/signup", option);
        const data = await response.json();

        if (data > 0) {
            alert("회원가입 성공");
            location.href = "/member/login.jsp";
        } else {
            alert("가입실패");
        }//if end
    } catch { }//catch end
}//func end



// [2] 아이디 중복 검사
const idCheck = async () => {
    const mid = document.querySelector('.idInput').value;
    try {

        // 1. 유효성검사 1길이검사
        if (mid.length < 6) { //만약에 아이디가 6글자 미만
            document.querySelector('.idCheck').innerHTML = "아이디는 6글자 이상으로 가능 합니다."
            signPass[0] = false;
            return;
        }//if end

        // 2. 유효성검사 2중복검사, /member/check?tyep=검사할속성명&data=${검사할데이터}
        // 3. fetch 실행
        const response = await fetch(`/member/check?type=mid&data=${mid}`);
        const data = await response.json();
        // 4. fetch 결과
        if (data == true) {
            document.querySelector('.idCheck').innerHTML = "사용중인 아이디 입니다."
            signPass[0]=false;
        } else {
            document.querySelector('.idCheck').innerHTML = "사용 가능한 아이디 입니다."
            signPass[0]=true;
        }

    } catch {}//catch end
}//func end

// [3] 연락처 중복 검사
const phoneCheck = async () => {
    const mphone = document.querySelector('.phoneInput').value;
    const phoneCheck = document.querySelector('.phoneCheck')
    try {

        // 1. 유효성검사 1길이검사
        if (mphone.length != 13) { //만약에 아이디가 13글자 미만
            phoneCheck.innerHTML = "-(하이픈) 포함한 13글자 연락처 입력하세요."
            signPass[1]=false;
            return;
        }//if end

        // 2. 유효성검사 2중복검사, /member/check?tyep=검사할속성명&data=${검사할데이터}
        // 3. fetch 실행
        const response = await fetch(`/member/check?type=mphone&data=${mphone}`);
        const data = await response.json();
        // 4. fetch 결과
        if (data == true) {
            phoneCheck.innerHTML='사용중인 연락처 입니다.';
            signPass[1]=false;
        } else {
            phoneCheck.innerHTML='사용가능한 연락처 입니다.'
            signPass[1]=true;
        }//if end

    } catch{}//catch end
}// func end

