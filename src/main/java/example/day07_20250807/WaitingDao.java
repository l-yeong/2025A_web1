package example.day07_20250807;


import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class WaitingDao {
    @Getter
    private static final WaitingDao Instance = new WaitingDao();
    private WaitingDao(){open();}

    private String db_url = "jdbc:mysql://localhost:3306/waiting07";
    private String db_id="root";
    private String db_pwd="1234";
    private Connection conn;

    public void open(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(db_url,db_id,db_pwd);
        } catch (Exception e) {System.out.println(e);}//catch end
    }//func end


    //등록
    public boolean WaitingAdd(WaitingDto waitingDto){
        try {
            String sql = "insert into waiting(wPhone,wCount) values(?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,waitingDto.getWPhone());
            ps.setInt(2,waitingDto.getWCount());
            int count = ps.executeUpdate();
            if(count==1)return true;
        } catch (Exception e) {System.out.println(e);}//catch end
        return false;
    }//func end

    //조회
    public ArrayList<WaitingDto> WaitingList() {
        ArrayList<WaitingDto> list = new ArrayList<>();
        try {
            String sql = "select *from waiting;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                WaitingDto waitingDto = new WaitingDto(
                        rs.getInt(1),
                        rs.getString("wPhone"),
                        rs.getInt("wCount"),
                        rs.getString("wDate")
                );
                list.add(waitingDto);
            }//while end
        } catch (Exception e) {System.out.println(e);}//catch end
        return list;
    }//func end

}//class end
