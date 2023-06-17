package sample.ktpm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;


public class ControllerLogin {
    @FXML
    TextField txtUserName;
    @FXML
    PasswordField txtPassword;
    public  static String userName, passWord;
    public void SingIn(ActionEvent event)  {

        String UN, PW;
        UN = txtUserName.getText();
        PW = txtPassword.getText();
        StringBuilder sb = new StringBuilder();
        if(UN.equals("")){
            Alert.AlertType alertAlertType;
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Username is empty");
            alert.show();
        }
        if(PW.equals("")){
            Alert.AlertType alertAlertType;
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Password is empty");
            alert.show();
        }
        if(UN.equals("") && PW.equals("")){
            Alert.AlertType alertAlertType;
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Invalidation");
            alert.show();
        }
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection conn = databaseConnection.getConnection();
        try {
            String sql = "select tenDN,matKhau from dangnhap where tenDN = '"+UN+"' and matKhau ='"+PW+"' ";
            Statement st = (Statement) conn.createStatement();
            ResultSet rs =   st.executeQuery(sql);
            if (rs.next()) {
                userName = rs.getString("tenDN");
                passWord = rs.getString("matKhau");
                if(userName.equals(rs.getString("tenDN")) && passWord.equals(rs.getString("matKhau")) ) {
                    try {
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("sampleDanhMuc.fxml"));
                        Parent root1 = loader.load();
                        Scene scene = new Scene(root1);
                        stage.setTitle("Danh mục quản lí");
                        stage.setScene(scene);
                        stage.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }

            }
            else {
                Alert.AlertType alertAlertType;
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("Username or password is not correct");
                alert.show();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }



    }
    public void QuayLai(ActionEvent event) throws  Exception{
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sampleBatDau.fxml"));
        Parent root1 = loader.load();
        Scene scene = new Scene(root1);
        stage.setTitle("Danh mục quản lí");
        stage.setScene(scene);
        stage.show();
    }
    public void Reset(){
        txtUserName.setText("");
        txtPassword.setText("");
    }

}
