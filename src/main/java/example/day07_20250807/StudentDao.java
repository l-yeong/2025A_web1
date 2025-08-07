package example.day07_20250807;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    //싱글톤
    @Getter //롬복: 해당하는 멤버변수에만 getter 제공 받을수 있다.
    private static final StudentDao Instance = new StudentDao();
    private StudentDao(){connection();}

    private String db_url = "jdbc:mysql://localhost:3306/spring07";
    private String db_user = "root";
    private String db_pwd = "1234";
    private Connection conn;

    private void connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(db_url,db_user,db_pwd);
        } catch (Exception e) {System.out.println(e);}//catch end
    }//func end

    //1. 등록
    public boolean save(StudentDto studentDto){
        // Controller 로부터 studentDto 를 매개변수로 받아서 처리후 boolean(true/false) 반환 메소드
        try {
            String sql = "INSERT INTO student (sname, skor, smath) VALUES (?,?,?);"; //1)SQL 작성한다
            PreparedStatement ps = conn.prepareStatement(sql);  //2) 연동된 DB에 작성한다 SQL 를 기재한다
            ps.setString(1,studentDto.getSname());  //3) 기재된 SQL에 매개변수 대입
            ps.setInt(2,studentDto.getSkor());      //1,2,3: SQL문법내 ? 순서번호
            ps.setInt(3,studentDto.getSmath());     //.set타입():
            // SQL문법내 3(세번째)?에 수학점수를 int 타입으로 대입 한다.
            int count= ps.executeUpdate(); //4) 기재된 SQL 실행 한다. INSERT/UPDATE/DELETE - excuteUpdate, select -> excuteQuery
            if(count==1) return true;   //5) 결과, 1개 저장했으면 성공
        } catch (Exception e) {
            System.out.println(e);
        }//catch end
        return false; //아니면 실패
    }//func end


    //2. 전체조회
    public List<StudentDto>find(){
        ArrayList<StudentDto> list = new ArrayList<>();
        try{
            String sql="select *from student";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            //rs.next():SQL 조회 결과 중 다음 레코드 이동함수, 주로 하나조회: if(rs.next()),  다수조회:while(rs.next())
            while(rs.next()){
                StudentDto studentDto = new StudentDto( //***********하나의 레코드를 DTO를 준비**************
                        rs.getInt(1),   // 현재 조회중인 레코드의 (1번)첫번째 필드/속성/제목/열/컬럼 =회원번호
                        rs.getString("sname"), // 현재 조회중인 레코드의 "sname" 이라는 필드/속성/제목/열/컬럼 = 회원명
                        rs.getInt("skor"),
                        rs.getInt("smath"),
                        rs.getString("sDate") //dateTime 은 String 타입으로 가져오기
                );
                list.add(studentDto);
            }//while end
        } catch (Exception e) {System.out.println(e);}//catch end
        return list;
    }//func end

}//class end
