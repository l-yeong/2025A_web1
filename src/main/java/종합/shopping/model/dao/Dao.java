package 종합.shopping.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {
    private String db_url="jdbc:mysql://localhost:3306/assessment";
    private String db_id="root";
    private String db_pwd="1234";
    public Connection conn;
    public Dao(){open();}
    private void open(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(db_url,db_id,db_pwd);
            System.out.println("Dao.open");
        }catch(Exception e){System.out.println(e);}
    }//func end
}//class end
