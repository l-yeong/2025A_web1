package 종합.예제12_2.model.dao;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import 종합.예제12_2.model.dto.WaitingDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class WaitingDao extends Dao{
    //등록
    public boolean WaitingWrite(WaitingDto waitingDto) {
        try {
            String sql = "INSERT INTO waiting (wphone,wcount) VALUES (?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,waitingDto.getWphone());
            ps.setInt(2,waitingDto.getWcount());
            int count = ps.executeUpdate();
            if(count==1)return true;
        } catch (Exception e) {System.out.println(e);}//catch end
        return false;
    }//func end

    //조회
    public ArrayList<WaitingDto>WaitingPrint(){
        ArrayList<WaitingDto>list= new ArrayList<>();
        try{
            String sql = "SELECT *FROM waiting;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int wno = rs.getInt("wno");
                String wphone = rs.getString("wphone");
                int wcount = rs.getInt("wcount");
                String wdate= rs.getString("wdate");
                WaitingDto waitingDto = new WaitingDto(wno,wphone,wcount,wdate);
                list.add(waitingDto);
            }//while end
        } catch (Exception e) {System.out.println(e+"조회");}//catch end
        return list;
    }//func end

    //개별조회
    public WaitingDto WaitingFind(int wno){
        try{
            String sql= "SELECT *FROM waiting WHERE wno=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,wno);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                WaitingDto waitingDto = new WaitingDto();
                waitingDto.setWno(rs.getInt(1));
                waitingDto.setWphone(rs.getString(2));
                waitingDto.setWcount(rs.getInt(3));
                waitingDto.setWdate(rs.getString(4));
                return waitingDto;
            }
        } catch (Exception e) {System.out.println(e+"개별조회");}//catch end
        return null;
    }//func end

    //수정
    public boolean WaitingEdit( WaitingDto waitingDto){
        try{
            String sql = "UPDATE waiting SET wcount=?,wphone=? WHERE wno=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,waitingDto.getWcount());
            ps.setString(2,waitingDto.getWphone());
            ps.setInt(3,waitingDto.getWno());
            int count = ps.executeUpdate();
            if(count==1) return true;
        } catch (Exception e) {System.out.println(e);}//catch end
        return false;
    }//func end

    //삭제
    public boolean WaitingDelete( int wno){
        try {
            String sql = "DELETE FROM waiting WHERE wno=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,wno);
            int count= ps.executeUpdate();
            if(count==1)return true;
        } catch (Exception e) {System.out.println(e);}//catch end
        return false;
    }//func end

}//class end
