console.log("update.js exe");

const onInfo = async()=>{
    
    const response= await fetch('/member/info')
    const data = await response.json();
    document.querySelector(".mno").innerHTML=data.mno; //회원번호
    document.querySelector(".mid").innerHTML=data.mid; //회원아이디
    document.querySelector(".mdate").innerHTML=data.mdate;//가입날짜
}
onInfo();

const onupdate = async() =>{

    const mname = document.querySelector(".mname").value;  //이름
    const mphone = document.querySelector(".mphone").value; //연락처
    const obj={mname,mphone}


    try{
        const option = { 
            method : "PUT",
            headers : { "Content-Type" : "application/json"},
            body : JSON.stringify( obj )
        }
        const response = await fetch( "/member/update" , option );
        const data = await response.json();
        console.log(data);
       

        if(data==true){
            alert("수정성공");
            location.href="/index.jsp"
        }else{
            alert("수정실패")
        }
    }catch(error){console.log(error)}
}
