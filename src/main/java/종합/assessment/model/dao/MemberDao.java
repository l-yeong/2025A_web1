package 종합.assessment.model.dao;


import org.springframework.stereotype.Repository;
import 종합.assessment.model.dto.MemberDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            ps.close();
        } catch(Exception e){System.out.println(e);}//catch end
        return false;
    }//func end

    //회원번호,가입일(자동발생)
    public MemberDto auto(MemberDto memberDto){
        try{
            String sql = "select custno, joindate from member_tbl_02 order by custno desc limit 1;";
            PreparedStatement ps= conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                memberDto.setCustno(rs.getInt("custno"));
                memberDto.setJoindate(rs.getString("joindate"));
                return memberDto;
            }
            ps.close();
            rs.close();
        } catch (Exception e) {System.out.println(e);}//catch end
        return null;
    }

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
            ps.close();
            rs.close();
        } catch (Exception e) {System.out.println(e);}//catch end
        return list;
    }//func end

    //개별 조회
    public MemberDto MemberFind(int custno){
        try{
            String sql = "select *from MEMBER_TBL_02 where custno=?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,custno);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                MemberDto memberDto = new MemberDto();
                memberDto.setCustno(rs.getInt(1));
                memberDto.setCustname(rs.getString(2));
                memberDto.setPhone(rs.getString(3));
                memberDto.setAddress(rs.getString(4));
                memberDto.setJoindate(rs.getString(5));
                memberDto.setGrade(rs.getString(6));
                memberDto.setCity(rs.getString(7));
                return memberDto;
            }
            ps.close();
            rs.close();
        } catch (Exception e) {System.out.println(e);}//catch end
        return null;
    }// func end

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
            ps.close();
        } catch (Exception e) {System.out.println(e);}//catch end
        return false;
    }//func end
}//class end
