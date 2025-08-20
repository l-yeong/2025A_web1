 console.log("memberList.js exe")
const memberList = async() => {
    const response = await fetch("/assessment/list");
    const data =await response.json();
    const memberTbody = document.querySelector('#memberTbody');

    let html=``;
    for(let i=0; i<data.length; i++){
        const list = data[i];
        let gradeName = list.grade;
        if(gradeName==="A"){
            gradeName="VIP";
        }else if(gradeName==="B"){
            gradeName="일반";
        }else if(gradeName==="C"){
            gradeName="직원";
        }
        html+=  `<tr>
                    <td>
                    <a href=/assessment/memberUpdate.jsp?custno=${list.custno}>
                    ${list.custno}</a>
                    </td>
                    <td>${list.custname}</td>
                    <td>${list.phone}</td>
                    <td>${list.address}</td>
                    <td>${list.joindate}</td>
                    <td>${gradeName}</td>
                    <td>${list.city}</td>
                </tr>
                `
    }//for end
    memberTbody.innerHTML=html;
}//func end
memberList();