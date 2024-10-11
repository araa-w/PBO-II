package AppDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
                Mahasiswa Mhs = new Mahasiswa();
                Mhs.setNoBp(resultSet.getString("NoBP"));
                Mhs.setNama(resultSet.getString("Nama"));
                Mhs.setTmpLahir(resultSet.getString("TempatLahir"));
                Mhs.setTglLahir(resultSet.getString("TanggalLahir"));
                Mhs.setAlamat(resultSet.getString("Alamat"));
                Mhs.setPhone(resultSet.getString("NoTelp"));
                Mhs.setAsalSekolah(resultSet.getString("AsalSekolah"));
                Mahasiswa.add(Mhs);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return mahasiswa;
    }

    public int Insert(Mahasiswa Mhs){
        int result = 0;
        try {
            result = statm.executeUpdate("insert into tabelmahasiswa value ('" + Mhs.getNoBp() +
                    "', '" + Mhs.getNama() + "', '" + Mhs.getTmpLahir() + "', '" + Mhs.getTglLahir() +
                    "', '" + Mhs.getAlamat() + "', '" + Mhs.getPhone() + "', '" + Mhs.getAsalSekolah() + "')")
        } catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
