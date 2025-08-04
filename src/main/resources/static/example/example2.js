console.log("example2.js open"); //** HTML에 js 파일 연동 확인 **

//TalendAPI 대신에 실제로 통신 함수 만들어보기
//(1)
const func1 = ( ) => { console.log("func1 exe")
// * fetch 이용한 스프링 Controller 와 통신하기, GET 방식은 생략 가능
    fetch("/day04/exam1",{method:"GET"});
}//func end


//(2)
const func2 = ( ) => { console.log("func2 exe")
    fetch("/day04/exam2",{method:"POST"});
}//func end

//(3)
const func3 = ( ) => { console.log("func3 exe")
    // + baseURL(localhost:8080) 생략이 가능하다.
    fetch("/day04/exam3",{method:"PUT"});
}//func end

//(4)
const func4 = ( ) => { console.log("func4 exe")
    fetch("/day04/exam4",{method:"DELETE"});
}//func end

//(5)
const func5 = ( ) => { console.log("func5 exe")
        const name="유재석";
        const age=10;
        // + fetch 함수를 이용한 쿼리스트링 방식, `백틱
         fetch(`/day04/exam5?name=${name}&age=${age}`,{method:"GET"})
              .then(response => response.json())          //1)응답 자료를 매개변수로 받아 JSON 타입으로 변환
              .then(data=>{console.log(data);})          //2)타입변환된 자료를 매개변수로 받아 실행문 처리
              .catch(error => {console.log(error)});    //3)만약에 fetch 통신간에 오류 발생시 실행문 처리
}//func end

//(6)
const func6 = ( ) => { console.log("func6 exe")
    const name="유재석"; const age=10;
    // + fetch 함수들 이용한 BODY봉문 방식,
    const option = { 
        method:"POST",
        headers:{"Content-Type":"application/json"}, //HTTP BODY 타입 설정
        body:JSON.stringify({name:name,age:age}) //JSON 타입으로 변환, 
        // JSON.stringfly( ): JS객체 --> 문자열 타입 변환
        // JSON.parse( ): 문자열 타입 --> JS 객체 변환
    }//option end
    fetch("/day04/exam6",option)                //1] URL    2]option{method:,headers:,body:}
    .then(response => response.json())          //3] 응답자료 타입 변환, JSON
    .then(data => console.log(data))            //4] 타입변환된 자료, data
    .catch(error => {console.log(error)})        //5] 예외 발생시 error
}//func 

//(7)PUT
const func7 = ( ) => { console.log("func7 exe")
    let sample = {name:"유재석",age:10};
    let option = { 
        method:"PUT",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify(sample)
    } //option end
    fetch("/day04/exam7",option)
    .then(response=>response.json())
    .then(data => console.log(data))
    .catch(error => {console.log(error)})
}//func end


//(8)DELETE
const func8 = ( ) => { console.log("func8 exe")
    let name="유재석"; let age=1;
    // + option 생략
    fetch(`/day04/exam8?name=${name}&age=${age}`,{method:"DELETE"})
    .then( r => r.json())
    .then(d => console.log(d))
    .catch(e => {console.log(e)})
}
/*
    [ FETCH ] 라이브러리 (내장)함수
        - 외부 주소로 부터 요청과 응답을 지원하는 함수
        - 사용법
            fetch(URL,HEADER)
            .then(응답매개변수 => 응답매개변수.json)
            .then(date => { });
                1) 통신할 URL 주소
                2) 통신할 HEADER 옵션
                    { method : "HTTP 메소드" }
                3) then(응답매개변수 => 응답매개변수.json()) : 응답 자료를 매개변수로 받아 JSON타입으로 반환
                4) then(date => {실행문;})                  : 타입변환된 자료를 매개변수로 받아 실행문처리
                5) catch(error => {실행문;})                : 만약에  fetch 통신간에 오류 발생시 실행문 처리
*/

