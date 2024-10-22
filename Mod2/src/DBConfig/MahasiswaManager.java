package DBConfig;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MahasiswaManager {
    private static Connection Conn;
    
    public static Connection getConnection() {
        if ( Conn == null ){
            try{
                String url = "jdbc:mysql://localhost:3306/dbsi_23131010";
                String user = "root";
                String pass = "";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                Conn = DriverManager.getConnection(url, user,pass);
            } catch (Exception e){
                Logger.getLogger(MahasiswaManager.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return Conn;
    }

    public static void closeConnection (){
        if ( Conn != null ){
            try {
                Conn.close();
            } catch (Exception e){
                Logger.getLogger(MahasiswaManager.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
