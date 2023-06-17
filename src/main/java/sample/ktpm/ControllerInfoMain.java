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

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;



public class ControllerInfoMain implements Initializable {
    @FXML
    TableView<User> tableView;
    @FXML
    TableColumn<User, String> tableColumnName;
    @FXML
    TableColumn<User, String> tableColumnYearOfBirth;
    @FXML
    TableColumn<User, String> tableColumnGender;
    @FXML
    TableColumn<User, String> tableColumnAddress;
    @FXML
    TableColumn<User, Integer> tableColumnId;
    @FXML
    TableColumn<User, String> tableColumntgTest;
    @FXML
    TableColumn<User, String> tableColumnBieuHien;
    @FXML
    TableColumn<User, String> tableColumnTiepXuc;
    @FXML
    TableColumn<User, String> tableColumnMucDo;
    @FXML
    TableColumn<User, String> tableColumnTestCovid;
    @FXML
    TableColumn<User, String> tableColumnhtTest;
    @FXML
    TableColumn<User, String> tableColumnTinhTrang;
    @FXML
    TableColumn<User, String> tableColumnNoiTest;
    @FXML
    TableColumn<User, String> tableColumnCachLy;
    @FXML
    TableColumn<User, String> tableColumntgCachLy;
    @FXML
    TableColumn<User, String> tableColumnNoiCachLy;
    User user;
    @FXML
    TextField txtKeyword;
    private ObservableList<User> userList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection conn = databaseConnection.getConnection();
        try {

            String sql = "select * from user";
            Statement st = (Statement) conn.createStatement();
            ResultSet rs =   ((java.sql.Statement) st).executeQuery(sql);
            while (rs.next()) {

                userList.add(new User(rs.getInt("id"),rs.getString("name"), rs.getString("yearOfBirth"), rs.getString("gender"), rs.getString("address"), rs.getString("bieuHien"),rs.getString("tiepXuc"), rs.getString("mucDo"), rs.getString("testCovid"),rs.getString("tinhTrang"),rs.getString("hinhThucTest"),rs.getString("thoiGianTest"), rs.getString("noiTest"), rs.getString("cachLy"),rs.getString("thoiGianCachLy"), rs.getString("noiCachLy")));
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        tableColumnId.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        tableColumnName.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        tableColumnYearOfBirth.setCellValueFactory(new PropertyValueFactory<User, String>("yearOfBirth"));
        tableColumnGender.setCellValueFactory(new PropertyValueFactory<User, String>("gender"));
        tableColumnAddress.setCellValueFactory(new PropertyValueFactory<User, String>("address"));
        tableColumntgTest.setCellValueFactory(new PropertyValueFactory<User, String>("thoiGianTest"));
        tableColumnBieuHien.setCellValueFactory(new PropertyValueFactory<User, String>("bieuHien"));
        tableColumnTiepXuc.setCellValueFactory(new PropertyValueFactory<User, String>("tiepXuc"));
        tableColumnMucDo.setCellValueFactory(new PropertyValueFactory<User, String>("MucDo"));
        tableColumnTestCovid.setCellValueFactory(new PropertyValueFactory<User, String>("testCovid"));
        tableColumnhtTest.setCellValueFactory(new PropertyValueFactory<User, String>("hinhThucTest"));
        tableColumnTinhTrang.setCellValueFactory(new PropertyValueFactory<User, String>("tinhTrang"));
        tableColumnNoiTest.setCellValueFactory(new PropertyValueFactory<User, String>("noiTest"));
        tableColumnCachLy.setCellValueFactory(new PropertyValueFactory<User, String>("cachLy"));
        tableColumntgCachLy.setCellValueFactory(new PropertyValueFactory<User, String>("thoiGianCachLy"));
        tableColumnNoiCachLy.setCellValueFactory(new PropertyValueFactory<User, String>("noiCachLy"));

        tableView.setItems(userList);

        FilteredList<User> filterData =new FilteredList<>(userList, b -> true);
        txtKeyword.textProperty().addListener((observableValue,oldValue, newValue) ->{
            filterData.setPredicate(user -> {
                if(newValue.isEmpty() || newValue.isBlank() || newValue == null){
                    return true;
                }
                String timKiem = newValue.toLowerCase();
                if(user.getId().toString().indexOf(timKiem) > -1){
                    return true;
                }
                else if(user.getName().toLowerCase().indexOf(timKiem) > -1){
                    return true;
                }
                else if(user.getGender().toLowerCase().indexOf(timKiem) > -1){
                    return true;
                }
                else if(user.getAddress().toLowerCase().indexOf(timKiem) > -1){
                    return true;
                } else if (user.getYearOfBirth().toLowerCase().indexOf(timKiem) > -1) {
                    return true;
                } else if (user.getBieuHien().toLowerCase().indexOf(timKiem) > -1) {
                    return true;
                } else if (user.getTiepXuc().toLowerCase().indexOf(timKiem) > -1) {
                    return true;
                }
                else if(user.getMucDo().toLowerCase().indexOf(timKiem) > -1){
                    return true;
                }
                else if(user.getTestCovid().toLowerCase().indexOf(timKiem) > -1){
                    return true;
                }
                else if(user.getTinhTrang().toLowerCase().indexOf(timKiem) > -1){
                    return true;
                }
                else if(user.getHinhThucTest().toLowerCase().indexOf(timKiem) > -1){
                    return true;
                }
                else if(user.getThoiGianTest().toLowerCase().indexOf(timKiem) > -1){
                    return true;
                }
                else if(user.getNoiTest().toLowerCase().indexOf(timKiem) > -1){
                    return true;
                }
                else if(user.getCachLy().toLowerCase().indexOf(timKiem) > -1){
                    return true;
                }
                else if(user.getNoiCachLy().toLowerCase().indexOf(timKiem) > -1){
                    return true;
                }
                else if(user.getThoiGianCachLy().toLowerCase().indexOf(timKiem) > -1){
                    return true;
                }

                else{
                    return false;
                }
            });
        });
        SortedList<User> sortedData =new SortedList<>(filterData);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedData);


    }
    public void QuayLai(ActionEvent event) throws Exception{
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sampleBoxUser.fxml"));
        Parent boxUserView = loader.load();
        Scene scene = new Scene(boxUserView);
        stage.setScene(scene);
        stage.show();
    }
    public void Add(ActionEvent event) throws Exception {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sampleBoxUser.fxml"));
        Parent boxUserView = loader.load();
        Scene scene = new Scene(boxUserView);
        stage.setScene(scene);
        stage.setTitle("Thêm thông tin");
        stage.show();

    }
    public void Delete(ActionEvent event){

        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection conn = databaseConnection.getConnection();
        try{
            user = tableView.getSelectionModel().getSelectedItem();
            String sql = "delete from  user where id = '"+user.getId()+"'" ;
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            userList.remove(user);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void Update(ActionEvent event) throws  Exception {

        Stage stage = (Stage) ((Node)event.getSource() ).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sampleSuaUser.fxml"));
        Parent updateView = loader.load();
        Scene scene = new Scene(updateView);
        user = tableView.getSelectionModel().getSelectedItem();
        ControllerUpdateUser controllerUpdateUser = loader.<ControllerUpdateUser>getController();
        controllerUpdateUser.setUser(user);
        stage.setScene(scene);
    }

    public void Search(ActionEvent event){

    }
}
