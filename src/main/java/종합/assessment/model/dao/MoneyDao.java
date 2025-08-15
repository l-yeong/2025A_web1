package 종합.assessment.model.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MoneyDao extends Dao{
    //public ArrayList<Map<String, Object>> memberSales(){
    //    ArrayList<Map<String, Object>> list = new ArrayList<>();
    //    try{
    //        String sql ="select mem.custno,mem.custname,mem.grade,sum(mon.price)매출 " +
    //                "from member_tbl_02 mem inner join  money_tbl_02 mon on mem.custno = mon.custno " +
    //                "group by mem.custno,mem.custname,mem.grade order by 매출 desc;";
    //        PreparedStatement ps = conn.prepareStatement(sql);
    //        ResultSet rs= ps.executeQuery();
    //        while(rs.next()){
    //            Map<String,Object> map = new HashMap<>();
    //            map.put("번호",rs.getInt("custno"));
    //            map.put("이름",rs.getString("custname"));
    //            map.put("등급",rs.getString("grade"));
    //            map.put("가격",rs.getInt("price"));
    //        }
    //    } catch (Exception e) {System.out.println(e);}//catch end
    //
    //}//func end
}//func end
