package web.model.dao;

import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import web.model.dto.ProductDto;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDao extends Dao{

    //[1] 제품 등록
    public int createProduct(ProductDto productDto){
        try {
            String sql = "INSERT INTO product (pname, pprice, pcomment, plat, plng,mno) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps= conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // (1) PK값 리턴 설정
            ps.setString(1,productDto.getPname());
            ps.setInt(2,productDto.getPprice());
            ps.setString(3, productDto.getPcomment());
            ps.setDouble(4,productDto.getPlat());
            ps.setDouble(5,productDto.getPlng());
            ps.setInt(6,productDto.getMno());
            int count = ps.executeUpdate();
            if(count ==1 ){
                ResultSet rs= ps.getGeneratedKeys();//(2) 등록된 레코드의 PK값 조회
                if(rs.next()) return rs.getInt(1);//(3) 등록된 레코드의 첫번째 PK값 반환(pno)
            }//if end
        }catch (Exception e){System.out.println(e);}//catch end
        return 0;
    }//func end
    //[1-2] 제품 이미지 등록
    public boolean createProductImage(String fileName,int pno){
        try{
            String sql = "INSERT INTO productimg(pimgname,pno)values(?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,fileName);
            ps.setInt(2,pno);
            int count = ps.executeUpdate();
            if(count==1)return true;
        } catch (Exception e) {System.out.println(e);}//catch end
        return false;
    }//func end

    //[2] 제품 전체 조회
    public List<ProductDto> getAllProduct(){
        List<ProductDto> list = new ArrayList<>();
        try {
            String sql = "select * from product";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ProductDto productDto = new ProductDto();
                productDto.setPno(rs.getInt("pno"));
                productDto.setPname(rs.getString("pname"));
                productDto.setPprice(rs.getInt("pprice"));
                productDto.setPcomment(rs.getString("pcomment"));
                productDto.setPdate(rs.getString("pdate"));
                productDto.setPlat(rs.getDouble("plat"));
                productDto.setPlng(rs.getDouble("plng"));
                productDto.setMno(rs.getInt("mno"));
                list.add(productDto);
            }//while end
        } catch (Exception e) {System.out.println(e);}//catch end
        return list;
    }//func end
    //[2-1] 특정한 제품의 제품이미지명 전체 조회
    public List<String> getProductImages(int pno){
        List<String> list = new ArrayList<>();
        try{String sql = "select * from productimg where pno=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,pno);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String pimgname =rs.getString("pimgname");
                list.add(pimgname);
            }//while end
        } catch (Exception e) {System.out.println(e);}//catch end
        return list;
    }//func end

    //[3] 제품 상세 조회
    public ProductDto getProduct (int pno){
        try {
            String sql = "select *from product where pno=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pno);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ProductDto productDto = new ProductDto();
                productDto.setPno(rs.getInt("pno"));
                productDto.setPname(rs.getString("pname"));
                productDto.setPprice(rs.getInt("pprice"));
                productDto.setPcomment(rs.getString("pcomment"));
                productDto.setPdate(rs.getString("pdate"));
                productDto.setPlat(rs.getDouble("plat"));
                productDto.setPlng(rs.getDouble("plng"));
                productDto.setMno(rs.getInt("mno"));
                return productDto;
            }//while end
        } catch (Exception e) {System.out.println(e);}//catch end
        return null;
    }//func end

}//class end
