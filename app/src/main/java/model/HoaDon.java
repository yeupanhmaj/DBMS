package model;

import java.io.Serializable;

public class HoaDon implements Serializable {
    private String MaHD;
    private String MaNV;
    private String MaKH;

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String maHD) {
        MaHD = maHD;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String maNV) {
        MaNV = maNV;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String maKH) {
        MaKH = maKH;
    }

    public HoaDon() {

    }
}
