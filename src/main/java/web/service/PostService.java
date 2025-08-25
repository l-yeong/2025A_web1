package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.model.dao.PostDao;
import web.model.dto.PageDto;
import web.model.dto.PostDto;

import java.util.List;

@Service
@RequiredArgsConstructor // 롬복 제공: final 변수에 대한 생성자 자동 제공
public class PostService {
    // (*) @RequiredArgsConstructor 사용시 ( @AutoWired 생략해도 자동으로 의존성이 처리된다)
    private final PostDao postDao;

    public int writePost(PostDto postDto) {
        int result = postDao.writePost(postDto);
        return result;
    }//func end

    //전체 조회
    public PageDto findAllPost(int cno,int page, int count){
        // cno: 카테고리번호, page: 현재페이지번호, count: 페이지당 게시물수

        // *************1. 페이지별 조회할 시작(인덱스) 번호 계산 **************
        /* 페이지 당 5개씩 조회 : 1페이지 -> 1, 2페이지 -> 6, 3페이지 -> 11*/
        int startRow= (page-1) * count; // 현재 페이지-1 하고 페이지당 게시물수 곱한다.
        // 1페이지 -> 1-1*5 ->0, 2페이지 2-1*5 -> 5, 3페이지 3-1*5 -> 10
        // 네이버증권페이지 : 1페이지 -> 1-1*20 ->0, 2페이지 2-1*20 -> 20, 3페이지 3-1*20 -> 40

        // *************2. 자료의 개수 구하기, 카테고리 별, 이유: 전체 페이지수 계산하기 **************
        int totalCount = postDao.getTotalCount(cno);
        // *************3. 전체 페이지수 구하기 **************
        int totalPage = totalCount % count ==0? totalCount/count : totalCount/count+1; //나머지가 존재하면 +1
        // 35개의 정보가 있을때 5개씩 조회한다면 총 페이지수는 몇개? 7페이지
        // 42개의 정보가 있을때 10개씩 조회한다면 총 페이지수는 몇개? 4페이지 + 1페이지(나머지2개) => 5페이지

        int btnCount=5; // 한 화면에 보여지는 최대 버튼수
        // *************4. 시작 버튼 구하기 **************
        int startBtn = ((page-1)/btnCount)*btnCount+1; //
        // *************5. 끝 버튼 구하기 **************
        int endBtn = startBtn + btnCount -1;
        if(endBtn > totalPage) endBtn = totalPage; //만약에 끝버튼수가 총 페이지수 보다 커지면 총 페이지수로 끝번호 사용
        /* 총 페이지수가 13일때, 현재페이지 3이면 시작버튼:1, 끝버튼:5 */

        // *************6. 자료 요청, cno:카테고리번호, startRow(시작인덱스), count(페이지당 게시물수) **************
        //SQL 페이징 처리: LIMIT 시작인덱스, 개수
        //1페이지: LIMIT 0,5 /2페이지 : LIMIT 5,5 /3페이지 : LIMIT 10,5 /4페이지 : LIMIT 15,5
        List<PostDto>postList=postDao.findAll(cno,startRow,count);

        // ************* pageDto 구성하기 **************
        PageDto pageDto = new PageDto();
        pageDto.setCurrentPage(page);       //현재 페이지 번호
        pageDto.setTotalPage(totalPage);    //전체 페이지 수
        pageDto.setPerCount(count);         //한페이지당 게시물 수
        pageDto.setTotalCount(totalCount);  //전체 게시물 수
        pageDto.setStartBtn(startBtn);      //시작 페이징 버튼번호
        pageDto.setEndBtn(endBtn);          //끝 페이지 버튼번호
        pageDto.setData(postList);          //페이징한 게시물 리스트
        return pageDto;
    }//func end
}//class end
