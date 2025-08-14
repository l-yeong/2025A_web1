console.log("search.js")
const search = async()=>{
    const mname = document.querySelector('.mname').value;
    const mphone = document.querySelector('.mphone').value;
    const obj={mname,mphone};

    const response = await fetch("/member/search",option);
    const data= await response.json();

    if(data==true){
        alert("수정성공");
        location.href=`/waiting2/view.jsp?wno=${wno}`;
    }else{
        alert("수정실패");
    }//if end

}
