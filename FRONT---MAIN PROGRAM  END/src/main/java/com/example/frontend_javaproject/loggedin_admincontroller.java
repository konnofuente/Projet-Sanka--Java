package com.example.frontend_javaproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class loggedin_admincontroller implements Initializable {



    @FXML private Button btn_client;

    @FXML private Button btn_clinic;



    @FXML private Button btn_stock;

    @FXML private Button btn_return;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btn_return.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"admin-login.fxml","LOG IN ADMIN");
            }
        });





        btn_clinic.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"update_clinic.fxml","MENU CLINIC");
        }
        });

         btn_client.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent actionEvent) {
                 DBUtils.changeover(actionEvent,"update_client.fxml","CLINIC");
             }
         });

    }

}
