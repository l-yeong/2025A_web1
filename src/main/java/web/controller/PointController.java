package web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.dto.PointDto;
import web.service.PointService;

@RestController
@RequestMapping("/point")
public class PointController {
    @Autowired PointService pointService;


    //회원가입 포인트 적립
    @PostMapping("/signup")
    public boolean pointSignup(@RequestBody PointDto pointDto,HttpSession session){
        if(session==null||session.getAttribute("lginMno")==null){return false;}
        int loginMno=(int)session.getAttribute("loginMno");
        boolean result = pointService.pointSignup(pointDto);
        return false;


    }//func end

}//class end
