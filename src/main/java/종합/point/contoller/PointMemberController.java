package 종합.point.contoller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import 종합.point.model.dto.PointMemberDto;
import 종합.point.service.PointMemberService;

@RestController
@RequestMapping("/memberpoint")
public class PointMemberController {
    @Autowired PointMemberService pointMemberService;

    // 로그인
    @PostMapping("/login")
    public int memberLogin(@RequestBody PointMemberDto pointMemberDto, HttpServletRequest request){
        HttpSession session = request.getSession();
        int result = pointMemberService.memberLogin(pointMemberDto);
        if(result>0){
            session.setAttribute("pointMno",result);
        }//if end
        return result;
    }//func end

    // 회원가입
    @PostMapping("/signup")
    public int memberSignup(@RequestBody PointMemberDto pointMemberDto){
        int result = pointMemberService.memberSignup(pointMemberDto);
        return result;
    }

}//func end
