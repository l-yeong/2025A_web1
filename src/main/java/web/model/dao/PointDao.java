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
    public int pointSignup(PointDto pointDto){
        try{
            String sql = "INSERT INTO pointlog (mno, plpoint, plcomment) VALUES (LAST_INSERT_ID(), 1000, '회원가입');";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pointDto.getMname());
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
