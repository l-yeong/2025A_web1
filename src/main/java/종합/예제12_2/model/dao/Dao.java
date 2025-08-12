package 종합.예제12_2.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {
    private String db_url="jdbc:mysql://localhost:3306/exam12_2";
    private String db_id="root";
    private String db_pwd="1234";

    public Connection conn;

    public Dao(){connect();}

    private void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(db_url,db_id,db_pwd);
            System.out.println("Dao.connect");
        }catch(Exception e){System.out.println(e);}//catch end
    }//func end
}//class end
