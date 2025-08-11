console.log("list.exe");
//[전체조회]
const boardPrint = async() => {
    console.log("print");
    //1.fetch option 중 GET은 생략가능
    const response = await fetch("/board");
    //2. 응답자료 타입변환
    const data = await response.json();
    //3. 어디에 id=#, class=. 
    const boardTbody = document.querySelector('#boardTbody');
    console.log(boardTbody);
    //4. 무엇을
    let html=``;
    for(let i=0; i<data.length; i++){
        console.log(boardTbody)
        const board=data[i]; // i번째 dto(객체/게시물) 꺼낸다
        html+=`<tr>
                <td> ${board.bno}</td>
                <td> 
                    <a href="/board/view.jsp?bno=${ board.bno }"> 
                            ${ board.bcontent } 
                        </a> 
                </td>
                <td> ${board.bwriter}</td>
             <tr>`
    }

    //5. 출력, innerHTML 속성은 마크업 사이에 요소 대입/호출
    boardTbody.innerHTML=html;
}//func end
boardPrint();