package 종합.point.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 종합.point.model.dao.PointMemberDao;
import 종합.point.model.dto.PointMemberDto;

@Service
public class PointMemberService {
    @Autowired PointMemberDao pointMemberDao;

    public int memberLogin(PointMemberDto pointMemberDto){
        int result = pointMemberDao.memberLogin(pointMemberDto);
        return result;
    }//func end

    public int memberSignup(PointMemberDto pointMemberDto){
        int result = pointMemberDao.memberSignup(pointMemberDto);
        return result;
    }//func end

}//func end
