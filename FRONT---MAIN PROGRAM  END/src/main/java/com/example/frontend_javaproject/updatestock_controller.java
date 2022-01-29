package com.example.frontend_javaproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class updatestock_controller implements Initializable {

    @FXML
    private Button btnupdate;

    @FXML
    private TextField idclinic;

    @FXML
    private TextField vaccine;

    @FXML
    private TextField taste;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btnupdate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.updatestock(actionEvent,Integer.parseInt(idclinic.getText()),Integer.parseInt(vaccine.getText()),Integer.parseInt(taste.getText()));
            }
        });


    }
}
