package 종합.예제12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 종합.예제12.model.dao.BoardDao;
import 종합.예제12.model.dto.BoardDto;

import java.util.ArrayList;

@Service
public class BoardService {
    @Autowired private BoardDao boardDao;

    //등록
    public boolean boardWrite(BoardDto boardDto){
        boolean result = boardDao.boardWrite(boardDto);
        System.out.println("BoardService.BoardWrite");
        return result;
    }//func end

    //조회
    public ArrayList<BoardDto> boardPrint(){
        ArrayList<BoardDto> result = boardDao.boardPrint();
        System.out.println("BoardService.BoardPrint");
        return result;
    }//func end

    //개별조회
    public BoardDto boardFind(int bno){
        BoardDto result = boardDao.boardFind(bno);
        System.out.println("BoardService.boardFind");
        System.out.println("bno = " + bno);
        return result;
    }

    //수정
    public boolean boardEdit(BoardDto boardDto){
        boolean result = boardDao.boardEdit(boardDto);
        System.out.println("BoardService.BoardEdit");
        return result;
    }//func end


    //삭제
    public boolean boardDelete(int bno){
        boolean result = boardDao.boardDelete(bno);
        System.out.println("BoardService.BoardDelete");
        return result;
    }

}//class end
