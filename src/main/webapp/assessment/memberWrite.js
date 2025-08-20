console.log("write.js")

const auto = async()=>{

    const response= await fetch('/assessment/auto')
    const data = await response.json();
    document.querySelector(".custno").innerHTML=data.custno; // 회원번호
    document.querySelector(".joindate").innerHTML=data.joindate; // 가입일
}
auto();
const memberWrite= async() =>{
    const custname = document.querySelector(".custname").value;
    const phone = document.querySelector(".phone").value;;
    const address = document.querySelector(".address").value;;
    const grade = document.querySelector(".grade").value;;
    const city = document.querySelector(".city").value;;

    const object = {custname,phone,address,
                    grade,city}
    
    const option={
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify(object)
    }//option end

    const response = await fetch("/assessment/add",option)
    const data=await response.json();

    if(data==true){
        alert("회원등록이 완료 되었습니다.");
        location.href=`/assessment/index.jsp`;
    }else{
        alert("회원성명이 입력되지 않았습니다.")
    }//if end
    
}//func end
