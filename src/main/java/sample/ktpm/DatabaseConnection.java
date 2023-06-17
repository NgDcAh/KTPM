package sample.ktpm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {
    public Connection conn;

    public Connection getConnection(){


        String username = "root";
        String password = "";
        String dbUrl = "jdbc:mysql://localhost/dbconnect";

        try{
            conn = (Connection) DriverManager.getConnection(dbUrl, username, password);
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

        return conn;
    }
}
