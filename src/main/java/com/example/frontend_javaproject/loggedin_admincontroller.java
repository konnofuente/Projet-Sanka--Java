package com.example.frontend_javaproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class loggedin_admincontroller implements Initializable {
    @FXML private Button btn_return;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    btn_return.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            
        }
    });

    }
}
