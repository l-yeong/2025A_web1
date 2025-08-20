console.log("memberSales.js exe")

const memberSales = async ()=>{
    const response = await fetch("/assessment/sales");
    const data = await response.json();
    const salesTbody = document.querySelector('#salesTbody');

    let html=``;
    for(let i=0; i<data.length; i++){
        const sales = data[i];
        let gradeName=sales.grade;
        if(gradeName=="A"){
            gradeName="VIP";
        }else if(gradeName=="B"){
            gradeName="일반";
        }else if(gradeName=="C"){
            gradeName="직원";
        }
        html+=  `<tr>
                    <td>${sales.custno}</td>
                    <td>${sales.custname}</td>
                    <td>${gradeName}</td>
                    <td>${sales.sales}</td>
                </tr>`

    }//for end
    salesTbody.innerHTML=html;
}//func end
memberSales();