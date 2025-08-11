package example.day08_20250811._2MVC.model.dao;


import java.sql.Connection;
import java.sql.DriverManager;

// 여러개 DAO를 연동하는 중복 코드를 관리하는 슈퍼클래스
public class Dao {
    // [DB연동 부가 정보]
    private String db_url="jdbc:mysql://localhost:3306/spring08";
    private String db_user="root";
    private String db_pwd="1234";

    // [DB 연동 멤버변수] * 하위클래스를 사용할수 있게 public 으로 사용.
    public Connection conn;

    // [DB 연동 생성자]
    public Dao() {connect();}

    // [DB 연동 메소드]
    private void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(db_url,db_user,db_pwd);
            System.out.println("Dao.connect");
        } catch (Exception e) {System.out.println(e);}//catch end
    }//func end
}//class end
