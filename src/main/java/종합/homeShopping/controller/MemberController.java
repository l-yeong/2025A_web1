package 종합.homeShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import 종합.homeShopping.model.dto.MemberDto;
import 종합.homeShopping.service.MemberService;

import java.util.ArrayList;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired MemberService memberService;

    //등록
    @PostMapping("")
    public boolean MemberWrite(@RequestBody MemberDto memberDto){
        boolean result = memberService.MemberWrite(memberDto);
        System.out.println("MemberController.MemberWrite");
        System.out.println("memberDto = " + memberDto);
        return result;
    }//func end

    //조회
    @GetMapping("")
    public ArrayList<MemberDto> MemberPrint(){
        ArrayList<MemberDto> result= memberService.MemberPrint();
        System.out.println("MemberController.MemberPrint");
        return result;
    }//func end

    //수정
    @PutMapping("")
    public boolean MemberUpdate(@RequestBody MemberDto memberDto){
        boolean result= memberService.MemberUpdate(memberDto);
        System.out.println("MemberController.MemberUpdate");
        System.out.println("memberDto = " + memberDto);
        return result;
    }//func end

}//class end
