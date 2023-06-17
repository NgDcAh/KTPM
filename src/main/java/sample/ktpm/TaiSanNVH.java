package sample.ktpm;

public class TaiSanNVH {
    private Integer id;
    private String ten, soLuong, tang, tinhTrang, ngay;

    public TaiSanNVH(Integer id, String ten, String soLuong, String tang, String tinhTrang, String ngay) {
        this.id = id;
        this.ten = ten;
        this.soLuong = soLuong;
        this.tang = tang;
        this.tinhTrang = tinhTrang;
        this.ngay = ngay;
    }
    public TaiSanNVH(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getTang() {
        return tang;
    }

    public void setTang(String tang) {
        this.tang = tang;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }
}
