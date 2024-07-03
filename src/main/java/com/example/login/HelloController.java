package com.example.login;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;

public class HelloController implements Initializable {
    public TableView<user_auth> user_authTable;
    public TableColumn<user_auth,Integer> ID;
    public TableColumn <user_auth,String> UserName;
    public TableColumn <user_auth,String> Email;
    public TableColumn <user_auth,String> Password;
    public TextField uID;
    public TextField uUserName;
    public TextField uEmail;
    public TextField uPassword;
    @FXML
    private Label welcomeText;

    ObservableList<user_auth> list = FXCollections.observableArrayList();

    @FXML
    protected void onHelloButtonClick() {
        fethdata();
    }

    private void fethdata() {
        list.clear();

        String jdbcUrl = "jdbc:mysql://localhost:3306/ test 2 programming";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM user_auth";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("UserName");
                String email = resultSet.getString("Email");
                String password = resultSet.getString("Password");
                user_authTable.getItems().add(new user_auth(ID, UserName, Email, Password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ID.setCellValueFactory(new PropertyValueFactory<user_auth,Integer>("ID"));
        UserName.setCellValueFactory(new PropertyValueFactory<user_auth,String>("UserName"));
        Email.setCellValueFactory(new PropertyValueFactory<user_auth,String>("Email"));
        Password.setCellValueFactory(new PropertyValueFactory<user_auth,String>("Password"));
        user_authTable.setItems(list);


    }

    public void InsertData(ActionEvent actionEvent) {



        String name = uUserName.getText();
        String email = uEmail.getText();
        String password = uPassword.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/ test 2 programming";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `user_auth`( `UserName`, `Email`, `Password`) VALUES ('"+UserName+"','"+Email+"','"+Password+"')";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void UpdateData(ActionEvent actionEvent) {
        String id = uID.getText();
        String name = uUserName.getText();
        String email = uEmail.getText();
        String password = uPassword.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/test 2 programming";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "UPDATE `User_auth` SET `UserName`='"+UserName+"',`Email`='"+Email+"',`Password`='"+Password+"' WHERE ID='"+ID+"' ";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteData(ActionEvent actionEvent) {

        String id = uID.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/tset 2 programming";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM `user_auth` WHERE ID='"+ID+"'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void LoadData(ActionEvent actionEvent) {

        String id = uID.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/ test 2 programming";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM user_auth WHERE ID='"+ID+"'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {

                String name = resultSet.getString("UserName");
                String email = resultSet.getString("Email");
                String password = resultSet.getString("Password");

                uUserName.setText(name);
                uEmail.setText(email);
                uPassword.setText(password);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void loginClick(ActionEvent actionEvent) {
    }
}