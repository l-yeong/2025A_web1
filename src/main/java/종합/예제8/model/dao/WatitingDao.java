package 종합.예제8.model.dao;

import 종합.예제8.model.dto.WaitingDto;

import java.sql.*;
import java.util.ArrayList;

public class WatitingDao {
    private WatitingDao(){ connect(); }
    private static final WatitingDao instance = new WatitingDao();
    public static WatitingDao getInstance(){
        return instance;
    }
    // (*) DB 연동
    private String db_url = "jdbc:mysql://localhost:3306/exam8";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn;
    private void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection( db_url , db_user , db_password );
        }catch (Exception e ){ System.out.println(e);   }
    }

    //등록
    public boolean WaitingAdd(WaitingDto waitingDto){
        try {
            String sql = "INSERT INTO waiting (wPhone,wCount) VALUES (?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, waitingDto.getwPhone());
            ps.setInt(2,waitingDto.getwCount());
            int count = ps.executeUpdate();
            if(count==1)return true;
            return false;
        } catch (Exception e) {System.out.println(e);}//catch end
        return false;
    }//func end

    //조회
    public ArrayList<WaitingDto> WaitingList(){
        ArrayList<WaitingDto>list = new ArrayList<>();
        try {
            String sql = "SELECT *FROM waiting;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int wno = rs.getInt("wno");
                String wPhone = rs.getString("wPhone");
                int wCount= rs.getInt("wCount");
                WaitingDto waitingDto = new WaitingDto(wno,wPhone,wCount);
                list.add(waitingDto);
            }
        }catch (Exception e){System.out.println(e);}//catch end
        return list;
    }//func end

    //수정
    public boolean WaitingEdit(WaitingDto waitingDto){
        try {
            String sql = "update waiting set wCount=? where wno=?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,waitingDto.getwCount());
            ps.setInt(2,waitingDto.getWno());
            int count= ps.executeUpdate();
            if(count==1)return true;
            return false;
        } catch (Exception e) {System.out.println(e);}//catch end
        return false;
    }//func end

    //삭제
    public boolean WaitingDelete(int wno){
        try{
            String sql= "delete from waiting where wno=?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,wno);
            int count=ps.executeUpdate();
            if(count==1) return true;
            return false;
        } catch (Exception e) {System.out.println(e);}//catch end
        return false;
    }//func end

}//class end

