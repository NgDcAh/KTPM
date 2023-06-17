package sample.ktpm;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ControllerTaiSanNVH  implements Initializable {

    @FXML
    TableView<TaiSanNVH> tableView;
    @FXML
    TableColumn<TaiSanNVH, Integer> idColumn;
    @FXML
    TableColumn<TaiSanNVH, String> tenColumn;
    @FXML
    TableColumn<TaiSanNVH, String> soLuongColumn;
    @FXML
    TableColumn<TaiSanNVH, String> tangColumn;
    @FXML
    TableColumn<TaiSanNVH, String > tinhTrangColumn;
    @FXML
    TableColumn<TaiSanNVH, String> ngayColumn;
    @FXML
    TextField txtKeyword;
    @FXML
    TextField txtSTT, txtTen, txtSoLuong;
    @FXML
    ComboBox<String> cbTinhTrang, cbTang;
    @FXML
    DatePicker dateNgay;

    TaiSanNVH taiSanNVH;

    ObservableList<TaiSanNVH> taiSanNVHList = FXCollections.observableArrayList();

    public void Them(){


        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection conn = databaseConnection.getConnection();

        String id = txtSTT.getText();
        String ten = txtTen.getText();
        String soLuong = txtSoLuong.getText();
        String tang = cbTang.getSelectionModel().getSelectedItem();
        String ngay = dateNgay.getEditor().getText();
        String tinhTrang = cbTinhTrang.getSelectionModel().getSelectedItem();
        if(id.isEmpty() || ten.isEmpty() || soLuong.isEmpty() || tang.isEmpty() || ngay.isEmpty() || tinhTrang.isEmpty()){
            Alert.AlertType alertAlertType;
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setContentText("Vui lòng nhập đầy đủ thông tin");
            alert.show();
        }
        else{
            try{
                String sql = "insert into taisannvh(id,ten ,soLuong, tang, tinhTrang, ngay ) values('"+id+"', '"+ten+"', '"+soLuong+"', '"+tang+"', '"+tinhTrang+"', '"+ngay+"')";
                Statement st = conn.createStatement();
                st.executeUpdate(sql);
                TaiSanNVH taiSanNVH = new TaiSanNVH();
                taiSanNVH.setId(Integer.valueOf(txtSTT.getText()));
                taiSanNVH.setTen(txtTen.getText());
                taiSanNVH.setTang(cbTang.getSelectionModel().getSelectedItem());
                taiSanNVH.setSoLuong(txtSoLuong.getText());
                taiSanNVH.setNgay(dateNgay.getEditor().getText());
                taiSanNVH.setTinhTrang(cbTinhTrang.getSelectionModel().getSelectedItem());
                taiSanNVHList.add(taiSanNVH);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }


    }
    public void CapNhat(){
        TaiSanNVH taiSanNVH = new TaiSanNVH();
        taiSanNVH = tableView.getSelectionModel().getSelectedItem();
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection conn = databaseConnection.getConnection();
        String id = txtSTT.getText();
        String ten = txtTen.getText();
        String soLuong = txtSoLuong.getText();
        String tang = cbTang.getSelectionModel().getSelectedItem();
        String ngay = dateNgay.getEditor().getText();
        String tinhTrang = cbTinhTrang.getSelectionModel().getSelectedItem();

        if(id.isEmpty() || ten.isEmpty() || soLuong.isEmpty() || tang.isEmpty() || ngay.isEmpty() || tinhTrang.isEmpty()){
            Alert.AlertType alertAlertType;
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setContentText("Vui lòng nhập đầy đủ thông tin");
            alert.show();
        }
        else{
            try{
                String sql = "UPDATE `taisannvh` SET `id`='"+id+"',`ten`='"+ten+"',`soLuong`='"+soLuong+"',`tang`='"+tang+"',`tinhTrang`='"+tinhTrang+"',`ngay`='"+ngay+"' WHERE id = '"+id+"'";
                Statement st = conn.createStatement();
                st.executeUpdate(sql);
                Alert.AlertType alertAlertType;
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Cập nhât thành công");
                alert.setContentText("Cập nhât thành công !!!!");
                alert.show();

                taiSanNVH.setId(Integer.valueOf(txtSTT.getText()));
                taiSanNVH.setTen(txtTen.getText());
                taiSanNVH.setTang(cbTang.getSelectionModel().getSelectedItem());
                taiSanNVH.setSoLuong(txtSoLuong.getText());
                taiSanNVH.setNgay(dateNgay.getEditor().getText());
                taiSanNVH.setTinhTrang(cbTinhTrang.getSelectionModel().getSelectedItem());
                taiSanNVHList.remove(taiSanNVH);
                taiSanNVHList.add(taiSanNVH);

            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }
    public void Xoa(){
        new TaiSanNVH();
        TaiSanNVH taiSanNVH = tableView.getSelectionModel().getSelectedItem();
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection conn = databaseConnection.getConnection();
        try{
            String sql = "delete from taisannvh where id = '"+taiSanNVH.getId()+"'";
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            taiSanNVHList.remove(taiSanNVH);
        }catch (SQLException e){
            e.printStackTrace();
        }


    }
    public void Reset(){
        txtSTT.setText("");
        txtTen.setText("");
        txtSoLuong.setText("");
        cbTang.setValue("");
        dateNgay.getEditor().setText("");
        cbTinhTrang.setValue("");


    }
    public void BackToNVH(ActionEvent event) throws  Exception{
        Stage stage = (Stage) ((Node) event.getSource() ).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sampleInfoMainNVH.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    public void chon(){
         new TaiSanNVH();
        TaiSanNVH taiSanNVH = tableView.getSelectionModel().getSelectedItem();
        txtSTT.setText(String.valueOf(taiSanNVH.getId()));
        txtTen.setText(taiSanNVH.getTen());
        txtSoLuong.setText(taiSanNVH.getSoLuong());
        cbTang.setValue(taiSanNVH.getTang());
        dateNgay.getEditor().setText(taiSanNVH.getNgay());
        cbTinhTrang.setValue(taiSanNVH.getTinhTrang());
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection conn = databaseConnection.getConnection();
        try{
            String sql = "select * from taiSanNVH";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                taiSanNVHList.add(new TaiSanNVH(rs.getInt("id"), rs.getString("ten"), rs.getString("soLuong"), rs.getString("tang"), rs.getString("tinhTrang"),  rs.getString("ngay")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        idColumn.setCellValueFactory(new PropertyValueFactory<TaiSanNVH, Integer>("id"));
        tenColumn.setCellValueFactory(new PropertyValueFactory<TaiSanNVH, String>("ten"));
        soLuongColumn.setCellValueFactory(new PropertyValueFactory<TaiSanNVH, String>("soLuong"));
        tangColumn.setCellValueFactory(new PropertyValueFactory<TaiSanNVH, String>("tang"));
        tangColumn.setCellValueFactory(new PropertyValueFactory<TaiSanNVH, String>("tang"));
        ngayColumn.setCellValueFactory(new PropertyValueFactory<TaiSanNVH, String>("ngay"));
        tinhTrangColumn.setCellValueFactory(new PropertyValueFactory<TaiSanNVH, String>("tinhTrang"));

        tableView.setItems(taiSanNVHList);

        FilteredList<TaiSanNVH> filterData =new FilteredList<>(taiSanNVHList, b -> true);
        txtKeyword.textProperty().addListener((observableValue,oldValue, newValue) ->{
            filterData.setPredicate(taiSanNVH -> {
                if(newValue.isEmpty() || newValue.isBlank() || newValue == null){
                    return true;
                }
                String timKiem = newValue.toLowerCase();
                if(taiSanNVH.getId().toString().indexOf(timKiem) > -1){
                    return true;
                }
                else if(taiSanNVH.getTen().toLowerCase().indexOf(timKiem) > -1){
                    return true;
                }
                else if(taiSanNVH.getSoLuong().toLowerCase().indexOf(timKiem) > -1){
                    return true;
                }
                else if(taiSanNVH.getTang().toLowerCase().indexOf(timKiem) > -1){
                    return true;
                }
                 else if (taiSanNVH.getNgay().toLowerCase().indexOf(timKiem) > -1) {
                    return true;
                } else if (taiSanNVH.getTinhTrang().toLowerCase().indexOf(timKiem) > -1) {

                    return true;
                }
                else{
                    return false;
                }
            });
        });
        SortedList<TaiSanNVH> sortedData =new SortedList<>(filterData);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedData);

        cbTang.getItems().add("Tầng 1");
        cbTang.getItems().add("Tầng 2");
        cbTinhTrang.getItems().add("Sử dụng tốt");
        cbTinhTrang.getItems().add("Hỏng");
    }
}
