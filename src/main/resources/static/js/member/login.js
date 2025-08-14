const login = async () => {
    const idInput = document.querySelector('#idInput');
    const pwdInput = document.querySelector('#pwdInput');
    const mid = idInput.value;
    const mpwd = pwdInput.value;
    const obj={mid,mpwd};

    try {
        const option = {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(obj)
        }
        const response = await fetch("/member/login", option);
        const data = await response.json();

        if (data > 0) {
            alert("로그인성공");
            location.href="/index.jsp";
        }else{
            alert("로그인실패: 아이디 또는 비밀번호가 틀렸습니다.");
        }

    } catch { }//catch end
}//func end

