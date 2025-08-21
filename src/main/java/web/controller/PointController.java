package web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.dto.PointDto;
import web.service.PointService;

@RestController
@RequestMapping("/memberpoint")
public class PointController {
    @Autowired
    PointService pointService;


    // 회원가입 포인트 적립
    @PostMapping("/pointsignup")
    public int memberSignup(@RequestBody PointDto pointDto){
        System.out.println("PointMemberController.memberSignup");
        System.out.println("pointMemberDto = " + pointDto);
        int result = pointService.pointSignup(pointDto);
        return result;
    }

}//func end
