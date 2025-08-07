const list = async ()=>{
    const option={method:"GET"}
    const response= await fetch("/wait/list",option)
    const data= await response.json();

    const waitingtbody = document.querySelector("#waitingTbody");

    let html="";
    for(let i=0; i<=data.length-1; i++){
        const waiting = data[i]; console.log(data[i]);
        
        html +=`
                <tr>
                    <td> ${waiting.wno} </td> <td> ${waiting.wphone} </td>
                    <td> ${waiting.wcount} </td> <td> ${waiting.wdate} </td>
                </tr>
                `
    }//for end
    waitingtbody.innerHTML=html;
}
list();