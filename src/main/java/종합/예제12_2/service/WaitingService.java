package 종합.예제12_2.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 종합.예제12_2.model.dao.WaitingDao;
import 종합.예제12_2.model.dto.WaitingDto;

import java.util.ArrayList;

@Service
public class WaitingService {
    @Autowired WaitingDao waitingDao;

    //등록
    public boolean WaitingWrite(WaitingDto waitingDto){
        boolean result = waitingDao.WaitingWrite(waitingDto);
        return result;
    }//func end

    //조회
    public ArrayList<WaitingDto> WaitingPrint(){
        ArrayList<WaitingDto> result = waitingDao.WaitingPrint();
        return result;
    }//func end

    //개별조회
    public WaitingDto WaitingFind(int wno){
        WaitingDto result = waitingDao.WaitingFind(wno);
        return result;
    }//func end

    //수정
    public boolean WaitingEdit(WaitingDto waitingDto){
        boolean result = waitingDao.WaitingEdit(waitingDto);
        return result;
    }//func end

    //삭제
    public boolean WaitingDelete(int wno){
        boolean result = waitingDao.WaitingDelete(wno);
        return result;
    }//func end


}//class end
