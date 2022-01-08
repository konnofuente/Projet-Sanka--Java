package com.example.frontend_javaproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class mainpagecontroller implements Initializable {


    @FXML
    private Button btn_admin;
    @FXML
    private Button btn_service;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btn_admin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"admin-login.fxml");
            }
        });

        btn_service.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               DBUtils.changeover(actionEvent, "2servicepage.fxml");
            }
        });


    }
}