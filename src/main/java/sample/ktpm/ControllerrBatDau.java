package sample.ktpm;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControllerrBatDau {
    public void dangNhap(ActionEvent event) throws  Exception{
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sampleLogin.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Đăng nhập");
        stage.setScene(scene);
    }
    public void dangKi(ActionEvent event) throws  Exception{
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sampleAddLogin.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Đăng kí");
        stage.setScene(scene);
    }

}
