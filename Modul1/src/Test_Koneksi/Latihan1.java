package Test_Koneksi;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Zulfahmi, M.kom
 */
public class Latihan1 {
    static final String DBUrl = "jdbc:mysql://localhost:3306/db_unidha";
    
    private static Connection TestKonek;
    public static Connection DBKonek() throws SQLException, ClassNotFoundException{
        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(myDriver);
            System.out.println("Proses Deteksi Driver Berhasil");
            final java.sql.Connection tersambung =
                    DriverManager.getConnection (DBUrl, "root", " ");
            System.out.println("Koneksi Database Berhasil");
        }
        
        catch (final SQLException ex){
            System.out.println("Koneksi Database Gagal");
        }
        
        return TestKonek;
    }
    
    public static void main(String[] args) {
       
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
