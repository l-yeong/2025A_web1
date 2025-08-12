package 종합.homeShopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 종합.homeShopping.model.dao.MemberDao;
import 종합.homeShopping.model.dto.MemberDto;

import java.util.ArrayList;

@Service
public class MemberService {
    //등록
    @Autowired MemberDao memberDao;
    public boolean MemberWrite(MemberDto memberDto) {
        boolean result = memberDao.MemberWrite(memberDto);
        System.out.println("MemberService.MemberWrite");
        System.out.println("memberDto = " + memberDto);
        return result;
    }//func end

    //조회
    public ArrayList<MemberDto> MemberPrint(){
        ArrayList<MemberDto> result = memberDao.MemberPrint();
        System.out.println("MemberService.MemberPrint");
        return result;
    }//func end

    //수정
    public boolean MemberUpdate(MemberDto memberDto){
        boolean result = memberDao.MemberUpdate(memberDto);
        return result;
    }//func end
}//class end
