package Spring_practice.exam2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RestController1 {

    @PostMapping("/board")
    @ResponseBody
    public boolean boardWrite(String bcontent, String bwriter){
        System.out.println("RestController1.method1");
        System.out.println("bcontent = " + bcontent + ", bwriter = " + bwriter);
        return true;
    }//method1 end

    @GetMapping("/board")
    @ResponseBody
    public List<BoardDto> boardPrint(){
        ArrayList<BoardDto> boardList = new ArrayList<>();
        System.out.println("RestController1.boardPrint");
        boardList.add(new BoardDto(1,"안녕하세요","유재석"));
        boardList.add(new BoardDto(1,"안녕하세요2","강호동"));
        return boardList;
    }

    @GetMapping("/board/detail")
    @ResponseBody
    public BoardDto boardDto(@RequestParam int bno){
        BoardDto bdto = new BoardDto();
        System.out.println("RestController1.boardDetail");
        System.out.println("bno = " + bno);
        return bdto;
    }

    @DeleteMapping("/board")
    @ResponseBody
    public boolean boardDelete(@RequestParam int bno){
        System.out.println("RestController1.boardDelete");
        System.out.println("bno = " + bno);
        return true;
    }

    @PutMapping("/board")
    @ResponseBody
    public boolean boardUpdate(@RequestBody BoardDto boardDto){
        System.out.println("RestController1.boardUpdate");
        System.out.println("boardDto = " + boardDto);
        return true;
    }
}// class end
