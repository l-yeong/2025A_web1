const view= async()=>{
    const url = new URLSearchParams(location.search);
    const wno = url.get('wno');
    const response = await fetch(`/waiting/find?wno=${wno}`);
    const data = await response.json();
    console.log(data);
    const wphoneBox=document.querySelector('.wphoneBox');
    const wcountBox=document.querySelector('.wcountBox');
    
    const wphone=data.wphone;
    const wcount=data.wcount;

    wphoneBox.innerHTML=wphone;
    wcountBox.innerHTML=wcount;
}//func end
view();

const waitingDelete = async ()=>{
    const wno = new URLSearchParams(location.search).get('wno');

    let check = confirm("정말 삭제 하시겠습니까?");
    if(check==true){
        const option={method:"DELETE"};
        const response = await fetch(`/waiting?wno=${wno}`,option);
        const data= await response.json();
        
        if(data==true){
            alert("삭제성공");
            location.href="/waiting2/list.jsp"
        }else{
            alert("삭제실패")
        }
    }//if end
}//func end

const waitingUpdateView=()=>{
    const wno= new URLSearchParams(location.search).get('wno');
    location.href=`/waiting2/update.jsp?wno=${wno}`
}