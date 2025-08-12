console.log("list js exe")

const boardPrint = async () => {
    const response = await fetch("/waiting");
    const data = await response.json();

    const waitingTbody = document.querySelector('#waitingTbody');

    let html = '';
    for (let i = 0; i < data.length; i++) {
        const wait = data[i];
        html += ` <tr>
                    <td> ${wait.wno} </td>
                    <td> 
                    <a href=/waiting2/view.jsp?wno=${wait.wno}>
                    ${wait.wphone} </a> 
                    </td>
                    <td> ${wait.wcount} </td> 
                    <td> ${wait.wdate} </td> 
                <tr>`
    }//for end
    waitingTbody.innerHTML = html;
}//func end
boardPrint();