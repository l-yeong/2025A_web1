package 종합.예제12_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import 종합.예제12_2.model.dto.WaitingDto;
import 종합.예제12_2.service.WaitingService;

import java.util.ArrayList;

@RestController
@RequestMapping("/waiting")
public class WaitingController {
    @Autowired private WaitingService waitingService;

    //등록
    @PostMapping("")
    public boolean WaitingWrite(@RequestBody WaitingDto waitingDto){
        boolean result = waitingService.WaitingWrite(waitingDto);
        return result;
    }//func end

    @GetMapping("")
    public ArrayList<WaitingDto> WaitingPrint(){
        ArrayList<WaitingDto> result = waitingService.WaitingPrint();
        return result;
    }//func end

    @GetMapping("/find")
    public WaitingDto WaitingFind(@RequestParam int wno){
        WaitingDto result = waitingService.WaitingFind(wno);
        return result;
    }//func end

    @PutMapping("")
    public boolean WaitingEdit(@RequestBody WaitingDto waitingDto){
        boolean result = waitingService.WaitingEdit(waitingDto);
        return result;
    }//func end

    @DeleteMapping("")
    public boolean WaitingDelete(@RequestParam int wno){
        boolean result=waitingService.WaitingDelete(wno);
        return result;
    }//func end


}//class end
