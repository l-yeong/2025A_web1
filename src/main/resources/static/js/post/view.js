

//http://localhost:8080/post/view.jsp?  [pno=1.jsp]<= searchParams 부분 가져오기 
// [*] 현재 URL 경로상의 pno 매개변수 값 가져오기 (searchParams ==queryString == ?매개변수명=값)
const params = new URL(location.href).searchParams;
const pno = params.get('pno');

console.log("reply exe");

//[1] 개별조회
const getPost = async () => {
    //1. fetch로 부터 출력할 게시물 조회 요청
    const response = await fetch(`/post/view?pno=${pno}`);
    const data = await response.json();
    console.log(data);
    //2. 응답 받은 자료를 특정한 html에 출력한다
    document.querySelector('.mid').innerHTML=data.mid;
    document.querySelector('.pview').innerHTML=data.pview;
    document.querySelector('.pdate').innerHTML=data.pdate;
    document.querySelector('.ptitle').innerHTML=data.ptitle;
    document.querySelector('.pcontent').innerHTML=data.pcontent;
    
    //3. 내가 쓴글이면 삭제버튼과  수정버튼 만들기
    if(data.host){
        document.querySelector('.etcBox').innerHTML=`
                                            <button type="button" onclick="deletePost()">삭제</button>
                                            <button type="button" onclick="location.href='/post/updateReply.jsp?pno=${pno}'">수정</button>
                                        `
    }
}//func end


//[2]개별삭제
const deletePost= async()=>{
    let check = confirm("정말 삭제?");
    if(check==true){
        const option={method:"DELETE"};
        const response = await fetch(`/post?pno=${pno}`,option);
        const data=await response.json();

        if(data==true){
            alert("삭제 성공");
            location.href='post.jsp?cno=1'
        }else{
            alert("삭제실패");
        }//if end
    }//if end
}//func end
//[3]조회중인 게시물의 댓글쓰기

const writeReply = async() =>{

    const rcontentInput = document.querySelector('.rcontent');
    const rcontent = rcontentInput.value;

    const object={pno,rcontent};

    const option={
        method:"POST",
        headers:{"content-type":"application/json"},
        body:JSON.stringify(object)
    }//option end

    const response = await fetch("/post/reply",option)
    const data = await response.json();
    if(data==0){
        alert("실패");
    }else{
        alert("등록성공");
        rcontentInput.value="";
        findAllReply();
    }//if end
}//func end

//[4]조회중인 게시물의 전체 댓글 조회
const findAllReply = async() =>{
    //1. fetch 이용한 현재 게시물의 전체 댓글 요청
    const response = await fetch(`/post/reply?pno=${pno}`);
    const data = await response.json();
    console.log(data);
    //2.fetch 응답 자료 html 형식으로 출력
    const replyList = document.querySelector('.replyList');
    let html =`<h3>댓글</h3>`;
    data.forEach((reply)=>{
        html+=`
                <div>
                    <div>
                     작성자: <span>${reply.mid}</span>
                     작성일: <span>${reply.rdate}</span>
                     작성자: <span>${reply.mid}</span>
                    </div>
                    <div>
                        ${reply.rcontent}
                    </div>
            </div>`
    })
    replyList.innerHTML=html;
}//func end
getPost();
findAllReply();