package com.example.frontend_javaproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class updatestock_controller implements Initializable {

    @FXML
    private Button btncancel;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btncancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"menu_clinic.fxml","CLINIC MANAGEMENT");
            }
        });

    }
}
