const add = async( ) => {
    const wPhoneInput = document.querySelector(".wPhone");
    const wCountInput = document.querySelector(".wCount");

    const wphone = wPhoneInput.value;
    const wcount = wCountInput.value;

    const object={wphone:wphone,wcount:wcount}

    const option={
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify(object)
    }//option end

    const response = await fetch("/wait/add",option)
    const data = await response.json();
    if(data==true){
        alert("등록성공");
        location.href="/waiting/list.jsp"
    }else{
        alert("등록실패");
    }

}//func end