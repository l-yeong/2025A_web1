
const memberFind = async () => {
    const custno = new URLSearchParams(location.search).get('custno');
    const response = await fetch(`/assessment/find?custno=${custno}`);
    const data = await response.json();
    const custnoInput = document.querySelector('.custno');
    const joinInput = document.querySelector('.joindate');


    custnoInput.value = data.custno;
    joinInput.value=data.joindate;

}
memberFind();

const memberUpdate = async () => {
    const custno = new URLSearchParams(location.search).get('custno');
    const custname = document.querySelector('.custname').value;
    const phone = document.querySelector('.phone').value;
    const address = document.querySelector('.address').value;
    const grade = document.querySelector('.grade').value;
    const city = document.querySelector('.city').value;

    const obj = { custno, custname, phone, address, grade, city };

    const option = {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(obj)
    }//option end
    const response = await fetch("/assessment/update", option);
    const data = await response.json();

    if(data==true){
        alert("회원정보수정이 완료되었습니다.");
        location.href=`/assessment/memberList.jsp`;
    }else{
        alert("회원정보수정이 실패했습니다.");
    }//if end
}//func end