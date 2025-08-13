package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.MemberDao;
import web.model.dto.MemberDto;

import java.util.Map;

@Service
public class MemberService {
    @Autowired private MemberDao memberDao;

    //회원가입
    public int signup(MemberDto memberDto){
        int result = memberDao.signup(memberDto);
        return result;
    }//func end

    //로그인
    public int login(MemberDto memberDto){
        int result= memberDao.login(memberDto);
        return result;
    }//func end

    //회원정보
    public MemberDto info(int mno){
        MemberDto result= memberDao.info(mno);
        return result;
    }//func end


    //중복검사
    public boolean check(String type,String data){
        boolean result= memberDao.check(type,data);
        return result;
    }//func end

    //회원정보수정
    public boolean _update(MemberDto memberDto){
        boolean result = memberDao._update(memberDto);
        return result;
    }//func end

    //회원비밀번호수정
    public boolean updatePassword(int mno, Map<String, String>map){
        boolean result = memberDao.updatePassword(mno,map);
        return result;
    }//func end

    //회원탈퇴
    public boolean _delete(int mno, String oldpwd){
        boolean result= memberDao._delete(mno,oldpwd);
        return result;
    }

}//class end
