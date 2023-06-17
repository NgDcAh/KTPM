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
import java.sql.*;
import java.util.ResourceBundle;

public class ControllerInfoMainNVH implements Initializable {
    @FXML
    TableView<NVH> tableView;
    @FXML
    TableColumn<NVH, Integer> idColumn;
    @FXML
    TableColumn<NVH, String> hoatDongColumn;
    @FXML
    TableColumn<NVH, String> tangColumn;
    @FXML
    TableColumn<NVH, String> daiDienThueColumn;
    @FXML
    TableColumn<NVH, String> ngayThueColumn;
    @FXML
    TableColumn<NVH, Integer> chiPhiColumn;
    @FXML
    TableColumn<NVH, String> pheDuyetColumn;
    @FXML
    TextField txtSTT, txtHoatDong, txtDaiDienThue, txtChiPhi;
    @FXML
    ComboBox<String> cbPheDuyet, cbTang;
    @FXML
    TextField txtKeyword;
    @FXML
    DatePicker dateNgayThue;
    ObservableList<NVH> nvhList = FXCollections.observableArrayList();
    NVH nvh;

    public void Them(ActionEvent event){


        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection conn = databaseConnection.getConnection();

        String id = txtSTT.getText();
        String hoatDong = txtHoatDong.getText();
        String tang = cbTang.getSelectionModel().getSelectedItem();
        String daiDienThue = txtDaiDienThue.getText();
        String ngayThue = dateNgayThue.getEditor().getText();
        String chiPhi = txtChiPhi.getText();
        String pheDuyet = cbPheDuyet.getSelectionModel().getSelectedItem();

        if(id.isEmpty()|| hoatDong.isEmpty() || tang.isEmpty() || daiDienThue.isEmpty() || ngayThue.isEmpty() || chiPhi.isEmpty() || pheDuyet.isEmpty()){
            Alert.AlertType alertAlertType;
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Đã xảy ra lỗi");
            alert.setContentText("Vui lòng nhập đầy đủ thông tin");
            alert.show();
        }
        else{
            try{
                String sql = "insert into nvh(id, hoatDong, tang, daiDienThue,ngayThue, chiPhi, pheDuyet ) values('"+id+"', '"+hoatDong+"', '"+tang+"', '"+daiDienThue+"', '"+ngayThue+"', '"+chiPhi+"', '"+pheDuyet+"')";
                Statement st = conn.createStatement();
                st.executeUpdate(sql);
                NVH nvh = new NVH();
                nvh.setId(Integer.valueOf(txtSTT.getText()));
                nvh.setHoatDong(txtHoatDong.getText());
                nvh.setTang(cbTang.getSelectionModel().getSelectedItem());
                nvh.setDaiDienThue(txtDaiDienThue.getText());
                nvh.setNgayThue(dateNgayThue.getEditor().getText());
                nvh.setChiPhi(Integer.valueOf(txtChiPhi.getText()));
                nvh.setPheDuyet(cbPheDuyet.getSelectionModel().getSelectedItem());
                nvhList.add(nvh);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }


    }
    public void Xoa(){
        NVH nvh = new NVH();
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection conn = databaseConnection.getConnection();
        try{
            nvh = tableView.getSelectionModel().getSelectedItem();
            String sql = "delete from nvh where id = '"+nvh.getId()+"'";
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            nvhList.remove(nvh);
        }catch (SQLException e){
            e.printStackTrace();
        }


    }
    public void CapNhat(){
        NVH nvh = new NVH();
        nvh = tableView.getSelectionModel().getSelectedItem();
        String id = txtSTT.getText();
        String hoatDong = txtHoatDong.getText();
        String tang = cbTang.getSelectionModel().getSelectedItem();
        String daiDienThue = txtDaiDienThue.getText();
        String ngayThue = dateNgayThue.getEditor().getText();
        String chiPhi = txtChiPhi.getText();
        String pheDuyet = cbPheDuyet.getSelectionModel().getSelectedItem();
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection conn = databaseConnection.getConnection();
        if(id.isEmpty()|| hoatDong.isEmpty() || tang.isEmpty() || daiDienThue.isEmpty() || ngayThue.isEmpty() || chiPhi.isEmpty() || pheDuyet.isEmpty()){
            Alert.AlertType alertAlertType;
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Đã xảy ra lỗi");
            alert.setContentText("Vui lòng nhập đầy đủ thông tin");
            alert.show();
        }
        else {
            try{

                String sql = "update nvh set id = '"+id+"', hoatDong = '"+hoatDong+"', tang = '"+tang+"', daiDienThue = '"+daiDienThue+"', ngayThue = '"+ngayThue+"', chiPhi = '"+chiPhi+"', pheDuyet = '"+pheDuyet+"' where id = '"+id+"' ";
                Statement st = conn.createStatement();
                st.executeUpdate(sql);nvh.setId(Integer.valueOf(txtSTT.getText()));
                nvh.setHoatDong(txtHoatDong.getText());
                nvh.setTang(cbTang.getSelectionModel().getSelectedItem());
                nvh.setDaiDienThue(txtDaiDienThue.getText());
                nvh.setNgayThue(dateNgayThue.getEditor().getText());
                nvh.setChiPhi(Integer.valueOf(txtChiPhi.getText()));
                nvh.setPheDuyet(cbPheDuyet.getSelectionModel().getSelectedItem());
                nvhList.remove(nvh);
                nvhList.add(nvh);

            }catch(SQLException e){
                e.printStackTrace();
            }
        }


    }
    public void Reset(){
        txtSTT.setText("");
        txtHoatDong.setText("");
        cbTang.setValue("");
        txtDaiDienThue.setText("");
        dateNgayThue.getEditor().setText("");
        txtChiPhi.setText("");
        cbPheDuyet.setValue("");

    }
    public void quanLiCoSoVatChat(ActionEvent event) throws Exception{
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sampleTaiSanNVH.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Quản lí tài sản nhà văn hóa");
        stage.setScene(scene);

    }
    public void chon(){
        new NVH();
        NVH nvh = tableView.getSelectionModel().getSelectedItem();
        txtSTT.setText(String.valueOf(nvh.getId()));
        txtHoatDong.setText(nvh.getHoatDong());
        cbTang.setValue(nvh.getTang());
        txtDaiDienThue.setText(nvh.getDaiDienThue());
        dateNgayThue.getEditor().setText(nvh.getNgayThue());
        txtChiPhi.setText(String.valueOf(nvh.getChiPhi()));
        cbPheDuyet.setValue(nvh.getPheDuyet());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection conn = databaseConnection.getConnection();
        try{
            String sql = "select * from nvh";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                nvhList.add(new NVH(rs.getInt("id"), rs.getString("hoatDong"), rs.getString("tang"), rs.getString("daiDienThue"), rs.getString("ngayThue"), rs.getInt("chiPhi"), rs.getString("pheDuyet")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        idColumn.setCellValueFactory(new PropertyValueFactory<NVH, Integer>("id"));
        hoatDongColumn.setCellValueFactory(new PropertyValueFactory<NVH, String>("hoatDong"));
        tangColumn.setCellValueFactory(new PropertyValueFactory<NVH, String>("tang"));
        daiDienThueColumn.setCellValueFactory(new PropertyValueFactory<NVH, String>("daiDienThue"));
        ngayThueColumn.setCellValueFactory(new PropertyValueFactory<NVH, String>("ngayThue"));
        chiPhiColumn.setCellValueFactory(new PropertyValueFactory<NVH, Integer>("chiPhi"));
        pheDuyetColumn.setCellValueFactory(new PropertyValueFactory<NVH, String>("pheDuyet"));

        tableView.setItems(nvhList);

        FilteredList<NVH> filterData =new FilteredList<>(nvhList, b -> true);
        txtKeyword.textProperty().addListener((observableValue,oldValue, newValue) ->{
            filterData.setPredicate(nvh -> {
                if(newValue.isEmpty() || newValue.isBlank() || newValue == null){
                    return true;
                }
                String timKiem = newValue.toLowerCase();
                if(nvh.getId().toString().indexOf(timKiem) > -1){
                    return true;
                }
                else if(nvh.getHoatDong().toLowerCase().indexOf(timKiem) > -1){
                    return true;
                }
                else if(nvh.getTang().toLowerCase().indexOf(timKiem) > -1){
                    return true;
                }
                else if(nvh.getDaiDienThue().toLowerCase().indexOf(timKiem) > -1){
                    return true;
                } else if (nvh.getNgayThue().toLowerCase().indexOf(timKiem) > -1) {
                    return true;
                } else if (nvh.getChiPhi().toString().indexOf(timKiem) > -1) {
                    return true;
                } else if (nvh.getPheDuyet().toLowerCase().indexOf(timKiem) > -1) {

                    return true;
                }
                else{
                    return false;
                }
            });
        });
        SortedList<NVH>sortedData =new SortedList<>(filterData);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedData);

        cbTang.getItems().add("Tầng 1");
        cbTang.getItems().add("Tầng 2");
        cbPheDuyet.getItems().add("Đã phê duyệt");
        cbPheDuyet.getItems().add("Chưa phê duyệt");
    }
}
