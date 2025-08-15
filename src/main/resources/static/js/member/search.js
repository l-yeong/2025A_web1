console.log("search.js")
const search = async () => {
    try{
    const mname = document.querySelector('.mname').value;
    const mphone = document.querySelector('.mphone').value;
    const obj = { mname, mphone };

    const option = {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(obj)
    }

    const response = await fetch("/member/search", option);
    const data = await response.json();

    if (data && data.mname && data.mphone) {
        alert(`아이디:${data.mid} 비밀번호:${data.mpwd}`);
    } else {
        alert("입력한 정보가 일치 하지 않습니다.");
    }//if end
    }catch(error){console.log(error)}//catch end
}//func end
