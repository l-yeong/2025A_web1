const onPwdUpdate = async() =>{

    const oldpwd = document.querySelector(".oldpwd").value; 
    const newpwd = document.querySelector(".newpwd").value; 
    const obj={oldpwd,newpwd}


    try{
        const option = { 
            method : "PUT",
            headers : { "Content-Type" : "application/json"},
            body : JSON.stringify( obj )
        }
        const response = await fetch( "/member/update/password" , option );
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