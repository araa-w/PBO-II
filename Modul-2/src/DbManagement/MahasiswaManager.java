/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DbManagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author vvhal
 */
public class MahasiswaManager {
    Connection conn = null;
    Statement statm = null;

    String driver = "com.mysql.jdbc.Driver";
    String url =  "dbc:mysql://localhost:3306/dbsi_23131010";

    public MahasiswaManager(){
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, "root","");
            statm = conn.createStatement();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List getMahasiswa(){
        ResultSet resultSet = null;
        List mahasiswa = new ArrayList<>();

        try {
            resultSet = statm.executeQuery("select * from tabelmahasiswa");
            while (resultSet.next()) {
                MahasiswaInput Mhs = new MahasiswaInput();
                Mhs.setNoBp(resultSet.getString("NoBP"));
                Mhs.setNama(resultSet.getString("Nama"));
                Mhs.setTmpLahir(resultSet.getString("TempatLahir"));
                Mhs.setTglLahir(resultSet.getString("TanggalLahir"));
                Mhs.setAlamat(resultSet.getString("Alamat"));
                Mhs.setPhone(resultSet.getString("NoTelp"));
                Mhs.setAsalSekolah(resultSet.getString("AsalSekolah"));
                MahasiswaInput.add(Mhs);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return mahasiswa;
    }

    public int Insert(MahasiswaInput Mhs){
        int result = 0;
        try {
            result = statm.executeUpdate("insert into tabelmahasiswa values ('" + Mhs.getNoBp() +
                    "', '" + Mhs.getNama() + "', '" + Mhs.getTmpLahir() + "', '" + Mhs.getTglLahir() +
                    "', '" + Mhs.getAlamat() + "', '" + Mhs.getPhone() + "', '" + Mhs.getAsalSekolah() + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    public int Delete(MahasiswaInput Mhs){
        int result = 0;
        try{
            result = statm.executeUpdate("delete from tabelmahasiswa where NoBP = '" + Mhs.getNoBp()+"'");
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public int Update(MahasiswaInput Mhs){
        int result = 0;
        try{
            result = statm.executeUpdate("update tabelmahasiswa set NoBp ="+ Mhs.getNoBp() +
                    "', Nama ='" + Mhs.getNama() + "', TempatLahir = '" + Mhs.getTmpLahir() + "', Tanggalahir ='" + Mhs.getTglLahir() +
                    "', Alamat = '" + Mhs.getAlamat() + "', NoTelp = '" + Mhs.getPhone() + "', AsalSekolah = '" + Mhs.getAsalSekolah() + "')");
        } catch (Exception e){
            e.printStackTrace();
        } return result;
    }

    public void closeConnection(){
        try{
            conn.close();
            statm.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
