package 종합.예제12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import 종합.예제12.model.dto.BoardDto;
import 종합.예제12.service.BoardService;

import java.util.ArrayList;

@RestController
@RequestMapping("/board") //+공통 URL
public class BoardController {
    @Autowired private BoardService boardService;

    @PostMapping("")
    public boolean boardWrite(@RequestBody BoardDto boardDto){
        boolean result = boardService.boardWrite(boardDto);
        System.out.println("BoardController.boardWrite");
        System.out.println("boardDto = " + boardDto);
        return result;
    }//func end

    @GetMapping("")
    public ArrayList<BoardDto>boardPrint(){
        ArrayList<BoardDto> result = boardService.boardPrint();
        System.out.println("BoardController.boardPrint");
        return result;
    }//func end

    @GetMapping("/find")
    public BoardDto boardFind(@RequestParam int bno){
        BoardDto result = boardService.boardFind(bno);
        System.out.println("BoardController.boardFind");
        System.out.println("bno = " + bno);
        return result;
    }//func end


    @PutMapping("")
    public boolean boardEdit(@RequestBody BoardDto boardDto){
        boolean result= boardService.boardEdit(boardDto);
        System.out.println("BoardController.boardEdit");
        System.out.println("boardDto = " + boardDto);
        return result;
    }//func end

    @DeleteMapping("")
    public boolean boardDelete(@RequestParam int bno){
        boolean result=boardService.boardDelete(bno);
        System.out.println("BoardController.boardDelete");
        System.out.println("bno = " + bno);
        return result;
    }//func end

}//class end
