package 종합.assessment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 종합.assessment.model.dao.MoneyDao;

import java.util.List;
import java.util.Map;

@Service
public class MoneyService {
    @Autowired MoneyDao moneyDao;
    //매출조회

    public List<Map<String, Object>> MemberSales(){
        List<Map<String, Object>> result = moneyDao.MemberSales();
        return result;
    }//func end

}