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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ControllerAddLogin {
    @FXML
    TextField txtUserNameSingUp;
    @FXML
    PasswordField txtPasswordSingUp;
    @FXML
    PasswordField txtRePasswordSingUp;
    ObservableList<Login> loginList = FXCollections.observableArrayList();


    public void Register(ActionEvent event){
        String UN, PW, RPW;
        UN = txtUserNameSingUp.getText();
        PW = txtPasswordSingUp.getText();
        RPW = txtRePasswordSingUp.getText();
        if(UN.isEmpty()){
            Alert.AlertType alertAlertType;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Username is empty");
            alert.show();
        }
        if(PW.equals("") || RPW.equals("")){
            Alert.AlertType alertAlertType;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Password is empty");
            alert.show();
        }
        if(!PW.equals(RPW)){
            Alert.AlertType alertAlertType;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Password and re password not equals");
            alert.show();
        }
        if(!UN.isEmpty() && !PW.isEmpty() && !RPW.isEmpty() && PW.equals(RPW)){
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection conn = databaseConnection.getConnection();

            try{
                String sql = "insert into dangnhap(tenDN, matKhau) values ('"+UN+"' , '"+PW+"')";
                Statement st = (Statement) conn.createStatement();
                st.executeUpdate(sql);
                Alert.AlertType alertAlertType;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setContentText("Register success");
                alert.show();


            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }
    public void Reset(ActionEvent event){
        txtUserNameSingUp.setText("");
        txtPasswordSingUp.setText("");
        txtRePasswordSingUp.setText("");
    }
    public void Login(ActionEvent event) throws Exception{
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sampleLogin.fxml"));
        Parent loginView = loader.load();
        Scene scene = new Scene(loginView);
        stage.setScene(scene);
    }


}
