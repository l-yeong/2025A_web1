package Spring_practice.exam1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {
    @PostMapping("/exam1/board")
    @ResponseBody
    public boolean postBoard(){
        System.out.println("BoardController.글쓰기");
        return true;
    }//post end

    @GetMapping("/exam1/board")
    @ResponseBody
    public List<BoardDto> getBoard(){
        System.out.println("BoardController.list");
        ArrayList<BoardDto> list = new ArrayList<>();
        list.add(new BoardDto());
        list.add(new BoardDto());
        return list;
    }

    @GetMapping("/exam1/board/view")
    @ResponseBody
    public Map<String, Integer> boardMap(){
        System.out.println("BoardController.boardMap");

        Map<String,Integer> map = new HashMap();
        map.put("유재석",10);
        return map;
    }

    @PutMapping("/exam1/board")
    @ResponseBody
    public boolean boardPut(){
        return true;
    }

    @DeleteMapping("/exam1/board")
    @ResponseBody
    public String boardDelete(){
        System.out.println("BoardController.boardDelete");
        return "임의의 삭제한 번호, 3";
    }



    // Spring 실습1 : 게시판 RestController 만들기
    // 1. AppStart 클래스 생성    2. BoardController 클래스 생성
    // 3. 각 URL 매핑 만들기
    //     1. 글쓰기           POST       "/exam1/board"
    // 요청자료 : x , 응답자료 : true/false
    //
    //         2. 전체 글 조회      GET        "/exam1/board"
    // 요청자료 : x , 응답자료 : 임의의 List 타입 ,  [ {bno:'',btitle:''} ,  {bno:'',btitle:''}  ] , 아래 참고
    //
    //     3. 개별 글 조회      GET        "/exam1/board/view"
    // 요청자료 : x , 응답자료 : 임의의 MAP  타입  ,  {bno:'',btitle:''} , 아래 참고
    //
    //     4. 개글 글 수정      PUT        "/exam1/board"
    // 요청자료 : x , 응답자료 : true 또는 false
    //
    //         5. 개별 글 삭제      DELETE     "/exam1/board"
    // 요청자료 : x , 응답자료 : 임의의 삭제한 번호 , 3
    // 제출 :
    //         1. 카카오톡방에 ip 제출 ( 강사가 체크 할때 까지 서버 켜주세요 )
    //2. itdanja.com에 과제 코드 git 링크 제출

}
