package com.example.frontend_javaproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
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
                DBUtils.logInUser(actionEvent,tfadmin_mat.getText(),tfadmin_pwd.getText());
            }
        });

    }
}
