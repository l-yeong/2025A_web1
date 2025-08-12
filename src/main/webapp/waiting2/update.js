console.log("update.js exe")

const waitingFind = async()=>{
    const wno = new URLSearchParams(location.search).get('wno');
    const response= await fetch(`/waiting/find?wno=${wno}`)
    const data = await response.json();
    const wphone = document.querySelector('.wphone').innerHTML=data.wphone;
    const wcount = document.querySelector('.wcount').innerHTML=data.wcount;
}//func end
waitingFind();

const waitingUpdate=async()=>{
    const wno = new URLSearchParams(location.search).get('wno');
    const wphone = document.querySelector('.wphone').value;
    const wcount = document.querySelector('.wcount').value;
    console.log(wphone);
    const obj={"wno":wno,"wphone":wphone,"wcount":wcount};

    const option={
        method:"PUT",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify(obj)
    }//option end
    const response = await fetch("/waiting",option);
    const data= await response.json();

    if(data==true){
        alert("수정성공");
        location.href=`/waiting2/view.jsp?wno=${wno}`;
    }else{
        alert("수정실패");
    }//if end
}//func end