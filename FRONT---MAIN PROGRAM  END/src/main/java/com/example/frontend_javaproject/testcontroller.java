package com.example.frontend_javaproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class testcontroller implements Initializable {
    @FXML private Button btnpositive;

    @FXML private Button btnnegative;

    @FXML private Button btnvaccinate;

    @FXML private Button btnexit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btnvaccinate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"vaccination.fxml","CLIENT MANAGEMENT");
            }
        });

        btnexit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeover(actionEvent,"2servicepage.fxml","CLIENT MANAGEMENT");
            }
        });

    }
}
