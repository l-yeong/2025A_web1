package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.PointDao;
import web.model.dto.PointDto;

@Service
public class PointService {
    @Autowired PointDao pointDao;
    //회원가입 포인트 적립
    public int pointSignup(PointDto pointDto){
        int result = pointDao.pointSignup(pointDto);
        return result;
    }//func end

}//func end
