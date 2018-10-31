package model;

public class Laptop {
    private String MaSP;
    private String MaLoaiSP;
    private String TenSP;
    private String Hang;
    private String CauHinh;
    public Laptop(String maSP, String maLoaiSP, String tenSP, String hang, String cauHinh) {
        MaSP = maSP;
        MaLoaiSP = maLoaiSP;
        TenSP = tenSP;
        Hang = hang;
        CauHinh = cauHinh;
    }

    public Laptop() {
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
}
