package example.day07_20250807;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/wait")
public class WaitingController {
    private WaitingDao waitingDao = WaitingDao.getInstance();

    @PostMapping("/add")
    public boolean WaitingAdd(@RequestBody WaitingDto waitingDto){
        System.out.println("WaitingController.WaitingAdd");
        System.out.println("waitingDto = " + waitingDto);
        boolean result = waitingDao.WaitingAdd(waitingDto);
        return result;
    }//func end

    @GetMapping("/list")
    public ArrayList<WaitingDto> WaitingList(){
        ArrayList<WaitingDto> result = waitingDao.WaitingList();
        return result;
    }//func end

}
