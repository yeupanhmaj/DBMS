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



}
