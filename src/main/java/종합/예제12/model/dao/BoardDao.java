package 종합.예제12.model.dao;

import org.springframework.stereotype.Repository;
import 종합.예제12.model.dto.BoardDto;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardDao extends Dao{

    //등록
    public boolean boardWrite(BoardDto boardDto){
        try {
            String sql = "INSERT INTO board (bcontent, bwriter) VALUES (?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, boardDto.getBcontent());
            ps.setString(2, boardDto.getBwriter());

            int count = ps.executeUpdate();
            if(count==1)return true;
        }catch(Exception e){System.out.println(e);}//catch end
        return false;
    }//func end

    //조회
    public ArrayList<BoardDto> boardPrint(){
        ArrayList<BoardDto> list = new ArrayList<>();
        try{
            String sql = "SELECT *FROM board;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int bno = rs.getInt("bno");
                String bcontent = rs.getString("bcontent");
                String bwriter = rs.getString("bwriter");
                BoardDto boardDto = new BoardDto(bno,bcontent,bwriter);
                list.add(boardDto);
            }//while end
        } catch (Exception e) {System.out.println(e);}//catch end
        return list;
    }//func end

    //개별조회
    public BoardDto boardFind(int bno){
        try {
            String sql="SELECT *FROM board WHERE bno=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,bno);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                BoardDto boardDto = new BoardDto();
                boardDto.setBno(rs.getInt(1));
                boardDto.setBcontent(rs.getString(2));
                boardDto.setBwriter(rs.getString(3));
                return boardDto;
            }
        }catch(Exception e){System.out.println(e);}
        return null;
    }

    //수정
    public boolean boardEdit(BoardDto boardDto){
        try{
            String sql= "update board set bcontent=? where bno = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, boardDto.getBcontent());
            ps.setInt(2,boardDto.getBno());
            int count = ps.executeUpdate();
            if(count==1) return true;
        } catch (Exception e) {System.out.println(e);}//catch end
        return false;
    }//func end

    //삭제
    public boolean boardDelete(int bno){
        try{
            String sql = "delete from board where bno=?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,bno);

            int count =ps.executeUpdate();
            if(count==1)return true;
        } catch (Exception e) {System.out.println(e);}//catch end
        return false;
    }//func end
}//class end
