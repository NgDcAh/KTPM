module sample.ktpm {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens sample.ktpm to javafx.fxml;
    exports sample.ktpm;
}