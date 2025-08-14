package web.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.dto.MemberDto;
import web.service.MemberService;

import java.util.Map;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired private MemberService memberService;

    //회원가입
    @PostMapping("/signup")
    public int signup(@RequestBody MemberDto memberDto) {
        int result = memberService.signup(memberDto);
        return result;
    }//func end

    //로그인
    @PostMapping("/login")
    public int login(@RequestBody MemberDto memberDto, HttpServletRequest request){
        //1. 세션 정보 가져 오기
        HttpSession session = request.getSession();
        //2. 로그인 성공한 회원번호 확인
        int result = memberService.login(memberDto);
        if(result>0){
            session.setAttribute("loginMno",result); // 속성값은 자동타입 변환으로 Object 타입
        }
        return result;
    }//func end

    //로그아웃
    @GetMapping("/logout")
    public boolean logout(HttpServletRequest request){
        // 1. 요청 객체내 세션 정보 꺼내기
        HttpSession session = request.getSession();
        // 2. 만약에 세션이 없거나 특정한 속성값이 없으면(유효성 검사)
        if(session==null||session.getAttribute("loginMno")==null){
            return false;
        }//if end
        // 3. 로그인 상태이면 속성값 제거
        session.removeAttribute("loginMno");
        return true; //로그아웃 성공
    }

    //회원정보
    @GetMapping("/info")
    public MemberDto info(HttpServletRequest request){
        System.out.println("MemberController.info");
        System.out.println("request = " + request);
        // 1.HttpServletRequest(요청정보)객체 에서 세션 객체 꺼내기
        HttpSession session = request.getSession();
        // 2. 만약에 비어있으면 비로그인 상태
        if(session==null||session.getAttribute("loginMno")==null){return null;}//if end
        // 3. 로그인상태이면 세션 정보내 로그상태 속성값 호출
        Object obj = session.getAttribute("loginMno"); // 로그인시 정의 속성명과 동일하게 작성
        //Object타입은 자바의 최상위 클래스로써 모든 자료를 저장한다. 세션은 Object 타입으로 저장한다.
        // 즉] 세션은 모든 타입의 자료를 저장 할수 있다.
        // 4. 타입변환, 강제타이변환이란? (반환할타입명) 변수명; **태생!!!** : Object가 되기전에 타입 확인? int
        int loginMno = (int)obj;
        // 5. 서비스에게 전달하고 응답 받기
        MemberDto result = memberService.info(loginMno);
        return result;
    }//func end

    //중복검사
    @GetMapping("/check")
    public boolean check(@RequestParam String type, @RequestParam String data){
        boolean result = memberService.check(type,data);
        return  result;
    }//func end

    //회원정보수정
    @PutMapping("/update")
    public boolean _update(@RequestBody MemberDto memberDto, HttpServletRequest request){
        System.out.println("MemberController._update");
        System.out.println("memberDto = " + memberDto + ", request = " + request);
        //1. 세션 객체 꺼내기
        HttpSession session = request.getSession();
        //2. 만약에 세션이 없다면 비로그인상태:*수정 불가능
        if(session==null|| session.getAttribute("loginMno")==null){
            return false;
        }//if end
        // 3. 로그인된 회원번호 꺼내기 = 수정 하는 회원의 번호
        Object obj = session.getAttribute("loginMno");
        int loginMno = (int)obj;
        // 4.dto 담아주기
        memberDto.setMno(loginMno);
        // 5. 서비스에게 전달 후 응답 받기
        boolean result= memberService._update(memberDto);
        return result;
    }

    //회원비밀번호수정
    @PutMapping("/update/password")
    public boolean updatePassword(@RequestBody Map<String, String>map, HttpServletRequest request){
        HttpSession session = request.getSession();                                       //1.
        if(session==null||session.getAttribute("loginMno")==null){ return false;}   //2.
        Object obj = session.getAttribute("loginMno");
        int loginMno=(int)obj;
        boolean result = memberService.updatePassword(loginMno,map);
        session.removeAttribute("loginMno"); //세션 초기화 (로그아웃)
        return result;
    }//func end

    //회원탈퇴
    @DeleteMapping("/delete")
    public boolean _delete(@RequestParam String oldpwd, HttpSession session){
        //1. 매개변수로 받은 요청정보내 세션 객체를 확인 해서 없으면 비로그인 상태
        if(session==null||session.getAttribute("loginMno")==null){ return false;}
        int loginMno=(int)session.getAttribute("loginMno");
        boolean result = memberService._delete(loginMno,oldpwd);
        if(result==true) session.removeAttribute("loginMno"); //세션 초기화(로그아웃)
        return result;
    }//func end
}//class end
