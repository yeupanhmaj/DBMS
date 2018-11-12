package model;

import java.util.Date;

public class NhanVien {
    private String MaNV;
    private String TenNV;
    private Date NgaySinh;
    private String Email;
    private int SDT;
    private float Luong;

    public NhanVien() {
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String maNV) {
        MaNV = maNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String tenNV) {
        TenNV = tenNV;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

    public float getLuong() {
        return Luong;
    }

    public void setLuong(float luong) {
        Luong = luong;
    }

}
