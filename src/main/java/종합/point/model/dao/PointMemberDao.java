package 종합.point.model.dao;

import org.springframework.stereotype.Repository;
import 종합.point.model.dto.PointMemberDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@Repository
public class PointMemberDao extends Dao{
    //로그인
    public int memberLogin(PointMemberDto pointMemberDto){
        try {
            String sql = "select *from member where mid=? and mpwd=?";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pointMemberDto.getMid());
            ps.setString(2, pointMemberDto.getMpwd());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int mno = rs.getInt("mno");
                return mno;
            }//if end
        } catch (Exception e) {
            System.out.println(e);}//catch end
        return 0;
    }//func end

    //회원가입
    public int memberSignup(PointMemberDto pointMemberDto){
        try{
            String sql = "INSERT INTO member(mname,mid,mpwd,mphone)values(?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,pointMemberDto.getMname());
            ps.setString(2, pointMemberDto.getMid());
            ps.setString(3, pointMemberDto.getMpwd());
            ps.setString(4, pointMemberDto.getMphone());
            int count = ps.executeUpdate();
            if(count==1){
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    int mno= rs.getInt(1);
                    return mno;
                }//if end
            }//if end
        } catch (Exception e) {
            System.out.println(e);}//catch end
        return 0;
    }//func end

}//class end
