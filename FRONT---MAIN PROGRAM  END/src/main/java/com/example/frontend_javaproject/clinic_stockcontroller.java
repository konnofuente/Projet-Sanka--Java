package com.example.frontend_javaproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class clinic_stockcontroller implements Initializable {

    @FXML private Button btn_increase;

    @FXML private Button btn_available;

    @FXML private Button btnexit;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btnexit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"menu_clinic.fxml","CLINIC MANAGEMENT");
            }
        });

        btn_increase.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"updatestock.fxml","CLINIC MANAGEMENT");
            }
        });

    }
}
