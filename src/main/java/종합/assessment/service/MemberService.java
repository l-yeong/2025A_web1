package 종합.assessment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 종합.assessment.model.dao.MemberDao;
import 종합.assessment.model.dto.MemberDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    //회원번호,가입일(자동발생)
    public MemberDto auto(MemberDto memberDto){
        MemberDto result = memberDao.auto(memberDto);
        return result;
    }//func end

    //개별조회
    public MemberDto MemberFind(int custno){
        MemberDto result = memberDao.MemberFind(custno);
        return result;
    }//func end
}//class end
