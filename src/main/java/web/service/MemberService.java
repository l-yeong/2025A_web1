package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.MemberDao;
import web.model.dto.MemberDto;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
    }//func end
    //아이디 찾기
    public MemberDto searchId(MemberDto memberDto){
        MemberDto result= memberDao.searchId(memberDto);
        return result;
    }//func end
    //비밀번호 찾기
    public Map<String,String> searchPwd(Map<String,String>map) {
        //컨트롤러부터 사용자에게 입력받은 아이디 연락처 매개변수 받음
        String mpwd = "";
        //0~9 사이 6자리 난수생성 할 for문
        for (int i = 0; i <= 6; i++) {
            Random random = new Random(); // 랜덤
            mpwd += random.nextInt(10); // 0~9까지 난수 생성
        }//for end
        map.put("mpwd", mpwd); // 생성된 난수 비밀번호 map 속성 대입
        boolean result = memberDao.searchPwd(map);
        Map<String, String> resultMap = new HashMap<>();
        if (result == true) {
            resultMap.put("msg", mpwd);
        } else {
            resultMap.put("msg", "회원정보없음");
        }//if end
        return resultMap;
    }//func end

}//class end
