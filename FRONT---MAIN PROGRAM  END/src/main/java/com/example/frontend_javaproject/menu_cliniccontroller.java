package com.example.frontend_javaproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class menu_cliniccontroller implements Initializable {

    @FXML private Button btncreate;

    @FXML private Button btnstock;

    @FXML private Button btnexit;

    @FXML private Button btnreturn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        btnexit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"logged_admin.fxml","ADMINISTRATOR");
            }
        });


        btnreturn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"logged_admin.fxml","ADMINISTRATOR");
            }
        });


        btnstock.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"update_clinic.fxml","CLINIC MANAGEMENT");
            }
        });

        btncreate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"create_clinic.fxml","CLINIC MANAGEMENT");
            }
        });

    }
}
