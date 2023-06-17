package sample.ktpm;

public class NVH {
    public Integer id;
    public String hoatDong;
    public String tang;
    public String daiDienThue;
    public String ngayThue;
    public Integer chiPhi;
    public String pheDuyet;

    public NVH(Integer id, String hoatDong, String tang, String daiDienThue, String ngayThue, Integer chiPhi, String pheDuyet) {
        this.id = id;
        this.hoatDong = hoatDong;
        this.tang = tang;
        this.daiDienThue = daiDienThue;
        this.ngayThue = ngayThue;
        this.chiPhi = chiPhi;
        this.pheDuyet = pheDuyet;
    }

    public NVH() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHoatDong() {
        return hoatDong;
    }

    public void setHoatDong(String hoatDong) {
        this.hoatDong = hoatDong;
    }

    public String getTang() {
        return tang;
    }

    public void setTang(String tang) {
        this.tang = tang;
    }

    public String getDaiDienThue() {
        return daiDienThue;
    }

    public void setDaiDienThue(String daiDienThue) {
        this.daiDienThue = daiDienThue;
    }

    public String getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(String ngayThue) {
        this.ngayThue = ngayThue;
    }

    public Integer getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(Integer chiPhi) {
        this.chiPhi = chiPhi;
    }

    public String getPheDuyet() {
        return pheDuyet;
    }

    public void setPheDuyet(String pheDuyet) {
        this.pheDuyet = pheDuyet;
    }
}
