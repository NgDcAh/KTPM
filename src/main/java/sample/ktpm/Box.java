package sample.ktpm;

public class Box {
    private String bieuhien;
    private String mucdo;

    public Box(String bieuhien, String mucdo) {
        this.bieuhien = bieuhien;
        this.mucdo = mucdo;
    }
    public Box(){

    }

    public String getBieuhien() {
        return bieuhien;
    }

    public void setBieuhien(String bieuhien) {
        this.bieuhien = bieuhien;
    }

    public String getMucdo() {
        return mucdo;
    }

    public void setMucdo(String mucdo) {
        this.mucdo = mucdo;
    }
}
