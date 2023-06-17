package sample.ktpm;

public class User {
    private Integer id;
    private String name;
    private String yearOfBirth;
    private String gender;
    private String address;
    private String bieuHien;
    private String tiepXuc;
    private String mucDo;
    private String testCovid;
    private String tinhTrang;
    private String hinhThucTest;
    private String thoiGianTest;
    private String noiTest;
    private String cachLy;
    private String thoiGianCachLy;
    private String noiCachLy;

    public User(Integer id,String name, String yearOfBirth, String gender, String address,String thoiGianTest) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.address = address;
        this.thoiGianTest = thoiGianTest;
    }

    public User(Integer id, String name, String yearOfBirth, String gender, String address, String bieuHien, String tiepXuc, String mucDo, String testCovid, String tinhTrang, String hinhThucTest, String thoiGianTest, String noiTest, String cachLy, String thoiGianCachLy, String noiCachLy) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.address = address;
        this.bieuHien = bieuHien;
        this.tiepXuc = tiepXuc;
        this.mucDo = mucDo;
        this.testCovid = testCovid;
        this.tinhTrang = tinhTrang;
        this.hinhThucTest = hinhThucTest;
        this.thoiGianTest = thoiGianTest;
        this.noiTest = noiTest;
        this.cachLy = cachLy;
        this.thoiGianCachLy = thoiGianCachLy;
        this.noiCachLy = noiCachLy;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBieuHien() {
        return bieuHien;
    }

    public void setBieuHien(String bieuHien) {
        this.bieuHien = bieuHien;
    }

    public String getTiepXuc() {
        return tiepXuc;
    }

    public void setTiepXuc(String tiepXuc) {
        this.tiepXuc = tiepXuc;
    }

    public String getMucDo() {
        return mucDo;
    }

    public void setMucDo(String mucDo) {
        this.mucDo = mucDo;
    }

    public String getTestCovid() {
        return testCovid;
    }

    public void setTestCovid(String testCovid) {
        this.testCovid = testCovid;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getHinhThucTest() {
        return hinhThucTest;
    }

    public void setHinhThucTest(String hinhThucTest) {
        this.hinhThucTest = hinhThucTest;
    }

    public String getThoiGianTest() {
        return thoiGianTest;
    }

    public void setThoiGianTest(String thoiGianTest) {
        this.thoiGianTest = thoiGianTest;
    }

    public String getNoiTest() {
        return noiTest;
    }

    public void setNoiTest(String noiTest) {
        this.noiTest = noiTest;
    }

    public String getCachLy() {
        return cachLy;
    }

    public void setCachLy(String cachLy) {
        this.cachLy = cachLy;
    }

    public String getThoiGianCachLy() {
        return thoiGianCachLy;
    }

    public void setThoiGianCachLy(String thoiGianCachLy) {
        this.thoiGianCachLy = thoiGianCachLy;
    }

    public String getNoiCachLy() {
        return noiCachLy;
    }

    public void setNoiCachLy(String noiCachLy) {
        this.noiCachLy = noiCachLy;
    }
}
