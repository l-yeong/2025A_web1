package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.ProductDao;
import web.model.dto.ProductDto;

import java.util.List;

@Service
public class ProductService {
    @Autowired ProductDao productDao;

    //등록
    public int createProduct(ProductDto productDto){
        int result = productDao.createProduct(productDto);
        return result;
    }//func end

    public boolean createProductImage(String fileName,int pno){
        boolean reuslt = productDao.createProductImage(fileName, pno);
        return reuslt;
    }//func end


    //[2] 전체 제품 정보+이미지포함 조회
    public List<ProductDto> getAllProduct(){
        System.out.println("ProductService.getAllProduct");
        List<ProductDto> productList = productDao.getAllProduct();
        for(ProductDto productDto : productList){
            List<String> images =
                productDao.getProductImages(productDto.getPno()); //특정한 제품의 pno 를 이용하여 모든 제품이미지명 조회
            productDto.setImages(images); // 조회한 모든 이미지명을 특정한 제품의 dto 포함
        }
        return productList;
    }//fucn end

    //[3] 개별 제품 정보+이미지포함 조회
    public ProductDto getProduct (int pno){
        //1. 특정한 제품 조회
        ProductDto productDto = productDao.getProduct(pno);
        //2. 만약에 조회했으면 제품의 이미지명 조회
        if(productDto != null){
            List<String> images =
                    productDao.getProductImages(productDto.getPno()); //[2-2]메소드 호출
            productDto.setImages(images);
        }//if end
       return productDto;
    }//func end
}//class end
