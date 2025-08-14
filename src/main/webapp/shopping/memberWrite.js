console.log("write.js")
const memberWrite= async() =>{
    const custnoInput = document.querySelector(".custno");
    const custnameInput = document.querySelector(".custname");
    const phoneInput = document.querySelector(".phone");
    const addressInput = document.querySelector(".address");
    const joindateInput = document.querySelector(".joindate");
    const gradeInput = document.querySelector(".grade");
    const cityInput = document.querySelector(".city");

    const custno = custnoInput.value;
    const custname = custnameInput.value;
    const phone = phoneInput.value;
    const address = addressInput.value;
    const joindate = joindateInput.value;
    const grade = gradeInput.value;
    const city = cityInput.value;

    const object = {custno:custno,custname:custname,phone:phone,address:address,
                    joindate:joindate,grade:grade,city:city}
    
    const option={
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify(object)
    }//option end

    const response = await fetch("/member",option)
    const data=await response.json();
    if(data==true){
        alert("회원등록이 완료 되었습니다.");
    }else{
        alert("회원성명이 입력되지 않았습니다.")
    }//if end
    
}//func end
