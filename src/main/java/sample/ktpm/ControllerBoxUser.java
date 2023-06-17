package sample.ktpm;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;


public class ControllerBoxUser  {
    @FXML
    TextField txtHoVaTen, txtNamsinh, txtGioiTinh, txtDiaChi, txtThoiGianTest, txtThoiGianCachLy, txtNoiCachLy, txtNoiTest;
    @FXML
    CheckBox boxHo, boxSot, boxKhotho, boxKhong;
    @FXML //Tiep xuc nguoi benh
    RadioButton radioCoTX, radioKhongTX;
    @FXML //Muc do
    RadioButton radioF0, radioF1, radioF2, radioKhongMD;
    @FXML //Hinh thuc test
    RadioButton radioPCR, radioTestNhanh, radioKhongHT;
    @FXML //Test covid
    RadioButton radioDaTest, radioChuaTest;
    @FXML //Tinh trang
    RadioButton radioAmTinh, radioDuongTinh, radioKhongTT;
    @FXML //Cach ly
    RadioButton radioCoCL, radioKhongCL;

    public void Add(ActionEvent event){
        String HVT, NS, GT, DC, TGT, NCL, NT, TGCL;
        String BH = " ", TX = " ", MD = " ", HT = " ", TC = " ", TT = " ", CL = " ";
        ObservableList<String> bieuHienList = FXCollections.observableArrayList();

        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection conn = databaseConnection.getConnection();
        HVT = txtHoVaTen.getText();
        NS = txtNamsinh.getText();
        GT = txtGioiTinh.getText();
        DC = txtDiaChi.getText();
        TGT = txtThoiGianTest.getText();
        NT = txtNoiTest.getText();
        TGCL = txtThoiGianCachLy.getText();
        NCL = txtNoiCachLy.getText();
        //bieu hien
        if(boxHo.isSelected()){
            bieuHienList.add(boxHo.getText());
        }
        if(boxSot.isSelected()){
            bieuHienList.add(boxSot.getText());
        }
        if(boxKhotho.isSelected()){
            bieuHienList.add(boxKhotho.getText());
        }
        if(boxKhong.isSelected()){
            bieuHienList.add(boxKhong.getText());
        }

        //Tiep xuc
        if(radioCoTX.isSelected()){
            TX += radioCoTX.getText() + " ";

        }

        if(radioKhongTX.isSelected()){
            TX += radioKhongTX.getText() + " ";
        }

        //Muc do
        if(radioF0.isSelected()){
            MD += radioF0.getText() + " ";
        }
        if(radioF1.isSelected()){
            MD += radioF1.getText() + " ";
        }if(radioF2.isSelected()){
            MD += radioF2.getText() + " ";
        }
        if(radioKhongMD.isSelected()){
            MD += radioKhongMD.getText() + " ";
        }
        //Hinh thuc
        if(radioPCR.isSelected()){
            HT += radioPCR.getText() + " ";
        }
        if(radioTestNhanh.isSelected()){
            HT += radioTestNhanh.getText() + " ";
        }
        if(radioKhongHT.isSelected()){
            HT += radioKhongHT.getText() + " ";
        }
        //Test covid
        if(radioDaTest.isSelected()){
            TC += radioDaTest.getText() + " ";
        }
        if(radioChuaTest.isSelected()){
            TC += radioChuaTest.getText() + " ";
        }
        //Tinh trang
        if(radioAmTinh.isSelected()){
            TT += radioAmTinh.getText() + " ";
        }
        if(radioDuongTinh.isSelected()){
            TT += radioDuongTinh.getText() + " ";
        }
        if(radioKhongTT.isSelected()){
            TT += radioKhongTT.getText() + " ";
        }
        //Cach ly
        if(radioCoCL.isSelected()){
            CL += radioCoCL.getText() +" ";
        }
        if(radioKhongCL.isSelected()){
            CL += radioKhongCL.getText() +" ";
        }



        try{
            String sql = "insert into  user(name, yearOfBirth, address,gender, bieuHien, tiepXuc, mucDo, testCovid, hinhThucTest, tinhTrang, thoiGianTest, noiTest, cachLy, thoiGianCachLy, noiCachLy) " +
                    "VALUES('"+HVT+"', '"+NS+"', '"+DC+"', '"+GT+"', '"+bieuHienList.toString()+"', '"+TX+"', '"+MD+"', '"+TC+"', '"+HT+"', '"+TT+"', '"+TGT+"', '"+NT+"', '"+CL+"', '"+TGCL+"', '"+NCL+"')";
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thành công");
            alert.setContentText("Thêm thành công");
            alert.show();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void Reset(){
        txtHoVaTen.setText("");
        txtGioiTinh.setText("");
        txtDiaChi.setText("");
        txtNamsinh.setText("");
        txtNoiCachLy.setText("");
        txtNoiTest.setText("");
        txtThoiGianCachLy.setText("");
        txtThoiGianTest.setText("");
        if(boxHo.isSelected()){
            boxHo.setSelected(false);
        }
        if(boxSot.isSelected()){
            boxSot.setSelected(false);
        }
        if(boxKhotho.isSelected()){
            boxKhotho.setSelected(false);
        }
        if(boxKhong.isSelected()){
            boxKhong.setSelected(false);
        }
        //Tiep xuc
        if(radioCoTX.isSelected()){
            radioCoTX.setSelected(false);

        }

        else if(radioKhongTX.isSelected()){
            radioKhongTX.setSelected(false);
        }

        //Muc do
        if(radioF0.isSelected()){
            radioF0.setSelected(false);
        }
        else if(radioF1.isSelected()){
            radioF1.setSelected(false);
        }else if(radioF2.isSelected()){
            radioF2.setSelected(false);
        }
        else if(radioKhongMD.isSelected()){
            radioKhongMD.setSelected(false);
        }
        //Hinh thuc
        if(radioPCR.isSelected()){
            radioPCR.setSelected(false);
        }
        else if(radioTestNhanh.isSelected()){
            radioTestNhanh.setSelected(false);
        }
        else if(radioKhongHT.isSelected()){
            radioKhongHT.setSelected(false);
        }
        //Test covid
        if(radioDaTest.isSelected()){
            radioDaTest.setSelected(false);
        }
        else if(radioChuaTest.isSelected()){
            radioChuaTest.setSelected(false);
        }
        //Tinh trang
        if(radioAmTinh.isSelected()){
            radioAmTinh.setSelected(false);
        }
        else if(radioDuongTinh.isSelected()){
            radioDuongTinh.setSelected(false);
        }
        else if(radioKhongTT.isSelected()){
            radioKhongTT.setSelected(false);
        }
        //Cach ly
        if(radioCoCL.isSelected()){
            radioCoCL.setSelected(false);
        }
        else if(radioKhongCL.isSelected()){
            radioKhongCL.setSelected(false);
        }
    }
    public void BackToTable(ActionEvent event) throws  Exception{
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sampleInfoMain.fxml"));
        Parent tableView = loader.load();
        Scene scene = new Scene(tableView);
        stage.setScene(scene);
        stage.show();
    }



  //  @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        String BH = " ", TX = " ", MD = " ", HT = " ", TC = " ", TT = " ", CL = " ";
//        DatabaseConnection databaseConnection = new DatabaseConnection();
//        Connection conn = databaseConnection.getConnection();
//        try{
//            String sql = "select * from user";
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while (rs.next()){
//                txtHoVaTen.setText(rs.getString("name"));
//                txtNamsinh.setText(rs.getString("yearOfBirth"));
//                txtGioiTinh.setText(rs.getString("gender"));
//                txtDiaChi.setText(rs.getString("address"));
//                txtThoiGianTest.setText(rs.getString("thoiGianTest"));
//                txtThoiGianCachLy.setText(rs.getString("thoiGianCachLy"));
//                txtNoiCachLy.setText(rs.getString("noiCachLy"));
//                txtNoiTest.setText(rs.getString("noiTest"));
//                //Bieu hien
//
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//    }

}
