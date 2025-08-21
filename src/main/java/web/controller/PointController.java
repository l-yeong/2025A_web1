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
    @Autowired
    PointService pointService;


    //// 회원가입 포인트 적립
    //@PostMapping("/signup")
    //public int pointSignup(@RequestBody PointDto pointDto,HttpServletRequest request){
    //
    //    //1. 회원가입 상태 확인 후 비회원이면 0
    //    HttpSession session = request.getSession();
    //    //2. 포인트정보 DB 처리한다.
    //    int loginMno=(int) session.getAttribute("loginMno");
    //    pointDto.setMno(loginMno);
    //    int result = pointService.pointSignup(pointDto);
    //
    //
    //}

}//func end
