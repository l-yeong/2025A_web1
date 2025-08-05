package 종합.예제8.controller;


import org.springframework.web.bind.annotation.*;
import 종합.예제8.model.dao.WatitingDao;
import 종합.예제8.model.dto.WaitingDto;

import java.util.ArrayList;

@RestController
public class WaitingController {

    //등록
    @PostMapping("/wait")
    public boolean WaitingAdd(@RequestBody WaitingDto waitingDto){
        boolean result = WatitingDao.getInstance().WaitingAdd(waitingDto);
        return result;
    }//func end

    //조회
    @GetMapping("/wait")
    ArrayList<WaitingDto>WaitingList(){
        ArrayList<WaitingDto> result = WatitingDao.getInstance().WaitingList();
        return result;
    }//func end

    @PutMapping("/wait")
    public boolean WaitingEdit(@RequestBody WaitingDto waitingDto){
        boolean result = WatitingDao.getInstance().WaitingEdit(waitingDto);
        return result;
    }

    @DeleteMapping("/wait")
    public boolean WaitingDelete(@RequestParam int wno){
        boolean result = WatitingDao.getInstance().WaitingDelete(wno);
        return result;
    }

}//class end
