package 종합.assessment.model.dao;

import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MoneyDao extends Dao{
    //매출조회
    public List<Map<String, Object>> MemberSales(){
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            String sql = "select mem.custno,mem.custname,mem.grade,sum(mon.price)sales from member_tbl_02 mem inner join  " +
                    "money_tbl_02 mon on mem.custno = mon.custno group by mem.custno,mem.custname,mem.grade order by sales desc;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("custno",rs.getInt("custno"));
                map.put("custname",rs.getString("custname"));
                map.put("grade",rs.getString("grade"));
                map.put("sales",rs.getInt("sales"));
                list.add(map);
            }//while end
            ps.close();
            rs.close();
        } catch (Exception e) {System.out.println(e);}//catch end
        return list;
    }//func end
}//func end
