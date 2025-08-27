package web.model.dao;

import org.springframework.stereotype.Repository;
import web.model.dto.PageDto;
import web.model.dto.PostDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostDao extends Dao {

    //게시물 등록
    public int writePost(PostDto postDto) {
        try {
            String sql = "insert into post (ptitle, pcontent, cno, mno) values (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // RETURN_GENERATED_KEYS : SQL 실행시 자동 생성된 PK 반환 설정
            ps.setString(1,postDto.getPtitle());
            ps.setString(2,postDto.getPcontent());
            ps.setInt(3,postDto.getCno());
            ps.setInt(4,postDto.getMno());
            int count = ps.executeUpdate();
            if(count==1) {
                ResultSet rs = ps.getGeneratedKeys(); //SQL 실행 후 자동 생성된 **PK반환**
                if(rs.next()) {
                    return rs.getInt(1); // 첫번째 PK속성 값 반환
                }
            };
        }catch (Exception e){
            System.out.println(e);}//catch end
        return 0;
    }//func end


    //[2-1] 카테고리별 게시물 수
    public int getTotalCount(int cno){
        try{
            String sql = "select count(*) from post where cno=?"; //count(*) : 레코드 전체수 SQL함수
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,cno);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1); //첫번째 레코드의 속성값 1개 반환
            }
        } catch (Exception e) {System.out.println(e);}//catch end
        return 0;
    }//func end

    //[2-2] 카테고리별 전체 게시물 정보 조회
    public List<PostDto> findAll(int cno, int startRow, int count){
        List<PostDto> list = new ArrayList<>();
        try {
            String sql = "SELECT *FROM post p INNER JOIN member m  on  p.mno=m.mno where p.cno=? order by cno desc limit ?,?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,cno);
            ps.setInt(2,startRow);
            ps.setInt(3,count);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PostDto postDto = new PostDto();
                postDto.setMno(rs.getInt("mno"));
                postDto.setCno(rs.getInt("cno"));
                postDto.setPcontent(rs.getString("pcontent"));
                postDto.setPdate(rs.getString("pdate"));
                postDto.setPview(rs.getInt("pview"));
                postDto.setPno(rs.getInt("pno"));
                postDto.setPtitle(rs.getString("ptitle"));
                postDto.setMid(rs.getString("mid"));
                list.add(postDto);
            }//while end
        } catch (Exception e) {System.out.println(e);}//catch end
        return list;
    }// func end

    //[2-3] 카테고리별 *검색* 게시물수
    public int getTotalCountSearch(int cno,String key,String keyword){
        try{
            String sql = " select count(*) from post where cno=? ";
            //key(속성명)에 따른 sql 추가
            if(key.equals("ptitle")){sql+=" and ptitle like ? ";}
            else if(key.equals("pcontent")){sql+=" and pcontent like ? ";}
            //그외 검색속성이 존재 하면 추가 한다.
            System.out.println("[확인] 동적 SQL: "+sql);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,cno);
            ps.setString(2,"%"+keyword+"%"); // SQL 에서 포함된 비교는 LIKE %키워드% 사용된다.
            ResultSet  rs = ps.executeQuery();
            if(rs.next()){ return rs.getInt(1);}
        }catch(Exception e){System.out.println(e);}//catch end
        return 0;
    }//func end

    //[2-4] 카테고리별 *검색* 전체 게시물 정보 조회
    public List<PostDto> findAllSearch(int cno, int startRow, int count, String key, String keyword){
        List<PostDto> list = new ArrayList<>();
        try{
            String sql = " select *from post p inner join member m on m.mno = p.mno where cno = ? ";
            if(key.equals("ptitle")){sql+=" and ptitle like ? ";}
            else if(key.equals("pcontent")){sql+= " and pcontent like ? ";}
            //그외(정렬/페이징)
            sql += " order by pno desc limit ? , ? ";
            System.out.println("[확인] 동적 SQL: "+sql);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,cno);
            ps.setString(2,"%"+keyword+"%");
            ps.setInt(3,startRow);
            ps.setInt(4,count);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PostDto postDto = new PostDto();
                postDto.setMno(rs.getInt("mno"));
                postDto.setCno(rs.getInt("cno"));
                postDto.setPcontent(rs.getString("pcontent"));
                postDto.setPdate(rs.getString("pdate"));
                postDto.setPview(rs.getInt("pview"));
                postDto.setPno(rs.getInt("pno"));
                postDto.setPtitle(rs.getString("ptitle"));
                postDto.setMid(rs.getString("mid"));
                list.add(postDto);
            }//while end
        } catch (Exception e) {System.out.println(e);}//catch end
        return list;
    }//func end

}//class end
