package Test_Koneksi;

import com.mysql.jdbc.Driver;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Latihan2 {
    static final String DBUrl = "jdbc:mysql://localhost:3306/db_unidha";
    
    private static Connection TestKonek;
    public static Connection DBKonek () throws SQLException, ClassNotFoundException{
        try{
            Driver myDriver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(myDriver);
            System.out.println("Proses Deteksi Driver Berhasil");
            
            TestKonek = DriverManager.getConnection(DBUrl, "root", "");
            System.out.println("Koneksi Database Berhasil");
        }
        
        catch(final SQLException ex){
            System.out.println("Koneksi Database Gagal : " + ex);
        } return TestKonek;
    }
    
    public static void main(String args[]){
        try {
            Connection conn = DBKonek();
            if (conn != null){
                System.out.println("Koneksi berhasil dipakai");
            } else {
                System.out.println("Koneksi gagal digunakan");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
