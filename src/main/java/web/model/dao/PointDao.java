package web.model.dao;

import org.springframework.stereotype.Repository;
import 종합.point.model.dao.Dao;
import web.model.dto.PointDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@Repository
public class PointDao extends Dao {

    //회원가입 포인트 적립
    public boolean  pointSignup(PointDto pointDto){
        try{
            String sql = "INSERT INTO pointlog (mno, plpoint, plcomment) VALUES (?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,pointDto.getMno());
            ps.setInt(2,pointDto.getPlpoint());
            ps.setString(3,pointDto.getPlcomment());
            int count = ps.executeUpdate();
            if(count==1)return true;
        } catch (Exception e) {
            System.out.println(e);}//catch end
        return false;
    }//func end

}//class end
