const waitingWrite= async()=>{
    const wphoneInput = document.querySelector(".wphone");
    const wcountInput = document.querySelector(".wcount");
    const wphone= wphoneInput.value;
    const wcount= wcountInput.value;

    const object={wphone:wphone,wcount:wcount};

    const option={
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify(object)
    }//option end

    const response = await fetch("/waiting",option)
    const data = await response.json();
    if(data==true){
        alert("등록성공");
        location.href="/waiting2/list.jsp"
    }else{
        alert("등록실패")
    }//if end
}//func end