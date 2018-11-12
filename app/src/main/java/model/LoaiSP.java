package model;

public class LoaiSP {
    private String MaLoaiSP;
    private String TenLoaiSP;

    public LoaiSP() {
    }

    public LoaiSP(String maLoaiSP, String tenLoaiSP) {
        MaLoaiSP = maLoaiSP;
        TenLoaiSP = tenLoaiSP;
    }

    public String getMaLoaiSP() {
        return MaLoaiSP;
    }

    public void setMaLoaiSP(String maLoaiSP) {
        MaLoaiSP = maLoaiSP;
    }

    public String getTenLoaiSP() {
        return TenLoaiSP;
    }

    public void setTenLoaiSP(String tenLoaiSP) {
        TenLoaiSP = tenLoaiSP;
    }

    @Override
    public String toString() {
        return this.MaLoaiSP+"-"+this.TenLoaiSP;
    }
}
