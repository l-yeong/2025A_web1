console.log("post.js exe")

// [1] 사용자가 요청한 URL 에서 cno(카테고리) 가져오기/ page(현페이지) 가져오기
const params = new URL(location.href).searchParams;
// new URL(location.href).searchParams; : 현재 페이지의 URL에서 매개변수(?) 값 반환
const cno = params.get('cno'); console.log(cno);
const page = params.get('page') || 1;       // 만약에 page가 존재하지 않으면 1
const key = params.get('key')||'';          //만약에 key가 존재 하지 않으면 ''
const keyword = params.get('keyword')||''; 

// [2] 요청 매개변수를 이용한 fetch 게시물 요청하기
const findAll = async () => {
    console.log("findAll")
    //2-1 try{}catch()
    try {
        //2-2 fetch 이용한 게시물 요청
        const url = `/post?cno=${cno}&page=${page}&key=${key}&keyword=${keyword}`;
        const response = await fetch(url);
        const data = await response.json(); console.log(data); //data<-->pageDto
        //2-3 결과를 에티블에 출력하기
        const postbody = document.querySelector('#postTbody');
        let html = ``;
        //fetch 로 부터 받은 데이터를 html 문자열로 변환
        data.data.forEach((post) => { //data.data <---> pageDto{data}
            // post<---> postDto{}
            html += `
                <tr>
                        <td> ${post.pno} </td>
                        <td> ${post.ptitle} </td>
                        <td> ${post.mid} </td>
                        <td> ${post.pdate} </td>
                        <td> ${post.pview} </td>
                    </tr>
                `
        })
        postbody.innerHTML = html;

        //3. 페이징 버튼 출력 함수 호출
        viewPageButtons(data);

    } catch (error) { console.log(error) }//catch end
}//func end

// [3] 페이징 버튼 출력 함수, findAll 함수 안에서 실행
const viewPageButtons = async (data) => {

    // 백엔드로 부터 받은 pageDto{} <---> data{}
    let currentPage = parseInt(data.currentPage); //parseInt(자료) : 자료를 int 타입으로 변환
    let totalpage = data.totalpage;
    let startBtn = data.startBtn;
    let endBtn = data.endBtn;
    
    // **************** 페이징 처리시 검색 유지 ******************* //
    const searchURL = `&key=${key}&keyword=${keyword}`;

    const pageBtnBox = document.querySelector('.pageBtnBox');
    let html = ``;
    // **************** 이전 버튼 : 1페이지 이면 0 으로 못가게 유효성 검사 ******************* //
    html += `<li>
                <a href="post.jsp?cno=${cno}&page=${ currentPage == 1 ? 1 : currentPage -1}${searchURL}"> 이전 </a>
            </li>`
    // **************** 페이지 버튼 ******************* //
    for(let i=startBtn; i<=endBtn; i++){
        html += `<li>
                    <a href="post.jsp?cno=${cno}&page=${i}${searchURL}" style="${i==currentPage ? 'color:red':'' }">${i}</a>
                </li>`
    }//if end
    // **************** 다음 버튼 : 만약에 다음 페이지가 전체 페이지수보다 커지면 전체페이수로 고정 ******************* //
    html += `<li> 
                <a href="post.jsp?cno=${cno}&page=${currentPage+1 >= totalpage ? totalpage : currentPage +1}${searchURL}"> 다음 </a>
            </li>`

    pageBtnBox.innerHTML = html
}//func end

//[4] 검색 버튼을 클릭했을때
const onSearch = async( )=>{
    //1. 입력받은 key 와 keyword 값 가져오기
    const newkey = document.querySelector('.key').value;         //<select> 에서 가져옴
    const newkeyword = document.querySelector('.keyword').value; //<input> 에서 가져옴

    //2. 페이지 이동, 검색하면 주로 1페이지 이동
    location.href=`post.jsp?cno=${cno}&page=${page}&key=${newkey}&keyword=${newkeyword}`;

}//func end

findAll();