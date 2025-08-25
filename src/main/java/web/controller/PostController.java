package web.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import web.model.dto.PageDto;
import web.model.dto.PostDto;
import web.service.PostService;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor // final 변수에 대한 자동 생성자 주입
public class PostController {
    private final PostService postService; //@RequiredArgsConstructor 사용함으로 @Autowired 생략 한다.

    @PostMapping("")
    public int writePost(@RequestBody PostDto postDto, HttpSession session) {
        System.out.println("PostController.writePost");
        System.out.println("postDto = " + postDto + ", session = " + session);
        //1. 현재 로그인상태 확인
        Object login = session.getAttribute("loginMno");
        //2. 비로그인이면 등록 실패처리
        if(session.getAttribute("loginMno")==null)return 0;
        //3. 로그인이면 현재 로그인한 회원번호를 postDto 대입하기
        int mno = (int)login;
        postDto.setMno(mno);
        //4. 서비스 호출 하고 응답 반환 하기
        return postService.writePost(postDto);
    }//func end
    @GetMapping("")// URL: localhost:8080/post?cno=1&page=1&count=5
    public PageDto findAllFind(@RequestParam (defaultValue = "1") int cno,
                               @RequestParam (defaultValue = "1") int page,
                               @RequestParam (defaultValue = "5") int count){
        //만약에 UTL 주소상의 쿼리스트링 매개변수가 없으면 defaultValue속성으로 기본값 대입 할수 있다.
        return postService.findAllPost(cno,page,count);
    }//func end
}//class end
