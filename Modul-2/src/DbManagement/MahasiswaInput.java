/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DbManagement;

/**
 *
 * @author vvhal
 */
public class MahasiswaInput {
    private String NoBp;
    private String Nama;
    private String TmpLahir;
    private String TglLahir;
    private String Alamat;
    private String Phone;
    private String AsalSklh;
    
    public MahasiswaInput(){
    
    }

    public static void add(MahasiswaInput Mhs) {
    }

    public String getAsalSekolah(){
        return AsalSklh;
    }
    public void setAsalSekolah(String asalsekolah) { this.AsalSklh = asalsekolah; }

    public String getPhone() { return Phone; }
    public void setPhone(String phone) { this.Phone = phone;}

    public String getAlamat (){ return Alamat; }
    public void setAlamat(String alamat) { this.Alamat = alamat;}

    public String getTglLahir() {return TglLahir;}
    public void setTglLahir(String tanggaLahir) { this.TglLahir = tanggaLahir;}

    public String getTmpLahir() {return TmpLahir;}
    public void setTmpLahir(String tempatLahir) { this.TmpLahir = tempatLahir;}

    public String getNama() {return Nama;}
    public void setNama(String nama) { this.Nama = nama;}

    public String getNoBp() {return NoBp;}
    public void setNoBp(String noBp) { this.NoBp = noBp;}
}
