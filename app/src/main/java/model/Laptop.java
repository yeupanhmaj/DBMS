package model;

import com.example.wallk.dbms.ConectionClass;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Laptop implements Serializable {
    private String MaSP;
    private String MaLoaiSP;
    private String TenSP;
    private String Hang;
    private String CauHinh;
    private String Hinh;
    private Connection connect;
    private String ConnectionResult;
    private boolean isSuccess;

    public Laptop(String maSP, String maLoaiSP, String tenSP, String hang, String cauHinh, String hinh) {
        MaSP = maSP;
        MaLoaiSP = maLoaiSP;
        TenSP = tenSP;
        Hang = hang;
        CauHinh = cauHinh;
        Hinh = hinh;
    }

    public Laptop() {
    }
    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String hinh) {
        Hinh = hinh;
    }




    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String maSP) {
        MaSP = maSP;
    }

    public String getMaLoaiSP() {
        return MaLoaiSP;
    }

    public void setMaLoaiSP(String maLoaiSP) {
        MaLoaiSP = maLoaiSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public String getHang() {
        return Hang;
    }

    public void setHang(String hang) {
        Hang = hang;
    }

    public String getCauHinh() {
        return CauHinh;
    }

    public void setCauHinh(String cauHinh) {
        CauHinh = cauHinh;
    }

    @Override
    public String toString() {
        return getHang()+" "+getTenSP();
    }

    public List<Laptop> doInBackground(String ip, String User, String Pass) {

        List<Laptop> data = null;
        data = new ArrayList<>();
        try {
            ConectionClass conStr = new ConectionClass();
            connect = conStr.CONN(ip,User,Pass);        // Connect to database
            if (connect == null) {
                ConnectionResult = "Check Your Internet Access!";
            } else {
                // Change below query according to your own database.
                String query = "";
                Statement stmt = connect.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Laptop temp = new Laptop();
                    temp.setMaSP(rs.getString("MaSP"));
                    temp.setMaLoaiSP(rs.getString("MaLoaiSP"));
                    temp.setTenSP(rs.getString("TenSP"));
                    temp.setHang(rs.getString("Hang"));
                    temp.setCauHinh(rs.getString("CauHinh"));
                    temp.setHinh(rs.getString("Hinh"));
                    data.add(temp);
                }
                ConnectionResult = " successful";
                isSuccess = true;
                connect.close();
            }
        } catch (Exception ex) {
            isSuccess = false;
            ConnectionResult = ex.getMessage();
        }
        return data;
    }

}
