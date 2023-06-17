package sample.ktpm;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControllerDanhMuc {
    public void QLCovid19(ActionEvent event )throws Exception{
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sampleInfoMain.fxml"));
        Parent root1 = loader.load();
        Scene scene = new Scene(root1);
        stage.setTitle("Danh mục quản lí");
        stage.setScene(scene);
        stage.show();

    }
    public void QLSuDungNhaVanHoa(ActionEvent event) throws Exception{
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sampleInfoMainNVH.fxml"));
        Parent root1 = loader.load();
        Scene scene = new Scene(root1);
        stage.setTitle("Quản lí nhà văn hóa");
        stage.setScene(scene);
        stage.show();
    }

}
