package 종합.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import 종합.assessment.service.MemberService;
import 종합.assessment.service.MoneyService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/assessment")
public class MoneyController {
    @Autowired MoneyService moneyService;

    //매출조회
    @GetMapping("/sales")
    public List<Map<String, Object>> MemberSales(){
        List<Map<String, Object>> result = moneyService.MemberSales();
        return result;
    }

}
