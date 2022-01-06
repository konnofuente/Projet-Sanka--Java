package com.example;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class admin_logincontrol implements Initializable {


    @FXML private Button btnlogin_admin;

    @FXML private TextField tfadmin_mat;

    @FXML private TextField tfadmin_pwd;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnlogin_admin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    DBUtils.logInUser(actionEvent,tfadmin_mat.getText(),tfadmin_pwd.getText());
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
