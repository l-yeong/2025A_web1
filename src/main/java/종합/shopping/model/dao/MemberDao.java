package 종합.shopping.model.dao;


import org.springframework.stereotype.Repository;
import 종합.shopping.model.dto.MemberDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Repository
public class MemberDao extends Dao {
    //등록
    public boolean MemberWrite(MemberDto memberDto) {
        try {
            String sql = "insert into MEMBER_TBL_02 (custname,phone,address,grade,city) values (?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,memberDto.getCustname());
            ps.setString(2,memberDto.getPhone());
            ps.setString(3,memberDto.getAddress());
            ps.setString(4,memberDto.getGrade());
            ps.setString(5,memberDto.getCity());
            int count = ps.executeUpdate();
            if(count==1)return true;
        } catch(Exception e){System.out.println(e);}//catch end
        return false;
    }//func end

    //조회
    public ArrayList<MemberDto>MemberPrint(){
        ArrayList<MemberDto>list= new ArrayList<>();
        try{
            String sql="SELECT *FROM MEMBER_TBL_02;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int custno = rs.getInt("custno");
                String custname= rs.getString("custname");
                String phone= rs.getString("phone");
                String address= rs.getString("address");
                String joindate= rs.getString("joindate");
                String grade= rs.getString("grade");
                String city= rs.getString("city");
                MemberDto memberDto = new MemberDto(custno,custname,phone,address,joindate,grade,city);
                list.add(memberDto);
            }//while end
        } catch (Exception e) {System.out.println(e);}//catch end
        return list;
    }//func end

    //수정
    public boolean MemberUpdate(MemberDto memberDto){
        try{
            String sql= "update MEMBER_TBL_02 set custname=?, phone=?, address=?, grade=?, city=? where custno=?;";
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setString(1, memberDto.getCustname());
            ps.setString(2, memberDto.getPhone());
            ps.setString(3, memberDto.getAddress());
            ps.setString(4, memberDto.getGrade());
            ps.setString(5, memberDto.getCity());
            ps.setInt(6,memberDto.getCustno());
            int count = ps.executeUpdate();
            if(count==1)return true;
        } catch (Exception e) {System.out.println(e);}//catch end
        return false;
    }//func end
}//class end
