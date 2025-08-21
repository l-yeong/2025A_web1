console.log("search.js")
const searchId = async () => {
    try{
    const mname = document.querySelector('.mname').value;
    const mphone = document.querySelector('.mphone-id').value;
    const obj = { mname, mphone };

    const option = {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(obj)
    }

    const response = await fetch("/member/id", option);
    const data = await response.json();

    if (data && data.mname && data.mphone) {
        alert(`아이디:${data.mid}`);
    } else {
        alert("입력한 정보가 일치 하지 않습니다.");
    }//if end
    }catch(error){console.log(error)}//catch end
}//func end

const searchPwd = async () => {
    try{
    const mid = document.querySelector('.mid').value;
    const mphone = document.querySelector('.mphone-pwd').value;
    
    console.log(mid);
    console.log(mphone);

    const response = await fetch(`/member/pwd?mid=${mid}&mphone=${mphone}`);
    const data = await response.json();

    alert(data.msg);
    }catch(error){console.log(error)}//catch end
}//func end